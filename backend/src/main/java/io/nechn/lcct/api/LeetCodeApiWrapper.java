package io.nechn.lcct.api;

import io.nechn.lcct.model.Task;
import java.util.Map;

public interface LeetCodeApiWrapper {

    Map<String, Task> getAllTasks();

}
