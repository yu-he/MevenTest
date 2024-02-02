package com.infosky.cfps;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        ClassPathResource resource = new ClassPathResource("system.properties");
        InputStream in = resource.getInputStream();
        properties.load(in);
        System.out.println(properties.getProperty("nameServerAddress"));
    }
}