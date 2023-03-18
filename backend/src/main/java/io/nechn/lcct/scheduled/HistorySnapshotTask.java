package io.nechn.lcct.scheduled;

import io.nechn.lcct.entity.HistoryEntry;
import io.nechn.lcct.repository.HistoryRepository;
import io.nechn.lcct.repository.ParticipantsRepository;
import io.nechn.lcct.service.ChallengeService;
import io.nechn.lcct.service.HistoryService;
import io.nechn.lcct.service.TimeService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HistorySnapshotTask {

    private final HistoryService historyService;

    private final ParticipantsRepository participantsRepository;

    private final ChallengeService challengeService;

    private final TimeService timeService;

    @Scheduled(cron = "0 59 23 * * SUN")
    public void createSnapshots() {
        participantsRepository.findAll().forEach(participantsList -> {
            final var data = participantsList.getParticipants().stream()
                                             .map(challengeService::getStatusResponse).map(Optional::get).toList();
            historyService.saveHistory(participantsList.getSession(), timeService.getStartOfTheWeekEpochSeconds(), data);
        });
    }

}
