package common.maven.logback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Slf4j
public class Test {
    public static void main(String... args) throws IOException {
        writeLog();
    }

    private static void readProperties() throws IOException {
        //InputStream in = ClassLoader.getSystemResourceAsStream("system.properties");

        ClassPathResource resource = new ClassPathResource("system.properties");
        InputStream in = resource.getInputStream();

        Properties properties = new Properties();
        properties.load(in);
        System.out.println(properties.getProperty("oracleUrl"));

        assert in != null;
        in.close();
    }

    private static void writeLog(){
        log.info("info");
        log.error("error");
    }
}
