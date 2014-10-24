package coinjar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/* The @ComponentScan annotation tells Spring to search recursively through the current package 
 * and its children for classes marked directly or indirectly with @RestController.
 * The @EnableAutoConfiguration sets up a Spring MVC configuration, so no web.xml is needed.
 */
@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}