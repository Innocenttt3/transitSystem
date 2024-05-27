package org.kamilG.stateManager;

import java.util.ArrayList;
import java.util.List;
import org.kamilG.Item;
import org.kamilG.Warehouse;

public class WarehouseManagementState implements MenuState {
  @Override
  public void handle(MenuContext menuContext) {
    System.out.println("---------- Warehouse management ----------");

    System.out.println("1. Add");
    System.out.println("2. Display");
    System.out.println("3. Update");
    System.out.println("4. Remove");
    System.out.println();
    System.out.println("5. Quit");

    int choice = menuContext.getScanner().nextInt();
    menuContext.getScanner().nextLine();
    switch (choice) {
      case 1 -> handleAddWarehouse(menuContext);
      case 2 -> handleDisplayWarehouse(menuContext);
      case 3 -> handleUpdateWarehouse(menuContext);
      case 4 -> handleRemoveWarehouse(menuContext);
      case 5 -> menuContext.setCurrentState(new MainMenuState());
      default -> System.out.println("Invalid input option");
    }
  }

  private void handleRemoveWarehouse(MenuContext menuContext) {
    handleDisplayWarehouse(menuContext);
    int warehouseId = menuContext.getScanner().nextInt() - 1;
    menuContext.getScanner().nextLine();
    menuContext.getFacade().removeWarehouse(warehouseId);
  }

  private void handleUpdateWarehouse(MenuContext menuContext) {
    // TODO
  }

  private void handleDisplayWarehouse(MenuContext menuContext) {
    System.out.println("Warehouses:");

    int i = 1;
    for (Warehouse warehouse : menuContext.getFacade().getWarehouses()) {
      System.out.println(i++ + ". " + warehouse);
    }

    System.out.println();
  }

  private void handleAddWarehouse(MenuContext menuContext) {
    System.out.println("Enter city: ");
    String city = menuContext.getScanner().nextLine();

    List<Item> itemsToAdd = new ArrayList<>();

    while (true) {
      int i = 1;
      for (Item item : menuContext.getFacade().getItems()) {
        System.out.println(i++ + ". " + item);
      }

      System.out.println(i + ". Quit");

      System.out.println("Choose item: ");
      int itemId = menuContext.getScanner().nextInt() - 1;
      menuContext.getScanner().nextLine();

      if (itemId == i - 1) break;

      System.out.printf(
          "Choose quantity (0 - %d): \n",
          menuContext.getFacade().getItems().get(itemId).getQuantity());
      int quantity = menuContext.getScanner().nextInt();
      menuContext.getScanner().nextLine();

      Item itemToTransfer = menuContext.getFacade().transferItems(itemId, quantity);
      itemsToAdd.add(itemToTransfer);
    }

    menuContext.getFacade().addWarehouse(new Warehouse(city, itemsToAdd));
  }
}
