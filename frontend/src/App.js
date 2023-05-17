import React, {useState} from "react";
import HistorySelector from "./components/HistorySelector";
import ChallengeBody from "./components/ChallengeBody";
import Loader from "./components/Loader";


function App() {

    const [bodyState, setBodyState] = useState("current");
    const [isLoading, setIsLoading] = useState(false)

    return (
        <div>
            <HistorySelector setBodyState={setBodyState} />
            <Loader isLoading={isLoading}/>
            <ChallengeBody bodyState={bodyState} setIsLoading={setIsLoading} />
        </div>
    );
}

export default App;
