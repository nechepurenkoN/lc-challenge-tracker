package io.nechn.lcct.service.impl;

import io.nechn.lcct.entity.HistoryEntry;
import io.nechn.lcct.model.ChallengeStatusResponse;
import io.nechn.lcct.model.HistoryEntryIdResponse;
import io.nechn.lcct.repository.HistoryRepository;
import io.nechn.lcct.service.HistoryService;
import io.nechn.lcct.service.TimeService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {

    private final HistoryRepository historyRepository;

    private final TimeService timeService;

    @Override
    public List<HistoryEntryIdResponse> getHistoryIdList(String session) {
        return historyRepository.getHistoryEntriesBySession(session).stream().
            map(historyEntry -> new HistoryEntryIdResponse(
                historyEntry.getId(),
                timeService.formWeekRangeString(historyEntry.getStartOfTheWeek())
            )).toList();
    }

    @Override
    public List<ChallengeStatusResponse> getHistoryEntry(String session, String id) {
        return historyRepository.getHistoryEntriesBySessionAndId(session, id).getChallengeStatusList();
    }

    @Override
    public void saveHistory(String session, Long startOfTheWeek, List<ChallengeStatusResponse> data) {
        historyRepository.save(HistoryEntry.builder()
                                           .session(session)
                                           .startOfTheWeek(startOfTheWeek)
                                           .challengeStatusList(data)
                                           .build()
        );
    }
}
