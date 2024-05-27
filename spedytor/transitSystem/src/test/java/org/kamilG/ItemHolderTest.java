package org.kamilG;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class ItemHolderTest {
    private ItemHolder itemHolder;

    @BeforeEach
    public void setup() {
        itemHolder = new Facade();
    }

    @Test
    public void testAddItems() {
        Item item1 = new Item("item1", 10);
        Item item2 = new Item("item2", 20);

        itemHolder.addItems(Arrays.asList(item1, item2));

        assertEquals(2, itemHolder.getItems().size());
        assertEquals(item1, itemHolder.getItems().get(0));
        assertEquals(item2, itemHolder.getItems().get(1));
    }

    @Test
    public void testTransferItems() {
        Item item1 = new Item("item1", 10);
        itemHolder.addItems(Arrays.asList(item1));

        Item transferredItem = itemHolder.transferItems(0, 5);

        assertEquals(5, itemHolder.getItems().get(0).getQuantity());
        assertEquals("item1", transferredItem.name);
        assertEquals(5, transferredItem.getQuantity());
    }

    @Test
    public void testTransferAllItems() {
        Facade anotherItemHolder = new Facade();
        Item item1 = new Item("item1", 10);
        Item item2 = new Item("item2", 20);

        itemHolder.addItems(Arrays.asList(item1, item2));
        itemHolder.transferAllItems(anotherItemHolder);

        assertEquals(0, itemHolder.getItems().size());
        assertEquals(2, anotherItemHolder.getItems().size());
    }
}
