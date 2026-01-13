package com.springscholar.content;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;

@Component
public class ContentManifestLoader {
    private final Path manifestPath;

    public ContentManifestLoader(@Value("${content.manifest-path:content/manifest.yaml}") String manifestPath) {
        this.manifestPath = Path.of(manifestPath);
    }

    public ContentManifest load() {
        try (InputStream inputStream = Files.newInputStream(manifestPath)) {
            Yaml yaml = new Yaml();
            ContentManifest manifest = yaml.loadAs(inputStream, ContentManifest.class);
            return Objects.requireNonNull(manifest, "Content manifest is empty");
        } catch (IOException ex) {
            throw new ContentNotFoundException("Unable to load content manifest at " + manifestPath, ex);
        }
    }
}
