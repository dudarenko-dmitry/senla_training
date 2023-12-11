package pl.senla.hotel;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.senla.hotel.ui.main.StartMenuMainDB;

import java.lang.reflect.InvocationTargetException;

import static pl.senla.hotel.constant.ApplicationContextConstant.START_APPLICATION;

@Slf4j
@SpringBootApplication
@ComponentScan("pl.senla.hotel")
@EnableJpaRepositories("pl.senla.hotel.dao")
@PropertySource("classpath:application.properties")
public class Main {

    public static void main(String[] args)
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException,
            InstantiationException, InterruptedException {

        log.info(START_APPLICATION);

        // previous version 1
//        DIApplication.getApplication().run();

//        version 3:
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        StartMenuMainDB startMenuMainDB = ctx.getBean(StartMenuMainDB.class);
        startMenuMainDB.runMenu();

    }

}

