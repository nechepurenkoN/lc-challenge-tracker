package io.nechn.lcct.service.impl;

import io.nechn.lcct.model.ChallengeStatusResponse;
import io.nechn.lcct.service.HistoryService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class HistoryServiceImpl implements HistoryService {

    @Override
    public List<String> getHistoryIdList(String session) {
        return null;
    }

    @Override
    public List<ChallengeStatusResponse> getHistoryEntry(String session, String id) {
        return null;
    }

}
