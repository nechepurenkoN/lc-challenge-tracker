package io.nechn.lcct.model;

import java.util.List;

public record ChallengeStatus(boolean hasTheChallengeDone, String username, List<DayTask> solvedTasks) {}
