package org.kamilG.stateManager;

public class MainMenuState implements MenuState {
  @Override
  public void handle(MenuContext context) {
    System.out.println("---------- Main Menu ----------");
    System.out.println("1. Warehouse management");
    System.out.println("2. Commission management");
    System.out.println("3. Vehicle management");
    System.out.println("4. Person management");
    System.out.println();
    System.out.println("5. Quit");

    int choice = context.getScanner().nextInt();
    context.getScanner().nextLine();

    switch (choice) {
      case 1 -> context.setCurrentState(new WarehouseManagementState());

      case 2 -> context.setCurrentState(new CommissionManagementState());

      case 3 -> context.setCurrentState(new VehicleManagementState());

      case 4 -> context.setCurrentState(new PersonManagementState());

      case 5 -> {
        System.out.println("Bye");
        context.setCurrentState(null);
      }

      default -> System.out.println("Invalid input");
    }
  }
}
