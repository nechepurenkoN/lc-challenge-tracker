package io.nechn.lcct.api.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.nechn.lcct.api.LeetCodeApiWrapper;
import io.nechn.lcct.api.model.GetAllProblemsPayload;
import io.nechn.lcct.mapper.PayloadMapper;
import io.nechn.lcct.model.Task;
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

    @Autowired
    public LeetCodeApiWrapperImpl(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    @SneakyThrows
    @Override
    public Map<String, Task> getAllTasks() {
        final var url = "https://leetcode.com/api/problems/all/";
        final var objectMapper = new ObjectMapper();
        final GetAllProblemsPayload payload = objectMapper.readValue(restTemplate.getForObject(url, String.class), GetAllProblemsPayload.class);

        return payload.getStatStatusPairs().stream()
                      .map(PayloadMapper::fromStatStatusPairToTask)
                      .collect(Collectors.toMap(Task::slug, Function.identity()));
    }
}
