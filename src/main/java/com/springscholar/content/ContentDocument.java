package com.springscholar.content;

import java.util.List;
import java.util.Map;

public record ContentDocument(
    String id,
    String title,
    String summary,
    String module,
    String type,
    String minLevel,
    String targetOS,
    int order,
    List<String> tags,
    Integer estimatedMinutes,
    String body,
    Map<String, Object> rawMetadata
) {}
