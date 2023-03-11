
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
    "question_id",
    "question__article__live",
    "question__article__slug",
    "question__article__has_video_solution",
    "question__title",
    "question__title_slug",
    "question__hide",
    "total_acs",
    "total_submitted",
    "frontend_question_id",
    "is_new_question"
})
public class Stat {

    @JsonProperty("question_id")
    private int questionId;
    @JsonProperty("question__article__live")
    private Object questionArticleLive;
    @JsonProperty("question__article__slug")
    private Object questionArticleSlug;
    @JsonProperty("question__article__has_video_solution")
    private Object questionArticleHasVideoSolution;
    @JsonProperty("question__title")
    private String questionTitle;
    @JsonProperty("question__title_slug")
    private String questionTitleSlug;
    @JsonProperty("question__hide")
    private boolean questionHide;
    @JsonProperty("total_acs")
    private int totalAcs;
    @JsonProperty("total_submitted")
    private int totalSubmitted;
    @JsonProperty("frontend_question_id")
    private int frontendQuestionId;
    @JsonProperty("is_new_question")
    private boolean isNewQuestion;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("question_id")
    public int getQuestionId() {
        return questionId;
    }

    @JsonProperty("question_id")
    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    @JsonProperty("question__article__live")
    public Object getQuestionArticleLive() {
        return questionArticleLive;
    }

    @JsonProperty("question__article__live")
    public void setQuestionArticleLive(Object questionArticleLive) {
        this.questionArticleLive = questionArticleLive;
    }

    @JsonProperty("question__article__slug")
    public Object getQuestionArticleSlug() {
        return questionArticleSlug;
    }

    @JsonProperty("question__article__slug")
    public void setQuestionArticleSlug(Object questionArticleSlug) {
        this.questionArticleSlug = questionArticleSlug;
    }

    @JsonProperty("question__article__has_video_solution")
    public Object getQuestionArticleHasVideoSolution() {
        return questionArticleHasVideoSolution;
    }

    @JsonProperty("question__article__has_video_solution")
    public void setQuestionArticleHasVideoSolution(Object questionArticleHasVideoSolution) {
        this.questionArticleHasVideoSolution = questionArticleHasVideoSolution;
    }

    @JsonProperty("question__title")
    public String getQuestionTitle() {
        return questionTitle;
    }

    @JsonProperty("question__title")
    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    @JsonProperty("question__title_slug")
    public String getQuestionTitleSlug() {
        return questionTitleSlug;
    }

    @JsonProperty("question__title_slug")
    public void setQuestionTitleSlug(String questionTitleSlug) {
        this.questionTitleSlug = questionTitleSlug;
    }

    @JsonProperty("question__hide")
    public boolean isQuestionHide() {
        return questionHide;
    }

    @JsonProperty("question__hide")
    public void setQuestionHide(boolean questionHide) {
        this.questionHide = questionHide;
    }

    @JsonProperty("total_acs")
    public int getTotalAcs() {
        return totalAcs;
    }

    @JsonProperty("total_acs")
    public void setTotalAcs(int totalAcs) {
        this.totalAcs = totalAcs;
    }

    @JsonProperty("total_submitted")
    public int getTotalSubmitted() {
        return totalSubmitted;
    }

    @JsonProperty("total_submitted")
    public void setTotalSubmitted(int totalSubmitted) {
        this.totalSubmitted = totalSubmitted;
    }

    @JsonProperty("frontend_question_id")
    public int getFrontendQuestionId() {
        return frontendQuestionId;
    }

    @JsonProperty("frontend_question_id")
    public void setFrontendQuestionId(int frontendQuestionId) {
        this.frontendQuestionId = frontendQuestionId;
    }

    @JsonProperty("is_new_question")
    public boolean isIsNewQuestion() {
        return isNewQuestion;
    }

    @JsonProperty("is_new_question")
    public void setIsNewQuestion(boolean isNewQuestion) {
        this.isNewQuestion = isNewQuestion;
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
