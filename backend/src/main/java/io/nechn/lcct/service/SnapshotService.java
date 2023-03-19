package io.nechn.lcct.service;

import java.time.Instant;

public interface SnapshotService {

    void createSnapshot(Instant time);

    default void createSnapshot() {
        createSnapshot(Instant.now());
    }

}
