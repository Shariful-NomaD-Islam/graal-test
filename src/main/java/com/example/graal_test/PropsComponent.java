package com.example.graal_test;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.Properties;

@Component
public class PropsComponent {
    private static Properties props;
    public static String CONFIG_FILE;
    public static String[] args;

    @PostConstruct
    public static void load() {
        Properties fallback = new Properties();
        fallback.put("key", "default");
        props = new Properties(fallback);
        try (InputStream is = new FileInputStream(CONFIG_FILE)) {
            props.load(is);
        } catch (IOException ex) {
            throw new UncheckedIOException("Failed to load resource", ex);
        }
    }

    public Properties getProps() {
        return props;
    }
}
