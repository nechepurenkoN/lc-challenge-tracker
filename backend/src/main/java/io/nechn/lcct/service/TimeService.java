package io.nechn.lcct.service;

import io.nechn.lcct.model.SolvedTask;
import java.time.Instant;
import java.util.List;

public interface TimeService {

    List<SolvedTask> filterTasksWeekly(List<SolvedTask> taskList, Instant now);

    default List<SolvedTask> filterTasksWeekly(List<SolvedTask> taskList) {
        return filterTasksWeekly(taskList, Instant.now());
    }

}
