import React from "react";

function StatusBadge({ status }) {
    return (
        <span className={`result badge ${getBadgeClass(status)}`}>
            {status ? "done" : "not done"}
        </span>
    );
}

function getBadgeClass(hasTheChallengeDone) {
    return hasTheChallengeDone ? "text-bg-success" : "text-bg-danger";
}

export default StatusBadge;