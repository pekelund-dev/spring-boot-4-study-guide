package com.springscholar.content;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class ContentService {
    private final ContentManifestLoader manifestLoader;
    private final ContentDocumentLoader documentLoader;

    public ContentService(ContentManifestLoader manifestLoader, ContentDocumentLoader documentLoader) {
        this.manifestLoader = manifestLoader;
        this.documentLoader = documentLoader;
    }

    public ContentManifest getManifest() {
        return manifestLoader.load();
    }

    public List<ContentDocument> getAllDocuments(Optional<String> level, Optional<String> targetOS) {
        ContentManifest manifest = manifestLoader.load();
        return manifest.modules().stream()
            .flatMap(module -> module.sections().stream())
            .flatMap(section -> section.items().stream())
            .map(Path::of)
            .map(documentLoader::loadDocument)
            .filter(doc -> level.map(l -> l.equalsIgnoreCase(doc.minLevel())).orElse(true))
            .filter(doc -> targetOS.map(os -> "any".equalsIgnoreCase(doc.targetOS()) || os.equalsIgnoreCase(doc.targetOS()))
                .orElse(true))
            .collect(Collectors.toList());
    }

    public ContentDocument getDocumentById(String id) {
        return getAllDocuments(Optional.empty(), Optional.empty()).stream()
            .filter(doc -> id.equals(doc.id()))
            .findFirst()
            .orElseThrow(() -> new ContentNotFoundException("Content id not found: " + id));
    }

    public Map<String, List<ContentDocument>> getDocumentsByModule(Optional<String> level, Optional<String> targetOS) {
        return getAllDocuments(level, targetOS).stream()
            .collect(Collectors.groupingBy(ContentDocument::module));
    }
}
