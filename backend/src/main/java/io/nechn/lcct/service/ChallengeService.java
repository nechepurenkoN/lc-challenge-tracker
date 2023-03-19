package io.nechn.lcct.service;

import io.nechn.lcct.model.ChallengeStatus;
import java.time.Instant;
import java.util.Optional;

public interface ChallengeService {

    Optional<ChallengeStatus> getStatusResponse(String username, Instant time);

    default Optional<ChallengeStatus> getStatusResponse(String username) {
        return getStatusResponse(username, Instant.now());
    }

}
