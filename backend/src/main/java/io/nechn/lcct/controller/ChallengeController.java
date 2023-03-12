package io.nechn.lcct.controller;

import io.nechn.lcct.model.ChallengeStatusResponse;
import io.nechn.lcct.service.ChallengeService;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChallengeController {

    @Value("${session.main.participants}")
    private String mainSessionParticipantsListString;

    private final ChallengeService challengeService;

    @GetMapping("/getChallengeStatus/{username}")
    public ResponseEntity<ChallengeStatusResponse> getChallengeStatus(@PathVariable String username) {
        return challengeService.getStatusResponse(username)
                               .map(ResponseEntity.ok()::body)
                               .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/getChallengeStatus/session/{session}")
    public ResponseEntity<List<ChallengeStatusResponse>> getSessionChallengeStatusList(@PathVariable String session) {
        final var leetCodeIdList = mainSessionParticipantsListString.split(",");
        final var sessionResponse = Arrays.stream(leetCodeIdList)
                                                  .map(challengeService::getStatusResponse)
                                                  .map(Optional::get)
                                                  .collect(Collectors.toList());
        return ResponseEntity.ok(sessionResponse);
    }
}
