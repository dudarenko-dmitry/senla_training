package pl.senla.hotel;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("pl.senla.hotel")
@PropertySource("application.properties")
public class SpringConfig {

}
