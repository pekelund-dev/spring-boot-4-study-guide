package com.springscholar.content;

import java.util.List;

public record ContentManifest(int version, List<ContentModule> modules, Assessments assessments) {
    public record ContentModule(String id, String title, List<Section> sections) {}

    public record Section(String title, List<String> items) {}

    public record Assessments(List<String> quizzes, List<String> exams, List<String> exercises) {}
}
