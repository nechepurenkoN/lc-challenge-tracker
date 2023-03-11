
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
    "user_name",
    "num_solved",
    "num_total",
    "ac_easy",
    "ac_medium",
    "ac_hard",
    "stat_status_pairs",
    "frequency_high",
    "frequency_mid",
    "category_slug"
})
public class GetAllProblemsPayload {

    @JsonProperty("user_name")
    private String userName;
    @JsonProperty("num_solved")
    private int numSolved;
    @JsonProperty("num_total")
    private int numTotal;
    @JsonProperty("ac_easy")
    private int acEasy;
    @JsonProperty("ac_medium")
    private int acMedium;
    @JsonProperty("ac_hard")
    private int acHard;
    @JsonProperty("stat_status_pairs")
    private List<StatStatusPair> statStatusPairs;
    @JsonProperty("frequency_high")
    private int frequencyHigh;
    @JsonProperty("frequency_mid")
    private int frequencyMid;
    @JsonProperty("category_slug")
    private String categorySlug;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("user_name")
    public String getUserName() {
        return userName;
    }

    @JsonProperty("user_name")
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonProperty("num_solved")
    public int getNumSolved() {
        return numSolved;
    }

    @JsonProperty("num_solved")
    public void setNumSolved(int numSolved) {
        this.numSolved = numSolved;
    }

    @JsonProperty("num_total")
    public int getNumTotal() {
        return numTotal;
    }

    @JsonProperty("num_total")
    public void setNumTotal(int numTotal) {
        this.numTotal = numTotal;
    }

    @JsonProperty("ac_easy")
    public int getAcEasy() {
        return acEasy;
    }

    @JsonProperty("ac_easy")
    public void setAcEasy(int acEasy) {
        this.acEasy = acEasy;
    }

    @JsonProperty("ac_medium")
    public int getAcMedium() {
        return acMedium;
    }

    @JsonProperty("ac_medium")
    public void setAcMedium(int acMedium) {
        this.acMedium = acMedium;
    }

    @JsonProperty("ac_hard")
    public int getAcHard() {
        return acHard;
    }

    @JsonProperty("ac_hard")
    public void setAcHard(int acHard) {
        this.acHard = acHard;
    }

    @JsonProperty("stat_status_pairs")
    public List<StatStatusPair> getStatStatusPairs() {
        return statStatusPairs;
    }

    @JsonProperty("stat_status_pairs")
    public void setStatStatusPairs(List<StatStatusPair> statStatusPairs) {
        this.statStatusPairs = statStatusPairs;
    }

    @JsonProperty("frequency_high")
    public int getFrequencyHigh() {
        return frequencyHigh;
    }

    @JsonProperty("frequency_high")
    public void setFrequencyHigh(int frequencyHigh) {
        this.frequencyHigh = frequencyHigh;
    }

    @JsonProperty("frequency_mid")
    public int getFrequencyMid() {
        return frequencyMid;
    }

    @JsonProperty("frequency_mid")
    public void setFrequencyMid(int frequencyMid) {
        this.frequencyMid = frequencyMid;
    }

    @JsonProperty("category_slug")
    public String getCategorySlug() {
        return categorySlug;
    }

    @JsonProperty("category_slug")
    public void setCategorySlug(String categorySlug) {
        this.categorySlug = categorySlug;
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
