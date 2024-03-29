package io.nechn.lcct.entity;

import io.nechn.lcct.model.ChallengeStatus;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Builder
public class HistoryEntry {

    @Id
    String id;

    String session;

    Long startOfTheWeek;

    List<ChallengeStatus> challengeStatusList;

}
