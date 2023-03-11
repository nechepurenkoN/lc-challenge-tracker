
package io.nechn.lcct.api.model;

import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
                       "stat",
                       "status",
                       "difficulty",
                       "paid_only",
                       "is_favor",
                       "frequency",
                       "progress"
                   })
public class StatStatusPair {

    @JsonProperty("stat")
    private Stat stat;
    @JsonProperty("status")
    private Object status;
    @JsonProperty("difficulty")
    private Difficulty difficulty;
    @JsonProperty("paid_only")
    private boolean paidOnly;
    @JsonProperty("is_favor")
    private boolean isFavor;
    @JsonProperty("frequency")
    private int frequency;
    @JsonProperty("progress")
    private int progress;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("stat")
    public Stat getStat() {
        return stat;
    }

    @JsonProperty("stat")
    public void setStat(Stat stat) {
        this.stat = stat;
    }

    @JsonProperty("status")
    public Object getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Object status) {
        this.status = status;
    }

    @JsonProperty("difficulty")
    public Difficulty getDifficulty() {
        return difficulty;
    }

    @JsonProperty("difficulty")
    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    @JsonProperty("paid_only")
    public boolean isPaidOnly() {
        return paidOnly;
    }

    @JsonProperty("paid_only")
    public void setPaidOnly(boolean paidOnly) {
        this.paidOnly = paidOnly;
    }

    @JsonProperty("is_favor")
    public boolean isIsFavor() {
        return isFavor;
    }

    @JsonProperty("is_favor")
    public void setIsFavor(boolean isFavor) {
        this.isFavor = isFavor;
    }

    @JsonProperty("frequency")
    public int getFrequency() {
        return frequency;
    }

    @JsonProperty("frequency")
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @JsonProperty("progress")
    public int getProgress() {
        return progress;
    }

    @JsonProperty("progress")
    public void setProgress(int progress) {
        this.progress = progress;
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