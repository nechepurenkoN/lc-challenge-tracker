package io.nechn.lcct.controller;

import io.nechn.lcct.model.ChallengeStatusResponse;
import io.nechn.lcct.service.ChallengeService;
import io.nechn.lcct.service.HistoryService;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/challenge")
public class ChallengeController {

    @Value("${session.main.participants}")
    private String mainSessionParticipantsListString;

    private final ChallengeService challengeService;

    private final HistoryService historyService;

    @GetMapping("/session/{session}")
    public ResponseEntity<List<ChallengeStatusResponse>> getSessionChallengeStatusList(@PathVariable String session) {
        if (!"main".equals(session)) {
            return ResponseEntity.notFound().build();
        }

        final var leetCodeIdList = mainSessionParticipantsListString.split(",");
        final var sessionResponse = Arrays.stream(leetCodeIdList)
                                          .map(challengeService::getStatusResponse)
                                          .map(Optional::get)
                                          .collect(Collectors.toList());
        return ResponseEntity.ok(sessionResponse);
    }

    @GetMapping("/history/{session}")
    public ResponseEntity<List<String>> getSessionHistoryEntryIdList(@PathVariable String session) {
        return ResponseEntity.ok(historyService.getHistoryIdList(session));
    }

    @GetMapping("/history/{session}/{id}")
    public ResponseEntity<List<ChallengeStatusResponse>> getHistoryEntry(@PathVariable String session,
                                                                         @PathVariable String id) {
        return ResponseEntity.ok(historyService.getHistoryEntry(session, id));
    }
}
