import React from "react";

function StatusBadge(props) {
    return (
        <span className={`result badge ${getBadgeClass(props.status)}`}>
            {props.status ? "done" : "not done"}
        </span>
    );
}

function getBadgeClass(hasTheChallengeDone) {
    return hasTheChallengeDone ? "text-bg-success" : "text-bg-danger";
}

export default StatusBadge;