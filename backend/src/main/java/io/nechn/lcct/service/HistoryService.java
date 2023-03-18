package io.nechn.lcct.service;

import io.nechn.lcct.model.ChallengeStatusResponse;
import java.util.List;

public interface HistoryService {

    List<String> getHistoryIdList(String session);

    List<ChallengeStatusResponse> getHistoryEntry(String session, String id);

}
