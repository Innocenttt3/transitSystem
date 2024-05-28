package org.kamilG.stateManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.kamilG.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.mockito.Mockito.*;

public class CommissionManagementStateTest {
    private MenuContext menuContext;
    private CommissionManagementState commissionManagementState;
    private Scanner scanner;
    private Facade facade;

    @BeforeEach
    public void setup() {
        menuContext = mock(MenuContext.class);
        scanner = mock(Scanner.class);
        when(menuContext.getScanner()).thenReturn(scanner);
        commissionManagementState = new CommissionManagementState();

        // Setup Facade
        facade = new Facade();
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

        // Return the setup Facade when getFacade is called
        when(menuContext.getFacade()).thenReturn(facade);
    }


    @Test
    public void testHandleAddCommission() {
        // Arrange
        when(scanner.nextInt()).thenReturn(1, 1, 1, 1, 1);
        when(scanner.nextLine()).thenReturn("1/1/2024", "1/2/2024");

        // Act
        commissionManagementState.handle(menuContext);

        // Assert
        assert facade.getCommissions().size() == 1;
    }

    @Test
    public void testHandleAddCommissionSameItem60Times() {
        // Arrange
        when(scanner.nextInt()).thenReturn(1, 1, 1, 1, 1);
        when(scanner.nextLine()).thenReturn("1/1/2024", "1/2/2024");

        // Act
        commissionManagementState.handle(menuContext);

        // Assert
        assert facade.getCommissions().getFirst().getItems().size() == 1;
    }

}
