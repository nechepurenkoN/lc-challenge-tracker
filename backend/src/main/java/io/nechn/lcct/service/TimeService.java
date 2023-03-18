package io.nechn.lcct.service;

import io.nechn.lcct.model.SolvedTask;
import java.time.Instant;
import java.util.List;

public interface TimeService {

    List<SolvedTask> filterTasksWeekly(List<SolvedTask> taskList, Instant now);

    Long getStartOfTheWeekEpochSeconds(Instant now);

    String formWeekRangeString(Long time);

    default List<SolvedTask> filterTasksWeekly(List<SolvedTask> taskList) {
        return filterTasksWeekly(taskList, Instant.now());
    }

    default Long getStartOfTheWeekEpochSeconds() {
        return getStartOfTheWeekEpochSeconds(Instant.now());
    }

}
