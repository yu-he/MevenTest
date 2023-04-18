package annotated;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"annotated","ch03"})
@Configuration
public class HelloWorldConfiguration {

}
