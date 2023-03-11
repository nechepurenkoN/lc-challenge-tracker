package io.nechn.lcct.service.impl;

import io.nechn.lcct.model.SolvedTask;
import io.nechn.lcct.service.ChallengeService;
import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ChallengeServiceImpl implements ChallengeService {

    @Override
    public boolean hasTheChallengeDone(List<SolvedTask> solvedTasksList) {
        final var currentTime = Instant.now();
        final var lastMondayTimestamp = Timestamp.from(currentTime
            .with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)));
        final var nextMondayTimestamp = Timestamp.from(currentTime
            .with(TemporalAdjusters.next(DayOfWeek.MONDAY)));

        final var difficultyToCountSolvedInWeek = solvedTasksList.parallelStream()
                                           .filter(t -> t.timestamp().after(lastMondayTimestamp)
                                               && t.timestamp().before(nextMondayTimestamp))
                                           .map(solvedTask -> solvedTask.task().difficulty())
                                           .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return true;
    }

}
