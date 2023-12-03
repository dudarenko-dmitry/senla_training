package pl.senla.hotel.ui.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_1_READ_ALL_ORDERS;

@Slf4j
public class Item1ReadAllOrders implements MenuItem {

    private final String nameItem;

    public Item1ReadAllOrders() {
        this.nameItem = MENU_ITEM_1_READ_ALL_ORDERS;
    }

    @Override
    public void printItem() {
        log.info(nameItem);
    }
}
