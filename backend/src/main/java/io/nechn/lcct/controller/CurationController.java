package io.nechn.lcct.controller;

import io.nechn.lcct.service.SnapshotService;
import java.time.Instant;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("dev")
@RequiredArgsConstructor
@RestController
@RequestMapping("api/curation")
public class CurationController {

    private final SnapshotService snapshotService;

    @PostMapping("/createSnapshot")
    public void createSnapshot() {
        snapshotService.createSnapshot();
    }

    @PostMapping("/createSnapshot/{epochSecond}")
    public void createSnapshotFromEpochSecond(@PathVariable Long epochSecond) {
        snapshotService.createSnapshot(Instant.ofEpochSecond(epochSecond));
    }

}
