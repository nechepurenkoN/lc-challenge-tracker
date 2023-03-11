package io.nechn.lcct.service;

import io.nechn.lcct.model.SolvedTask;
import java.util.List;

public interface ChallengeService {

    boolean hasTheChallengeDone(List<SolvedTask> solvedTasksList);

}
