import {LEETCODE_BASE_URL} from "../constants";
import StatusBadge from "./StatusBadge";
import Task from "./Task";
import React from "react";

function ChallengeStatusCard(props) {
    return (
        <div key={props.idx} className={"card user-entry"}>
            <div className={"card-header"}>
                <h5 className={"card-title"}>User: <a href={`${LEETCODE_BASE_URL}/${props.entry.username}`}
                                                      target={"_blank"}>
                    {props.entry.username}
                </a>
                </h5>
                <StatusBadge status={props.entry.hasTheChallengeDone} />
            </div>
            <ul>
                {props.entry.solvedTasks.map(item => (
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