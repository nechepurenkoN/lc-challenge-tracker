package io.nechn.lcct.controller;

import io.nechn.lcct.model.GetLatestAcceptedResponse;
import io.nechn.lcct.service.LeetCodeApiWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserSubmissionInfoController {

    private final LeetCodeApiWrapper apiWrapper;

    @GetMapping("/getLatestAccepted/{username}")
    public ResponseEntity<GetLatestAcceptedResponse> getLatestAccepted(@PathVariable String username) {
        return apiWrapper.getLatestSolvedTasksByUsername(username)
                         .map(list -> ResponseEntity.ok().body(new GetLatestAcceptedResponse(list)))
                         .orElse(ResponseEntity.notFound().build());
    }
}
