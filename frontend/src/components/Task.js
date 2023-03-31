import {LEETCODE_PROBLEM_BASE_URL} from "../constants";
import React from "react";


function Task({ title, slug, difficulty, submissionId }) {
    return (
        <li key={slug} className={`alert ${getAlertClass(difficulty)}`}>
            <span>
                <a href={`${LEETCODE_PROBLEM_BASE_URL}/${slug}`} target={"_blank"}>
                    {title}
                </a>
                <a href={`${LEETCODE_PROBLEM_BASE_URL}/${slug}/submissions/${submissionId}`} target={"_blank"}>
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