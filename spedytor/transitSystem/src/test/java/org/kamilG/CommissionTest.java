package org.kamilG;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CommissionTest {
    private Commission commission;
    private Person driver;
    private Truck vehicle;
    private Warehouse sourceWarehouse;
    private Warehouse destinationWarehouse;
    private ArrayList<Item> items;

    @BeforeEach
    void setUp() {
        driver = new Person("John", "Doe", LocalDate.of(1980, 1, 1), LocalDate.of(2020, 1, 1), Person.TypeOfEmployment.PART_TIME);
        vehicle = new Truck(1000, 2018, 50000, 100, Truck.FuelType.EV, "City A", "Tesla", "Model X");
        sourceWarehouse = new Warehouse("Berlin", new ArrayList<>(List.of(new Item("Michas", 60))));
        destinationWarehouse = new Warehouse("Moskwa", new ArrayList<>());
        items = new ArrayList<>(Arrays.asList(new Item("Item 1",2), new Item("Item 2",8)));
        commission = new Commission(driver, vehicle, LocalDate.now(), sourceWarehouse, destinationWarehouse, LocalDate.now().plusDays(7), items);
    }

    @Test
    void testFulfillCommission() {
        assertNull(commission.getFulfillDate());
        commission.fulfillCommission();
        assertNotNull(commission.getFulfillDate());
        assertEquals(destinationWarehouse.getCity(), vehicle.getLocation());
        assertTrue(destinationWarehouse.getItems().containsAll(items));
    }
}
