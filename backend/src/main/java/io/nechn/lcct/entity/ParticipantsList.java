package io.nechn.lcct.entity;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Builder
public class ParticipantsList {

    @Id
    String id;

    String session;

    List<String> participants;


}
