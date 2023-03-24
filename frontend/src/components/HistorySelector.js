import React, {useEffect, useState} from "react";
import {HISTORY_URL} from "../constants";

export default function HistorySelector(props) {

    const [historyList, setHistoryList] = useState({});
    const [historyListLoading, setHistoryListLoading] = useState(true);
    const [historyListError, setHistoryListError] = useState(false);

    useEffect(() => {
        fetch(HISTORY_URL)
            .then(response => response.json())
            .then(data => {
                setHistoryList(data);
                setHistoryListLoading(false);
            })
            .catch(reason => {
                setHistoryListError(reason);
                setHistoryListLoading(false)
            });
    }, []);

    if (historyListLoading) {
        return <nav className="navbar navbar-light bg-light">
            Loading
        </nav>
    }

    if (historyListError) {
        return (
            <nav className="navbar navbar-light bg-red">
                Error
            </nav>
        );
    }

    return (
        <nav className="navbar navbar-light">
            <HistoryButtonGroup historyList={historyList} />
        </nav>
    );
}

function HistoryButtonGroup(props) {

    const [clickedId, setClickedId] = useState(0);

    const handleClick = (event, buttonId) => {
        setClickedId(buttonId);
    };

    return (
        <form className="form-inline">
            <HistoryButton
                key={"current"}
                text={"Current state"}
                onClick={handleClick}
                activeState={0 === clickedId}
                index={0}
            />
            <span> | </span>
            {props.historyList.map((historyEntry, idx) => (
                    <HistoryButton key={idx}
                                   text={historyEntry.formattedDateRange}
                                   onClick={handleClick}
                                   activeState={idx + 1 === clickedId}
                                   index={idx + 1}
                    />
                )
            )}
        </form>
    );
}

function HistoryButton(props) {
    const historyButtonClassList = "btn btn-outline-primary btn-sm btn-history";
    const historyActiveButtonClassList = "btn btn-outline-primary btn-sm active btn-history";

    return (
        <button className={props.activeState ? historyActiveButtonClassList : historyButtonClassList}
                type="button"
                onClick={ev => props.onClick(ev, props.index)}
        >
            {props.text}
        </button>
    );
}