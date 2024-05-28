package org.kamilG;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FacadeTest {
    private Facade facade;

    @BeforeEach
    public void setUp() {
        facade = new Facade();

        // Uncommented the values from the constructor as examples
        facade.setItems(
                new ArrayList<>(Arrays.asList(
                        new Item("Coders' tears", 105253),
                        new Item("Papieska Kremówka", 2137)))
        );

        facade.addPerson(
                new Person("Andrzej","Duda", LocalDate.of(1972,5,16), LocalDate.of(1972,5,16), Person.TypeOfEmployment.PART_TIME)
        );

        facade.addVehicle(new Truck(15, 1939, 1234, 4321, Vehicle.FuelType.PB, "Uzbekistan", "Dacia", "Logan"));

        facade.addWarehouse(new Warehouse("Berlin", new ArrayList<>(List.of(new Item("Michas", 60)))));
        facade.addWarehouse(new Warehouse("Moskwa", new ArrayList<>()));
    }

    @Test
    public void testAddAndRemovePerson() {
        Person person = new Person("John", "Doe", LocalDate.of(1980, 1, 1), LocalDate.of(2000, 1, 1), Person.TypeOfEmployment.FULL_TIME);
        facade.addPerson(person);
        assertEquals(2, facade.getPersons().size());

        facade.removePerson(0);
        assertEquals(1, facade.getPersons().size());
    }

    @Test
    public void testAddAndRemoveWarehouse() {
        Warehouse warehouse = new Warehouse("New York", new ArrayList<>(List.of(new Item("Apples", 100))));
        facade.addWarehouse(warehouse);
        assertEquals(3, facade.getWarehouses().size());

        facade.removeWarehouse(0);
        assertEquals(2, facade.getWarehouses().size());
    }

    @Test
    public void testAddAndRemoveVehicle() {
        Vehicle vehicle = new Truck(10, 2000, 1234, 4321, Vehicle.FuelType.PB, "Poland", "Fiat", "Ducato");
        facade.addVehicle(vehicle);
        assertEquals(2, facade.getVehicles().size());

        facade.removeVehicle(0);
        assertEquals(1, facade.getVehicles().size());
    }

    @Test
    public void testAddAndRemoveCommission() {
        Person driver = new Person("John", "Doe", LocalDate.of(1980, 1, 1), LocalDate.of(2000, 1, 1), Person.TypeOfEmployment.FULL_TIME);
        Vehicle vehicle = new Truck(10, 2000, 1234, 4321, Vehicle.FuelType.EV, "Poland", "Fiat", "Ducato");
        LocalDate startDate = LocalDate.now();
        Warehouse sourceWarehouse = new Warehouse("New York", new ArrayList<>(List.of(new Item("Apples", 100))));
        Warehouse destinationWarehouse = new Warehouse("Los Angeles", new ArrayList<>());
        LocalDate deadline = LocalDate.now().plusDays(7);
        List<Item> items = new ArrayList<>(List.of(new Item("Oranges", 50)));

        Commission commission = new Commission(driver, vehicle, startDate, sourceWarehouse, destinationWarehouse, deadline, items);
        facade.addCommission(commission);
        assertEquals(1, facade.getCommissions().size());

        facade.removeCommission(0);
        assertEquals(0, facade.getCommissions().size());
    }

    @Test
    public void testFulfillCommission() {
        Person driver = new Person("John", "Doe", LocalDate.of(1980, 1, 1), LocalDate.of(2000, 1, 1), Person.TypeOfEmployment.FULL_TIME);
        Vehicle vehicle = new Truck(10, 2000, 1234, 4321, Vehicle.FuelType.ON, "Poland", "Fiat", "Ducato");
        LocalDate startDate = LocalDate.now();
        Warehouse sourceWarehouse = new Warehouse("New York", new ArrayList<>(List.of(new Item("Apples", 100))));
        Warehouse destinationWarehouse = new Warehouse("Los Angeles", new ArrayList<>());
        LocalDate deadline = LocalDate.now().plusDays(7);
        List<Item> items = new ArrayList<>(List.of(new Item("Oranges", 50)));

        Commission commission = new Commission(driver, vehicle, startDate, sourceWarehouse, destinationWarehouse, deadline, items);
        facade.addCommission(commission);
        facade.fulfillCommission(0);
    }

    @Test
    public void testFulfillCommissionWithInvalidId() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            facade.fulfillCommission(100);
        });
    }

    @Test
    public void testRemoveWarehouseNotInList() {
        Warehouse warehouse = new Warehouse("Chicago", new ArrayList<>(List.of(new Item("Bananas", 200))));
        assertFalse(facade.getWarehouses().contains(warehouse));
        facade.removeWarehouse(warehouse);
        assertFalse(facade.getWarehouses().contains(warehouse));
    }

    @Test
    public void testRemoveVehicleNotInList() {
        Vehicle vehicle = new Truck(20, 2010, 5678, 8765, Vehicle.FuelType.EV, "Germany", "BMW", "X5");
        assertFalse(facade.getVehicles().contains(vehicle));
        facade.removeVehicle(vehicle);
        assertFalse(facade.getVehicles().contains(vehicle));
    }

    @Test
    public void testRemoveCommissionNotInList() {
        Person driver = new Person("John", "Doe", LocalDate.of(1980, 1, 1), LocalDate.of(2000, 1, 1), Person.TypeOfEmployment.FULL_TIME);
        Vehicle vehicle = new Truck(10, 2000, 1234, 4321, Vehicle.FuelType.ON, "Poland", "Fiat", "Ducato");
        LocalDate startDate = LocalDate.now();
        Warehouse sourceWarehouse = new Warehouse("New York", new ArrayList<>(List.of(new Item("Apples", 100))));
        Warehouse destinationWarehouse = new Warehouse("Los Angeles", new ArrayList<>());
        LocalDate deadline = LocalDate.now().plusDays(7);
        List<Item> items = new ArrayList<>(List.of(new Item("Oranges", 50)));

        Commission commission = new Commission(driver, vehicle, startDate, sourceWarehouse, destinationWarehouse, deadline, items);
        assertFalse(facade.getCommissions().contains(commission));
        facade.removeCommission(commission);
        assertFalse(facade.getCommissions().contains(commission));
    }

}
