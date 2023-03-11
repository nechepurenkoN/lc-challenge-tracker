import './App.css';
import {useEffect, useState} from "react";

function App() {

    const [data, setData] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        fetch('http://localhost:8080/getChallengeStatus/session/main')
            .then(response => response.json())
            .then(data => {
                setData(data);
                setLoading(false);
            });
    }, []);

    if (loading) {
        return <div>Loading...</div>;
    }

    return (
        <div>
            {data.map((entry, idx) => (
                <div key={idx}>
                    <span className="result">Challenge result: {entry.hasTheChallengeDone ? "done" : "not done"}</span>
                    <ul>
                        {entry.solvedTasks.map(item => (
                            <li key={item.task.slug}>
                                <span>{item.task.title} {item.task.difficulty} {item.timestamp}</span>
                            </li>
                        ))}
                    </ul>
                </div>
            ))}
        </div>
    );
}

export default App;
