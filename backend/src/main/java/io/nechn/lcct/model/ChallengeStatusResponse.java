package io.nechn.lcct.model;

import java.util.List;

public record ChallengeStatusResponse(boolean hasTheChallengeDone, List<SolvedTask> solvedTasks) {}
