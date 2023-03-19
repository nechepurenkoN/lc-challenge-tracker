package io.nechn.lcct.scheduled;

import io.nechn.lcct.service.SnapshotService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HistorySnapshotTask {

    private final SnapshotService snapshotService;

    @Scheduled(cron = "0 59 23 * * SUN")
    public void createSnapshots() {
        snapshotService.createSnapshot();
    }

}
