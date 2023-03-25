import {LEETCODE_PROBLEM_BASE_URL} from "../constants";
import React from "react";


function Task(props) {
    return (
        <li key={props.slug} className={`alert ${getAlertClass(props.difficulty)}`}>
            <span>
                <a href={`${LEETCODE_PROBLEM_BASE_URL}/${props.slug}`} target={"_blank"}>
                    {props.title}
                </a>
                <a href={`${LEETCODE_PROBLEM_BASE_URL}/${props.slug}/submissions/${props.submissionId}`} target={"_blank"}>
                    <button className={"btn btn-outline-success btn-sm btn-solution"}>View solution</button>
                </a>
            </span>
        </li>
    );
}

function getAlertClass(difficulty) {
    switch (difficulty) {
        case "EASY":
            return "alert-success";
        case "MEDIUM":
            return "alert-warning";
        case "HARD":
            return "alert-danger";
        default:
            return "alert-success";
    }
}

export default Task;