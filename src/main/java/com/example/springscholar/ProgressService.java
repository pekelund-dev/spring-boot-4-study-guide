package com.example.springscholar;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ProgressService {
    private final Map<String, Set<String>> completedSectionsByUser = new ConcurrentHashMap<>();
    private final Map<String, Map<String, Integer>> quizScoresByUser = new ConcurrentHashMap<>();
    private final Map<String, Set<String>> pinnedSectionsByUser = new ConcurrentHashMap<>();
    private final Map<String, Instant> lastUpdatedByUser = new ConcurrentHashMap<>();

    public void markCompleted(String username, String sectionId) {
        completedSectionsByUser.computeIfAbsent(username, key -> ConcurrentHashMap.newKeySet()).add(sectionId);
        lastUpdatedByUser.put(username, Instant.now());
    }

    public boolean isCompleted(String username, String sectionId) {
        return completedSectionsByUser.getOrDefault(username, Collections.emptySet()).contains(sectionId);
    }

    public void togglePinned(String username, String sectionId) {
        var pinned = pinnedSectionsByUser.computeIfAbsent(username, key -> ConcurrentHashMap.newKeySet());
        if (pinned.contains(sectionId)) {
            pinned.remove(sectionId);
        } else {
            pinned.add(sectionId);
        }
        lastUpdatedByUser.put(username, Instant.now());
    }

    public boolean isPinned(String username, String sectionId) {
        return pinnedSectionsByUser.getOrDefault(username, Collections.emptySet()).contains(sectionId);
    }

    public void recordScore(String username, String assessmentId, int score) {
        quizScoresByUser.computeIfAbsent(username, key -> new HashMap<>()).put(assessmentId, score);
        lastUpdatedByUser.put(username, Instant.now());
    }

    public Map<String, Integer> getScores(String username) {
        return Collections.unmodifiableMap(quizScoresByUser.getOrDefault(username, Map.of()));
    }

    public Set<String> getCompleted(String username) {
        return Collections.unmodifiableSet(completedSectionsByUser.getOrDefault(username, Set.of()));
    }

    public Set<String> getPinned(String username) {
        return Collections.unmodifiableSet(pinnedSectionsByUser.getOrDefault(username, Set.of()));
    }

    public Instant getLastUpdated(String username) {
        return lastUpdatedByUser.get(username);
    }
}
