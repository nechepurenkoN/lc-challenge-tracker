package io.nechn.lcct.model;

import java.sql.Timestamp;

public record AcceptedTask(String slug, Integer submissionId, Timestamp timestamp) {
}
