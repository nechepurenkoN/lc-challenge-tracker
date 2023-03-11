package io.nechn.lcct.service.impl;

import io.nechn.lcct.api.LeetCodeApiWrapper;
import io.nechn.lcct.model.SolvedTask;
import io.nechn.lcct.service.LeetCodeService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LeetCodeServiceImpl implements LeetCodeService {

    private final LeetCodeApiWrapper apiWrapper;

    @Override
    public Optional<List<SolvedTask>> getLatestSolvedTasksByUsername(String username) {
        final var tasks = apiWrapper.getAllTasks();
        final var latestAcceptedByUsername = apiWrapper.getLatestAcceptedByUsername(username);
        return Optional.of(latestAcceptedByUsername.stream()
                                                   .map(acceptedTask -> new SolvedTask(
                                                       tasks.get(acceptedTask.slug()),
                                                       acceptedTask.timestamp()
                                                   ))
                                                   .toList()
        );
    }
}
