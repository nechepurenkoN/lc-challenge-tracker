package io.nechn.lcct.model;

import java.sql.Timestamp;

public record SolvedTaskRecord(Task task, Timestamp timestamp) {
}
