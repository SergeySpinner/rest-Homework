package project;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "project")
@PropertySource("classpath:application.properties")
public class ApplicationConfiguration {
}
