package io.nechn.lcct.service;

import io.nechn.lcct.model.ChallengeStatusResponse;
import io.nechn.lcct.model.HistoryEntryIdResponse;
import java.util.List;

public interface HistoryService {

    List<HistoryEntryIdResponse> getHistoryIdList(String session);

    List<ChallengeStatusResponse> getHistoryEntry(String session, String id);

    void saveHistory(String session, Long startOfTheWeek, List<ChallengeStatusResponse> data);

}
