package pl.senla.hotel.ui;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_0_QUIT_TO_MAIN;

@Slf4j
public class Item0QuitToMain implements MenuItem {

    private final String nameItem;

    public Item0QuitToMain() {
        this.nameItem = MENU_ITEM_0_QUIT_TO_MAIN;
    }

    @Override
    public void printItem() {
        log.info(nameItem);
    }
}
