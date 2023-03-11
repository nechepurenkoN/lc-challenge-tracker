package io.nechn.lcct.api.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.nechn.lcct.api.LeetCodeApiWrapper;
import io.nechn.lcct.api.model.GetAllProblemsPayload;
import io.nechn.lcct.api.model.GetLatestAcceptedPayload;
import io.nechn.lcct.mapper.PayloadMapper;
import io.nechn.lcct.model.AcceptedTask;
import io.nechn.lcct.model.Task;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LeetCodeApiWrapperImpl implements LeetCodeApiWrapper {

    private final RestTemplate restTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public LeetCodeApiWrapperImpl(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    @SneakyThrows
    @Override
    public Map<String, Task> getAllTasks() {
        final var url = "https://leetcode.com/api/problems/all/";
        final GetAllProblemsPayload payload =
            objectMapper.readValue(restTemplate.getForObject(url, String.class), GetAllProblemsPayload.class);

        return payload.getStatStatusPairs().stream()
                      .map(PayloadMapper::fromStatStatusPairToTask)
                      .collect(Collectors.toMap(Task::slug, Function.identity()));
    }

    @SneakyThrows
    @Override
    public List<AcceptedTask> getLatestAcceptedByUsername(String username) {
        final var url = "http://localhost:8081/" + username;
        final var payload = objectMapper.readValue(restTemplate.getForObject(url, String.class),
            GetLatestAcceptedPayload.class);

        return payload.getData().getRecentAcSubmissionList().stream()
                      .map(PayloadMapper::fromRecentAcSubmissionToAcceptedTask)
                      .toList();
    }
}
