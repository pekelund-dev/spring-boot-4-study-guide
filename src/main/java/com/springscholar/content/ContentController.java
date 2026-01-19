package com.springscholar.content;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/content")
public class ContentController {
    private final ContentService contentService;

    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @GetMapping("/manifest")
    public ContentManifest manifest() {
        return contentService.getManifest();
    }

    @GetMapping("/documents")
    public List<ContentDocument> documents(
        @RequestParam Optional<String> level,
        @RequestParam Optional<String> targetOS
    ) {
        return contentService.getAllDocuments(level, targetOS);
    }

    @GetMapping("/documents/by-module")
    public Map<String, List<ContentDocument>> documentsByModule(
        @RequestParam Optional<String> level,
        @RequestParam Optional<String> targetOS
    ) {
        return contentService.getDocumentsByModule(level, targetOS);
    }

    @GetMapping("/documents/{id}")
    public ContentDocument documentById(@PathVariable String id) {
        try {
            return contentService.getDocumentById(id);
        } catch (ContentNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        }
    }
}
