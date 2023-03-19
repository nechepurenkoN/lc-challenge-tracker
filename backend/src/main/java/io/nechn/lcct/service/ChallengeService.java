package io.nechn.lcct.service;

import io.nechn.lcct.model.ChallengeStatus;
import java.util.Optional;

public interface ChallengeService {

    Optional<ChallengeStatus> getStatusResponse(String username);

}
