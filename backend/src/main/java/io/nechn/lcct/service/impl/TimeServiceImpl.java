package io.nechn.lcct.service.impl;

import io.nechn.lcct.model.SolvedTask;
import io.nechn.lcct.service.TimeService;
import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TimeServiceImpl implements TimeService {

    @Override
    public List<SolvedTask> filterTasksWeekly(List<SolvedTask> taskList, Instant currentTime) {
        final var utcZone = ZoneId.of("UTC");
        final var lastMondayTimestamp = Timestamp.from(LocalDate.ofInstant(currentTime, utcZone)
                                                                .with(
                                                                    TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY))
                                                                .atStartOfDay(utcZone).toInstant());
        final var nextMondayTimestamp = Timestamp.from(LocalDate.ofInstant(currentTime, utcZone)
                                                                .with(TemporalAdjusters.next(DayOfWeek.MONDAY))
                                                                .atStartOfDay(utcZone).toInstant());

        return taskList.parallelStream()
                       .filter(t -> t.timestamp().after(lastMondayTimestamp)
                           && t.timestamp().before(nextMondayTimestamp))
                       .toList();
    }
}
