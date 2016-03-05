package de.mlrdev.reactapi.api.repo;

import de.mlrdev.reactapi.api.domain.BlogPostItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Item repository service that is based on files.
 * Each file represents a new item/entry.
 */
@Service
public class FileItemRepository implements ItemRepository<BlogPostItem> {

    @Value("${blog.path}")
    private String path;

    private static final Logger LOG = LoggerFactory.getLogger(FileItemRepository.class);

    private static final String NEWLINE = System.getProperty("line.separator");

    @Override
    public List<BlogPostItem> getAll() {

        if (this.path != null && this.path.length() > 0) {
            File folder = new File(path);
            LOG.info("Retrieve items from: ");

            List<BlogPostItem> blogItems = new ArrayList<>();
            List<File> files = Arrays.asList(folder.listFiles());
            files.stream().forEach(file -> {
                LOG.info("\t" + file.toString());

                try (
                        FileReader fr = new FileReader(file);
                        BufferedReader br = new BufferedReader(fr)
                ) {
                    String heading = br.readLine();
                    if (heading != null) {
                        long lastModified = file.lastModified();
                        StringBuilder sb = new StringBuilder();
                        String line;
                        while ((line = br.readLine()) != null) {
                            sb.append(line + NEWLINE);
                        }

                        blogItems.add(new BlogPostItem(heading, lastModified, sb.toString()));
                    }
                } catch (IOException e) {
                    LOG.error("Error while processing {}", file.toString());
                }
            });
            return blogItems;
        }
        return null;
    }

    @Override
    public BlogPostItem getById(String id) {
        throw new UnsupportedOperationException("not yet implemented");
    }
}
