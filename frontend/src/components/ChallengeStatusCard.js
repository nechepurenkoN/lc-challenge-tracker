import {LEETCODE_BASE_URL} from "../constants";
import StatusBadge from "./StatusBadge";
import Task from "./Task";
import React from "react";
import HeatMap from "./HeatMap";

function ChallengeStatusCard({ idx, entry }) {
    return (
        <div key={idx} className={"card user-entry"}>
            <div className={"card-header"}>
                <h5 className={"card-title"}><a href={`${LEETCODE_BASE_URL}/${entry.username}`}
                                                      target={"_blank"}>
                    {entry.username}
                </a>
                </h5>
                <StatusBadge status={entry.hasTheChallengeDone} />
                <HeatMap solvedTasks={entry.solvedTasks} />
            </div>
            <ul>
                {entry.solvedTasks.map(item => (
                    <Task title={item.task.title}
                          slug={item.task.slug}
                          difficulty={item.task.difficulty}
                          submissionId={item.submissionId}
                          key={item.task.slug}/>
                ))}
            </ul>
        </div>
    );
}

export default ChallengeStatusCard;