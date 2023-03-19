package io.nechn.lcct.service.impl;

import io.nechn.lcct.mapper.PayloadMapper;
import io.nechn.lcct.model.ChallengeStatus;
import io.nechn.lcct.model.Difficulty;
import io.nechn.lcct.model.SolvedTask;
import io.nechn.lcct.service.ChallengeService;
import io.nechn.lcct.service.LeetCodeService;
import io.nechn.lcct.service.TimeService;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChallengeServiceImpl implements ChallengeService {

    private final LeetCodeService leetCodeService;

    private final TimeService timeService;

    private final Function<Map<Difficulty, Long>, Boolean> decider = m -> {
        final long easyCount = Optional.ofNullable(m.get(Difficulty.EASY)).orElse(0L);
        final long mediumCount = Optional.ofNullable(m.get(Difficulty.MEDIUM)).orElse(0L);
        final long hardCount = Optional.ofNullable(m.get(Difficulty.HARD)).orElse(0L);

        return mediumCount + hardCount >= 3 && easyCount + mediumCount + hardCount >= 6;
    };

    public boolean hasTheChallengeDone(List<SolvedTask> filteredSolvedTasksList) {
        final var difficultyToCountSolvedInWeek = filteredSolvedTasksList.stream()
                                                             .map(solvedTask -> solvedTask.task().difficulty())
                                                             .collect(Collectors.groupingBy(
                                                                 Function.identity(),
                                                                 Collectors.counting()
                                                             ));
        return decider.apply(difficultyToCountSolvedInWeek);
    }

    @Override
    public Optional<ChallengeStatus> getStatusResponse(String username) {
        return leetCodeService.getLatestSolvedTasksByUsername(username)
                       .map(timeService::filterTasksWeekly)
                       .map(list -> new ChallengeStatus(
                           hasTheChallengeDone(list),
                           username,
                           list.stream().map(PayloadMapper::fromSolvedTask).toList()
                       ));
    }
}
