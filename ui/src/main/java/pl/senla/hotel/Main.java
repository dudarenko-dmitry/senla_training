package pl.senla.hotel;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.InvocationTargetException;

import static pl.senla.hotel.constant.ApplicationContextConstant.START_APPLICATION;

@Slf4j
@SpringBootApplication
public class Main {

    public static void main(String[] args)
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException,
            InstantiationException, InterruptedException {

        log.info(START_APPLICATION);
        SpringApplication.run(Main.class);
    }

    public static void exitApplication() {
        int exit = SpringApplication.exit(SpringApplication.run(Main.class), new ExitCodeGenerator() {
            @Override
            public int getExitCode() {
                return 0;
            }
        });
        System.exit(exit);
    }

}

