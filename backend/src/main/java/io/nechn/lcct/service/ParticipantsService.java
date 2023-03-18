package io.nechn.lcct.service;

import java.util.List;

public interface ParticipantsService {

    List<String> findParticipantsBySession(String session);

}
