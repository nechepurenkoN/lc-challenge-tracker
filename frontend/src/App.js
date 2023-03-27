import React, {useState} from "react";
import HistorySelector from "./components/HistorySelector";
import ChallengeBody from "./components/ChallengeBody";


function App() {

    const [bodyState, setBodyState] = useState({});

    return (
        <div>
            <HistorySelector />
            <ChallengeBody />
        </div>
    );
}

export default App;
