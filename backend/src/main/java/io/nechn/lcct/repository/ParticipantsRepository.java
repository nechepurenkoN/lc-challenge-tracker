package io.nechn.lcct.repository;

import io.nechn.lcct.entity.ParticipantsList;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ParticipantsRepository extends MongoRepository<ParticipantsList, String> {

    ParticipantsList getParticipantsListBySession(String session);

}
