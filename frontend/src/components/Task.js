import {LEETCODE_PROBLEM_BASE_URL} from "../constants";
import React from "react";

export default function Task({ title, slug, difficulty, submissionId }) {
    return (
        <li key={slug} className={`alert ${getAlertClass(difficulty)} task-entry`}>
            <div className={"task-name"}>
                <a href={`${LEETCODE_PROBLEM_BASE_URL}/${slug}`} target={"_blank"}>
                    {title}
                </a>
            </div>
            <div className={"task-solution"}>
                <a href={`${LEETCODE_PROBLEM_BASE_URL}/${slug}/submissions/${submissionId}`} target={"_blank"}>
                    <button className={"btn btn-outline-success btn-sm btn-solution"}>
                        Solution
                    </button>
                </a>
            </div>
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