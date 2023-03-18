package io.nechn.lcct.service.impl;

import io.nechn.lcct.repository.ParticipantsRepository;
import io.nechn.lcct.service.ParticipantsService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParticipantsServiceImpl implements ParticipantsService {

    private final ParticipantsRepository participantsRepository;

    @Override
    public List<String> findParticipantsBySession(String session) {
        return participantsRepository.getParticipantsListBySession(session).getParticipants();
    }

}
