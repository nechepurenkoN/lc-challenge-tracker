package io.nechn.lcct.model;

import java.time.DayOfWeek;

public record DayTask(Task task, DayOfWeek day) {}
