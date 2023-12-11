package pl.senla.hotel;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("pl.senla.hotel")
@PropertySource("application.properties")
@EnableJpaRepositories("pl.senla.hotel.dao")
public class SpringConfig {

}
