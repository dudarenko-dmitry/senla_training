package pl.senla.hotel.ui;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static pl.senla.hotel.constant.ConsoleConstant.INPUT_MENU_POINT;

@Slf4j
@Component
public class UserChoice implements Choice{

    @Override
    public int makeChoice() {
        Scanner sc = new Scanner(System.in);
        log.info(INPUT_MENU_POINT);
        return Integer.parseInt(sc.next());
    }
}
