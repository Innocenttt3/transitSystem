package org.kamilG.stateManager;

import org.kamilG.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CommissionManagementState implements MenuState {
  @Override
  public void handle(MenuContext menuContext) {
    System.out.println("---------- Commission management ----------");

    System.out.println("1. Add");
    System.out.println("2. Display");
    System.out.println("3. Edit");
    System.out.println("4. Fulfill");
    System.out.println("5. Remove");
    System.out.println();
    System.out.println("6. Quit");

    int choice = menuContext.getScanner().nextInt();
    menuContext.getScanner().nextLine();
    switch (choice) {
      case 1 -> handleAddCommission(menuContext);
      case 2 -> handleDisplayCommission(menuContext);
      case 3 -> handleEditCommission(menuContext);
      case 4 -> handleFulfillCommission(menuContext);
      case 5 -> handleRemoveCommission(menuContext);
      case 6 -> menuContext.setCurrentState(new MainMenuState());
      default -> System.out.println("Invalid input option");
    }
  }

  private void handleRemoveCommission(MenuContext menuContext) {
    handleDisplayCommission(menuContext);
    int commissionId = menuContext.getScanner().nextInt() - 1;
    menuContext.getScanner().nextLine();
    menuContext.getFacade().removeCommission(commissionId);
  }

  private void handleFulfillCommission(MenuContext menuContext) {
    handleDisplayCommission(menuContext);

    int commissionId = menuContext.getScanner().nextInt() - 1;
    menuContext.getScanner().nextLine();
    menuContext.getFacade().fulfillCommission(commissionId);
  }

  private void handleEditCommission(MenuContext menuContext) {
    // TODO
  }

  private void handleDisplayCommission(MenuContext menuContext) {
    System.out.println("Commissions:");

    int i = 1;
    for (Commission commission : menuContext.getFacade().getCommissions()) {
      System.out.println(i++ + ". " + commission);
    }

    System.out.println();
  }

  private void handleAddCommission(MenuContext menuContext) {
    int i = 1;
    for (Person person : menuContext.getFacade().getPersons()) {
      System.out.println(i++ + ". " + person);
    }

    System.out.println("Enter driver id: ");
    int personId = menuContext.getScanner().nextInt() - 1;
    menuContext.getScanner().nextLine();
    Person person = menuContext.getFacade().getPersons().get(personId);

    i = 1;
    for (Vehicle vehicle : menuContext.getFacade().getVehicles()) {
      System.out.println(i++ + ". " + vehicle);
    }

    System.out.println("Enter vehicle id: ");
    int vehicleId = menuContext.getScanner().nextInt() - 1;
    menuContext.getScanner().nextLine();
    Vehicle vehicle = menuContext.getFacade().getVehicles().get(vehicleId);

    System.out.println("Start date format(d/M/yyyy):");
    String startDateInput = menuContext.getScanner().nextLine();

    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("d/M/yyyy");
    LocalDate startDate = LocalDate.parse(startDateInput, dateFormat);

    System.out.println("End date format(d/M/yyyy):");
    String endDateInput = menuContext.getScanner().nextLine();

    LocalDate endDate = LocalDate.parse(endDateInput, dateFormat);

    i = 1;
    for (Warehouse warehouse : menuContext.getFacade().getWarehouses()) {
      System.out.println(i++ + ". " + warehouse);
    }

    System.out.println("Enter source warehouse id: ");
    int sourceWarehouseId = menuContext.getScanner().nextInt() - 1;
    menuContext.getScanner().nextLine();
    Warehouse sourceWarehouse = menuContext.getFacade().getWarehouses().get(sourceWarehouseId);

    System.out.println("Enter destination warehouse id: ");
    int destinationWarehouseId = menuContext.getScanner().nextInt() - 1;
    menuContext.getScanner().nextLine();
    Warehouse destinationWarehouse =
        menuContext.getFacade().getWarehouses().get(destinationWarehouseId);

    List<Item> itemsToAdd = new ArrayList<>();
    while (true) {
      i = 1;
      for (Item item : sourceWarehouse.getItems()) {
        System.out.println(i++ + ". " + item);
      }

      System.out.println(i + ". Quit");

      System.out.println("Choose item: ");
      int itemId = menuContext.getScanner().nextInt() - 1;
      menuContext.getScanner().nextLine();

      if (itemId == i - 1) break;

      System.out.printf(
          "Choose quantity (0 - %d): \n", sourceWarehouse.getItems().get(itemId).getQuantity());
      int quantity = menuContext.getScanner().nextInt();
      menuContext.getScanner().nextLine();

      Item itemToTransfer = sourceWarehouse.transferItems(itemId, quantity);
      itemsToAdd.add(itemToTransfer);
    }

    menuContext
        .getFacade()
        .addCommission(
            new Commission(
                person,
                vehicle,
                startDate,
                sourceWarehouse,
                destinationWarehouse,
                endDate,
                itemsToAdd));
  }
}
