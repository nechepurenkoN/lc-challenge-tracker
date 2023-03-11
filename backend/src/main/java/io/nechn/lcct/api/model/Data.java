package io.nechn.lcct.api.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
                       "recentAcSubmissionList"
                   })
public class Data {

    @JsonProperty("recentAcSubmissionList")
    private List<RecentAcSubmission> recentAcSubmissionList;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("recentAcSubmissionList")
    public List<RecentAcSubmission> getRecentAcSubmissionList() {
        return recentAcSubmissionList;
    }

    @JsonProperty("recentAcSubmissionList")
    public void setRecentAcSubmissionList(List<RecentAcSubmission> recentAcSubmissionList) {
        this.recentAcSubmissionList = recentAcSubmissionList;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}