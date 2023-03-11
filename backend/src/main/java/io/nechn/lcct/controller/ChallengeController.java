package io.nechn.lcct.controller;

import io.nechn.lcct.model.ChallengeStatusResponse;
import io.nechn.lcct.service.ChallengeService;
import io.nechn.lcct.service.LeetCodeService;
import io.nechn.lcct.service.TimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChallengeController {

    private final LeetCodeService leetCodeService;

    private final ChallengeService challengeService;

    private final TimeService timeService;

    @GetMapping("/getChallengeStatus/{username}")
    public ResponseEntity<ChallengeStatusResponse> getChallengeStatus(@PathVariable String username) {
        return leetCodeService.getLatestSolvedTasksByUsername(username)
                              .map(timeService::filterTasksWeekly)
                              .map(list -> ResponseEntity.ok().body(
                                  new ChallengeStatusResponse(challengeService.hasTheChallengeDone(list), list)
                              ))
                              .orElse(ResponseEntity.notFound().build());
    }
}
