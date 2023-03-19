package io.nechn.lcct.service.impl;

import io.nechn.lcct.repository.ParticipantsRepository;
import io.nechn.lcct.service.ChallengeService;
import io.nechn.lcct.service.HistoryService;
import io.nechn.lcct.service.SnapshotService;
import io.nechn.lcct.service.TimeService;
import java.time.Instant;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SnapshotServiceImpl implements SnapshotService {

    private final HistoryService historyService;

    private final ParticipantsRepository participantsRepository;

    private final ChallengeService challengeService;

    private final TimeService timeService;

    @Override
    public void createSnapshot(Instant time) {
        participantsRepository.findAll().forEach(participantsList -> {
            final var data = participantsList.getParticipants().stream()
                                             .map(username -> challengeService.getStatusResponse(username, time))
                                             .map(Optional::get).toList();
            historyService.saveHistory(participantsList.getSession(), timeService.getStartOfTheWeekEpochSeconds(time), data);
        });
    }

}
