package io.nechn.lcct.model;

import java.sql.Timestamp;

public record SolvedTask(Task task, Integer submissionId, Timestamp timestamp) {
}
