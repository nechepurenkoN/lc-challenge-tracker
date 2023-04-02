import {LEETCODE_PROBLEM_BASE_URL} from "../constants";
import React from "react";


function stripTitle(title) {
    if (title.length < 50)
        return title;

    return title.substring(0, 48) + "...";
}

export default function Task({ title, slug, difficulty, submissionId }) {
    return (
        <li key={slug} className={`alert ${getAlertClass(difficulty)} task-entry`}>
            <span>
                <a href={`${LEETCODE_PROBLEM_BASE_URL}/${slug}`} target={"_blank"}>
                    {stripTitle(title)}
                </a>
                <a href={`${LEETCODE_PROBLEM_BASE_URL}/${slug}/submissions/${submissionId}`} target={"_blank"}>
                    <button className={"btn btn-outline-success btn-sm btn-solution"} style={{float: "right"}}>
                        Solution
                    </button>
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