package io.nechn.lcct.mapper;

import io.nechn.lcct.api.model.RecentAcSubmission;
import io.nechn.lcct.api.model.StatStatusPair;
import io.nechn.lcct.model.AcceptedTask;
import io.nechn.lcct.model.Difficulty;
import io.nechn.lcct.model.Task;
import java.sql.Timestamp;
import java.time.Instant;

public interface PayloadMapper {

    static Task fromStatStatusPairToTask(StatStatusPair statStatusPair) {
        return new Task(
            statStatusPair.getStat().getQuestionTitleSlug(),
            statStatusPair.getStat().getQuestionTitle(),
            convertDifficulty(statStatusPair.getDifficulty())
        );
    }

    static io.nechn.lcct.model.Difficulty convertDifficulty(io.nechn.lcct.api.model.Difficulty difficulty) {
        return switch (difficulty.getLevel()) {
            case 1 -> Difficulty.EASY;
            case 2 -> Difficulty.MEDIUM;
            case 3 -> Difficulty.HARD;
            default -> Difficulty.EASY;
        };
    }

    static AcceptedTask fromRecentAcSubmissionToAcceptedTask(RecentAcSubmission submission) {
        return new AcceptedTask(
            submission.getTitleSlug(),
            Timestamp.from(Instant.ofEpochSecond(Long.parseLong(submission.getTimestamp())))
        );
    }
}
