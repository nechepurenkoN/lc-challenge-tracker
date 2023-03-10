package io.nechn.lcct.service;

import io.nechn.lcct.model.SolvedTaskRecord;
import java.util.List;
import java.util.Optional;

public interface LeetCodeApiWrapper {
    Optional<List<SolvedTaskRecord>> getLatestSolvedTasksByUsername(String username);
}
