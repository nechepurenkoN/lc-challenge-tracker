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
            <form className="form-inline">
                <HistoryButton key={"current"} text={"Current state"}/>
                <span> | </span>
                {historyList.map((historyEntry, idx) => (
                        <HistoryButton key={idx} text={historyEntry.formattedDateRange}/>
                    )
                )}
            </form>
        </nav>
    );
}

function HistoryButton(props) {
    const historyButtonClassList = "btn btn-outline-primary btn-sm btn-history";
    const historyActiveButtonClassList = "btn btn-outline-primary btn-sm active btn-history";

    const [historyButtonActive, setHistoryButtonActive] = useState(false);

    const handleClick = ev => {
        setHistoryButtonActive(true);
    };

    return (
        <button className={historyButtonActive ? historyActiveButtonClassList : historyButtonClassList}
                type="button"
                onClick={handleClick}>
            {props.text}
        </button>
    );
}