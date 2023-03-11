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
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
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
        final GetAllProblemsPayload payload = objectMapper.readValue(restTemplate.getForObject(url, String.class), GetAllProblemsPayload.class);

        return payload.getStatStatusPairs().stream()
                      .map(PayloadMapper::fromStatStatusPairToTask)
                      .collect(Collectors.toMap(Task::slug, Function.identity()));
    }

    @SneakyThrows
    @Override
    public List<AcceptedTask> getLatestAcceptedByUsername(String username) {
        final var url = "https://leetcode.com/graphql";
        final var query = "{\"query\":\"query recentAcSubmissions($username: String!, $limit: Int!) { recentAcSubmissionList(username: $username, limit: $limit) {id,title,titleSlug,timestamp}\",\"variables\":{\"username\":\"nechn\",\"limit\":15}}";

        final var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("referer", "https://leetcode.com/" + username + "/");
        final var httpEntity = new HttpEntity<>(query, headers);

        final var payload = objectMapper.readValue(restTemplate.exchange(
            url, HttpMethod.POST, httpEntity, String.class
        ).getBody(), GetLatestAcceptedPayload.class);

        return payload.getData().getRecentAcSubmissionList().stream()
                      .map(PayloadMapper::fromRecentAcSubmissionToAcceptedTask)
                      .toList();
    }
}
