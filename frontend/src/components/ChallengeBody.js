import React, {useEffect, useState} from "react";
import {SESSION_URL} from "../constants";
import ChallengeStatusCard from "./ChallengeStatusCard";

export default function ChallengeBody() {
    const [data, setData] = useState({});
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
                setError(reason);
                setLoading(false)
            });
    }, []);

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