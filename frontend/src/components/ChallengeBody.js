import React, {useEffect, useState} from "react";
import {HISTORY_URL, SESSION_URL} from "../constants";
import ChallengeStatusCard from "./ChallengeStatusCard";

export default function ChallengeBody(props) {
    const [data, setData] = useState({});
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(false);

    useEffect(() => {
        fetch(getLink(props.bodyState))
            .then(response => response.json())
            .then(data => {
                setData(data);
                setLoading(false);
            })
            .catch(reason => {
                setError(reason);
                setLoading(false)
                console.log(reason)
            });
    }, [props.bodyState]);

    if (loading) {
        return <div>Loading...</div>;
    }

    if (error) {
        return <div>Error :(</div>;
    }

    return (
        <div>
            {data.map((entry, idx) => (
                <ChallengeStatusCard idx={idx} entry={entry} key={idx} />
            ))}
        </div>
    );
}

function getLink(bodyState) {
    if (bodyState === "current") return SESSION_URL;
    return HISTORY_URL + "/" + bodyState;
}