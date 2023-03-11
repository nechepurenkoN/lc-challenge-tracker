package io.nechn.lcct.api;

import io.nechn.lcct.model.AcceptedTask;
import io.nechn.lcct.model.Task;
import java.util.List;
import java.util.Map;

public interface LeetCodeApiWrapper {

    Map<String, Task> getAllTasks();

    List<AcceptedTask> getLatestAcceptedByUsername(String username);

}
