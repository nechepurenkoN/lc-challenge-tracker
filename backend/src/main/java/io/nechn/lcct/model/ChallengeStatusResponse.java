package io.nechn.lcct.model;

import java.util.List;

public record ChallengeStatusResponse(boolean hasTheChallengeDone, String username, List<SolvedTask> solvedTasks) {}
