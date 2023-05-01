import React, {useEffect, useState} from "react";
import {HISTORY_URL, SESSION_URL} from "../constants";
import ChallengeStatusCard from "./ChallengeStatusCard";

export default function ChallengeBody({ bodyState }) {
    const [data, setData] = useState(false);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(false);

    useEffect(() => {
        const abortController = new AbortController();

        setLoading(true);
        fetch(getLink(bodyState), {
            signal: abortController.signal,
        })
            .then(response => {
                if (response.ok) {
                    return response.json();
                }
                return Promise.reject();
            })
            .then(data => {
                setData(data);
            })
            .catch(() => {
                if (abortController.signal.aborted) {
                    console.log('The user aborted the request');
                } else {
                    console.error('The request failed');
                }
            })
            .finally(() => {
                setLoading(false);
            });

        return () => {
            abortController.abort();
        };
    }, [bodyState]);

    if (loading || !data) {
        return <div>Loading...</div>;
    }

    if (error) {
        return <div>Error :(</div>;
    }

    return (
        <div className={"card-container"}>
            {data.map((entry, idx) => (
                <ChallengeStatusCard idx={idx} entry={entry} key={idx}/>
            ))}
        </div>
    );
}

function getLink(bodyState) {
    if (bodyState === "current") return SESSION_URL;
    return HISTORY_URL + "/" + bodyState;
}