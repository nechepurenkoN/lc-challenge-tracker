package io.nechn.lcct.model;

import lombok.Value;

public record Task(String slug, String title, Difficulty difficulty) { }
