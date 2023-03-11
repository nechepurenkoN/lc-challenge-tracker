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
import java.util.Objects;
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
//        final var url = "https://leetcode.com/";
//        final var query = "{\"query\":\"query recentAcSubmissions($username: String!, $limit: Int!) { recentAcSubmissionList(username: $username, limit: $limit) {id,title,titleSlug,timestamp}\",\"variables\":{\"username\":\"nechn\",\"limit\":15}}";
//
//        final var httpHeaders1 = new HttpHeaders();
//        httpHeaders1.set("referer", "https://leetcode.com/" + username + "/");
//
//         final var token = Objects.requireNonNull(
//            restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>("", httpHeaders1), String.class).getHeaders()
//                        .get("set-cookie")).get(0).split(";")[0];
//
//        final var headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.set("Cookie", token);
//        headers.set("referer", "https://leetcode.com/" + username + "/");
//        final var httpEntity = new HttpEntity<>(query, headers);
//
//
//        final var payload = objectMapper.readValue(restTemplate.exchange(
//            url, HttpMethod.POST, httpEntity, String.class
//        ).getBody(), GetLatestAcceptedPayload.class);
        final var payload = objectMapper.readValue("""
            {
                "data": {
                    "recentAcSubmissionList": [
                        {
                            "id": "913093052",
                            "title": "Convert Sorted List to Binary Search Tree",
                            "titleSlug": "convert-sorted-list-to-binary-search-tree",
                            "timestamp": "1678519882"
                        },
                        {
                            "id": "912511229",
                            "title": "Linked List Random Node",
                            "titleSlug": "linked-list-random-node",
                            "timestamp": "1678428991"
                        },
                        {
                            "id": "911895828",
                            "title": "Linked List Cycle II",
                            "titleSlug": "linked-list-cycle-ii",
                            "timestamp": "1678342492"
                        },
                        {
                            "id": "911333652",
                            "title": "Koko Eating Bananas",
                            "titleSlug": "koko-eating-bananas",
                            "timestamp": "1678261421"
                        },
                        {
                            "id": "911324142",
                            "title": "Minimum Time to Complete Trips",
                            "titleSlug": "minimum-time-to-complete-trips",
                            "timestamp": "1678260089"
                        },
                        {
                            "id": "909979725",
                            "title": "Kth Missing Positive Number",
                            "titleSlug": "kth-missing-positive-number",
                            "timestamp": "1678084179"
                        },
                        {
                            "id": "892032495",
                            "title": "Duplicate Emails",
                            "titleSlug": "duplicate-emails",
                            "timestamp": "1675604699"
                        },
                        {
                            "id": "844619334",
                            "title": "Daily Leads and Partners",
                            "titleSlug": "daily-leads-and-partners",
                            "timestamp": "1668611821"
                        },
                        {
                            "id": "843884468",
                            "title": "Second Highest Salary",
                            "titleSlug": "second-highest-salary",
                            "timestamp": "1668515989"
                        },
                        {
                            "id": "843801944",
                            "title": "Customer Who Visited but Did Not Make Any Transactions",
                            "titleSlug": "customer-who-visited-but-did-not-make-any-transactions",
                            "timestamp": "1668502714"
                        },
                        {
                            "id": "843470883",
                            "title": "Combine Two Tables",
                            "titleSlug": "combine-two-tables",
                            "timestamp": "1668455775"
                        },
                        {
                            "id": "842489071",
                            "title": "Reverse Words in a String",
                            "titleSlug": "reverse-words-in-a-string",
                            "timestamp": "1668322167"
                        },
                        {
                            "id": "839950856",
                            "title": "Rearrange Products Table",
                            "titleSlug": "rearrange-products-table",
                            "timestamp": "1667978826"
                        },
                        {
                            "id": "839949969",
                            "title": "Employees With Missing Information",
                            "titleSlug": "employees-with-missing-information",
                            "timestamp": "1667978705"
                        },
                        {
                            "id": "839265498",
                            "title": "Patients With a Condition",
                            "titleSlug": "patients-with-a-condition",
                            "timestamp": "1667893102"
                        }
                    ]
                }
            }
            """, GetLatestAcceptedPayload.class);

        return payload.getData().getRecentAcSubmissionList().stream()
                      .map(PayloadMapper::fromRecentAcSubmissionToAcceptedTask)
                      .toList();
    }
}
