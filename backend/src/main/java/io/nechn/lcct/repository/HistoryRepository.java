package io.nechn.lcct.repository;

import io.nechn.lcct.entity.HistoryEntry;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HistoryRepository extends MongoRepository<HistoryEntry, String> {

    List<HistoryEntry> getHistoryEntriesBySession(String session);

    HistoryEntry getHistoryEntriesBySessionAndId(String session, String id);

}
