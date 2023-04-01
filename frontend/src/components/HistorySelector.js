import React, {useEffect, useState} from "react";
import {HISTORY_URL} from "../constants";

export default function HistorySelector({ setBodyState }) {

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
            <HistoryButtonGroup historyList={historyList} setBodyState={setBodyState} />
        </nav>
    );
}

function HistoryButtonGroup({ setBodyState, historyList }) {

    const [clickedId, setClickedId] = useState(0);

    const handleClick = (event, buttonId) => {
        setClickedId(buttonId);
        setBodyState(buttonId === 0 ? "current" : historyList[buttonId - 1].id);
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
            <span className={"history-separator"}> | </span>
            {historyList.map((historyEntry, idx) => (
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

function HistoryButton({ activeState, onClick, index, text }) {
    const historyButtonClassList = "btn btn-outline-primary btn-sm btn-history";
    const historyActiveButtonClassList = "btn btn-outline-primary btn-sm active btn-history";

    return (
        <button className={activeState ? historyActiveButtonClassList : historyButtonClassList}
                type="button"
                onClick={ev => onClick(ev, index)}
        >
            {text}
        </button>
    );
}