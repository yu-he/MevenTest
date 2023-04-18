package annotated;

import ch02.decoupled.MessageRenderer;
import ch03.BookwormOracle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldSpringAnnotated {
    public static void main(String... args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        //ApplicationContext ctx = new ClassPathXmlApplicationContext("app-context-annotation.xml");
        MessageRenderer mr = ctx.getBean("renderer", MessageRenderer.class);
        mr.render();

        BookwormOracle bookwormOracle = ctx.getBean("book", BookwormOracle.class);
        System.out.println(bookwormOracle.defineMeaningOfLife());
    }
}
