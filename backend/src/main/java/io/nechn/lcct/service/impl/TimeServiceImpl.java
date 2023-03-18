package io.nechn.lcct.service.impl;

import io.nechn.lcct.model.SolvedTask;
import io.nechn.lcct.service.TimeService;
import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TimeServiceImpl implements TimeService {

    private final String PATTERN_FORMAT = "dd.MM.yyyy";

    private final ZoneId utcZone = ZoneId.of("UTC");

    @Override
    public List<SolvedTask> filterTasksWeekly(List<SolvedTask> taskList, Instant currentTime) {
        final var lastMondayTimestamp = Timestamp.from(getMondayStart(currentTime));
        final var nextMondayTimestamp = Timestamp.from(getSundayEnd(currentTime));

        return taskList.parallelStream()
                       .filter(t -> t.timestamp().after(lastMondayTimestamp)
                           && t.timestamp().before(nextMondayTimestamp))
                       .toList();
    }

    @Override
    public Long getStartOfTheWeekEpochSeconds(Instant now) {
        return getMondayStart(now).getEpochSecond();
    }

    @Override
    public String formWeekRangeString(Long time) {
        final var current = Instant.ofEpochSecond(time);
        final var left = getMondayStart(current);
        final var right = getSundayEnd(current);

        final var formatter = DateTimeFormatter.ofPattern(PATTERN_FORMAT).withZone(utcZone);

        return String.format("%s - %s", formatter.format(left), formatter.format(right));
    }

    protected Instant getMondayStart(Instant currentTime) {
        return LocalDate.ofInstant(currentTime, utcZone)
                .with(
                    TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY))
                .atStartOfDay(utcZone).toInstant();
    }

    protected Instant getSundayEnd(Instant currentTime) {
        return LocalDate.ofInstant(currentTime, utcZone)
                 .with(TemporalAdjusters.next(DayOfWeek.MONDAY))
                 .atStartOfDay(utcZone)
                 .minus(1, ChronoUnit.MINUTES)
                 .toInstant();
    }
}
