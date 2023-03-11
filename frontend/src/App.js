import React, {useEffect, useState} from "react";

const SESSION_URL = 'http://localhost:8080/getChallengeStatus/session/main';
const LEETCODE_PROBLEM_BASE_URL = 'https://leetcode.com/problems';

function App() {

    const [data, setData] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(false);

    useEffect(() => {
        fetch(SESSION_URL)
            .then(response => response.json())
            .then(data => {
                setData(data);
                setLoading(false);
            })
            .catch(reason => {
                setError(true);
            });
    }, []);

    if (loading) {
        return <div>Loading...</div>;
    }

    if (error) {
        return <div>Error: {error.toString()}</div>;
    }

    return (
        <div>
            {data.map((entry, idx) => (
                <div key={idx} className={"card user-entry"}>
                    <div className={"card-header"}>
                        <h5 className={"card-title"}>User: {entry.username}</h5>
                        <span className={`result badge ${getBadgeClass(entry.hasTheChallengeDone)}`}>
                            {entry.hasTheChallengeDone ? "done" : "not done"}
                        </span>
                    </div>
                    <ul>
                        {entry.solvedTasks.map(item => (
                            <li key={item.task.slug} className={`alert ${getAlertClass(item.task.difficulty)}`}>
                                <span>
                                    <a href={`${LEETCODE_PROBLEM_BASE_URL}/${item.task.slug}`}>{item.task.title}</a>
                                </span>
                            </li>
                        ))}
                    </ul>
                </div>
            ))}
        </div>
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


function getBadgeClass(hasTheChallengeDone) {
    return hasTheChallengeDone ? "text-bg-success" : "text-bg-danger";
}

export default App;
