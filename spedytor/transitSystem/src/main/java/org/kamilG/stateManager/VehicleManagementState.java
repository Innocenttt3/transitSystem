package org.kamilG.stateManager;

import org.kamilG.Truck;
import org.kamilG.Vehicle;

public class VehicleManagementState implements MenuState {
  @Override
  public void handle(MenuContext menuContext) {
    System.out.println("---------- Vehicle management ----------");

    System.out.println("1. Add");
    System.out.println("2. Display");
    System.out.println("3. Update");
    System.out.println("4. Remove");
    System.out.println();
    System.out.println("5. Quit");

    int choice = menuContext.getScanner().nextInt();
    menuContext.getScanner().nextLine();
    switch (choice) {
      case 1 -> handleAddVehicle(menuContext);
      case 2 -> handleDisplayVehicle(menuContext);
      case 3 -> handleUpdateVehicle(menuContext);
      case 4 -> handleRemoveVehicle(menuContext);
      case 5 -> {}
      default -> System.out.println("Invalid input option");
    }
  }

  private void handleRemoveVehicle(MenuContext menuContext) {
    handleUpdateVehicle(menuContext);
    int vehicleId = menuContext.getScanner().nextInt() - 1;
    menuContext.getScanner().nextLine();
    menuContext.getFacade().removeVehicle(vehicleId);
  }

  private void handleUpdateVehicle(MenuContext menuContext) {
    //TODO
  }

  private void handleDisplayVehicle(MenuContext menuContext) {
    int i = 1;
    for (Vehicle vehicle : menuContext.getFacade().getVehicles()) {
      System.out.println(i++ + ". " + vehicle);
    }
  }

  private void handleAddVehicle(MenuContext menuContext) {
    System.out.println("Enter load capacity: ");
    int loadCapacity = menuContext.getScanner().nextInt();
    menuContext.getScanner().nextLine();
    ;

    System.out.println("Enter year of production: ");
    int yearOfProduction = menuContext.getScanner().nextInt();
    menuContext.getScanner().nextLine();
    ;

    System.out.println("Enter mileage: ");
    int mileage = menuContext.getScanner().nextInt();
    menuContext.getScanner().nextLine();

    System.out.println("Enter current fuel level: ");
    int currentFuelLevel = menuContext.getScanner().nextInt();
    menuContext.getScanner().nextLine();

    System.out.println("Enter fuel type: (PB/ON/EV)");
    Vehicle.FuelType fuelType =
        Vehicle.FuelType.valueOf(menuContext.getScanner().nextLine().toUpperCase());

    System.out.println("Enter location: ");
    String location = menuContext.getScanner().nextLine();

    System.out.println("Enter make: ");
    String make = menuContext.getScanner().nextLine();

    System.out.println("Enter model: ");
    String model = menuContext.getScanner().nextLine();

    menuContext
        .getFacade()
        .addVehicle(
            new Truck(
                loadCapacity,
                yearOfProduction,
                mileage,
                currentFuelLevel,
                fuelType,
                location,
                make,
                model));
  }
}
