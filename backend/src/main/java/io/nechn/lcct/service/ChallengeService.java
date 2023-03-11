package io.nechn.lcct.service;

import io.nechn.lcct.model.ChallengeStatusResponse;
import java.util.Optional;

public interface ChallengeService {

    Optional<ChallengeStatusResponse> getStatusResponse(String username);

}
