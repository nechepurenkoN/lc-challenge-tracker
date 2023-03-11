package io.nechn.lcct.service;

import io.nechn.lcct.model.SolvedTask;
import java.util.List;
import java.util.Optional;

public interface LeetCodeService {

    Optional<List<SolvedTask>> getLatestSolvedTasksByUsername(String username);

}
