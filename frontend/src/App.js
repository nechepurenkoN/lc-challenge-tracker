import React, {useState} from "react";
import HistorySelector from "./components/HistorySelector";
import ChallengeBody from "./components/ChallengeBody";


function App() {

    const [bodyState, setBodyState] = useState("current");

    return (
        <div>
            <HistorySelector setBodyState={setBodyState} />
            <ChallengeBody bodyState={bodyState} />
        </div>
    );
}

export default App;
