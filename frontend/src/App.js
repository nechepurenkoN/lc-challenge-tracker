import logo from './logo.svg';
import './App.css';
import {useEffect, useState} from "react";

function App() {

  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetch('http://localhost:8080/getChallengeStatus/nechn')
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
    <div className="App">
      <span className="result">Challenge result: {data.hasTheChallengeDone ? "done" : "not done"}</span>
      <ul>
        {data.solvedTasks.map(item => (
            <li key={item.task.slug}>
                <span>{item.task.title} {item.task.difficulty} {item.timestamp}</span>
            </li>
        ))}
      </ul>
    </div>
  );
}

export default App;
