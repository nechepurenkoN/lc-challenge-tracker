package io.nechn.lcct.model;

import java.util.List;

public record GetLatestAcceptedResponse(List<SolvedTaskRecord> solvedTasks) {}
