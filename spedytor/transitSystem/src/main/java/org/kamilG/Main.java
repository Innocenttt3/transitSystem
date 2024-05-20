package org.kamilG;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Facade facade = new Facade();

    System.out.println(
        "Welcome to our sophisticated content and management system! To begin, select your operation:");
    Scanner scanner = new Scanner(System.in);

    int whichMainOperation = 0;
    while (whichMainOperation != 5) {
      System.out.println("1. Warehouse management");
      System.out.println("2. Commission management");
      System.out.println("3. Vehicle management");
      System.out.println("4. Person management");
      System.out.println();
      System.out.println("5. Quit");

      whichMainOperation = scanner.nextInt();
      scanner.nextLine();

      switch (whichMainOperation) {
          /* 1. Warehouse management */
        case 1 -> {
          System.out.println("---------- Warehouse management ----------");

          System.out.println("1. Add");
          System.out.println("2. Display");
          System.out.println("3. Update");
          System.out.println("4. Remove");
          System.out.println();
          System.out.println("5. Quit");

          int whichManagementOption = scanner.nextInt();
          scanner.nextLine();

          switch (whichManagementOption) {
              // a) add
            case 1 -> {
              System.out.println("Enter city: ");
              String city = scanner.nextLine();

              List<Item> itemsToAdd = new ArrayList<>();

              while (true) {
                int i = 1;
                for (Item item : facade.getItems()) {
                  System.out.println(i++ + ". " + item);
                }

                System.out.println(i + ". Quit");

                System.out.println("Choose item: ");
                int itemId = scanner.nextInt() - 1;
                scanner.nextLine();

                if (itemId == i - 1) break;

                System.out.printf(
                    "Choose quantity (0 - %d): \n", facade.getItems().get(itemId).quantity);
                int quantity = scanner.nextInt();
                scanner.nextLine();

                Item itemToTransfer = facade.transferItems(itemId, quantity);
                itemsToAdd.add(itemToTransfer);
              }

              facade.addWarehouse(new Warehouse(city, itemsToAdd));
            }
              // b) display (list)
            case 2 -> {
              System.out.println("Warehouses:");

              int i = 1;
              for (Warehouse warehouse : facade.warehouses) {
                System.out.println(i++ + ". " + warehouse);
              }

              System.out.println();
            }
              // c) update
            case 3 -> {
              // TODO
            }
              // d) remove
            case 4 -> {
              int i = 1;
              for (Warehouse warehouse : facade.warehouses) {
                System.out.println(i++ + ". " + warehouse);
              }

              int warehouseId = scanner.nextInt() - 1;
              scanner.nextLine();
              facade.removeWarehouse(warehouseId);
            }
            case 5 -> {}
            default -> System.out.println("Invalid input");
          }
        }

          /* 2. Commission management */
          // a) create
          // b) display(list)
          // c) edit
          // d) fulfill
          // e) remove

          /* 3. Vehicle management */
        case 3 -> {
          int vehicleOperation = 0;
          while (vehicleOperation != 5) {
            System.out.println("---------- Vehicle management ----------");

            System.out.println("1. Add");
            System.out.println("2. Display");
            System.out.println("3. Update");
            System.out.println("4. Remove");
            System.out.println();
            System.out.println("5. Quit");

            vehicleOperation = scanner.nextInt();
            scanner.nextLine();

            switch (vehicleOperation) {
                // a) add
              case 1 -> {
                System.out.println("Enter load capacity: ");
                int loadCapacity = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter year of production: ");
                int yearOfProduction = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter mileage: ");
                int mileage = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter current fuel level: ");
                int currentFuelLevel = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter fuel type: ");
                Vehicle.FuelType fuelType = Vehicle.FuelType.valueOf(scanner.nextLine().toUpperCase());

                System.out.println("Enter location: ");
                String location = scanner.nextLine();

                System.out.println("Enter make: ");
                String make = scanner.nextLine();

                System.out.println("Enter model: ");
                String model = scanner.nextLine();

                facade.addVehicle(
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
                // b) display (list)
              case 2 -> {
                int i = 1;
                for (Vehicle vehicle : facade.vehicles) {
                  System.out.println(i++ + ". " + vehicle);
                }
              }
                // c) update
              case 3 -> {
                // TODO
              }
                // d) remove
              case 4 -> {
                int i = 1;
                for (Vehicle vehicle : facade.vehicles) {
                  System.out.println(i++ + ". " + vehicle);
                }

                int vehicleId = scanner.nextInt() - 1;
                scanner.nextLine();
                facade.removeVehicle(vehicleId);
              }
              case 5 -> {}
              default -> System.out.println("Invalid input");
            }
          }
        }

          /* 4. Person management */
        case 4 -> {
          int whichPersonOperation = 0;
          while (whichPersonOperation != 4) {
            System.out.println("---------- Person management ----------");

            System.out.println("1. Add");
            System.out.println("2. Display");
            System.out.println("3. Remove");
            System.out.println();
            System.out.println("4. Quit");

            whichPersonOperation = scanner.nextInt();
            scanner.nextLine();

            switch (whichPersonOperation) {
                // a) add
              case 1 -> {
                System.out.println("Enter name: ");
                String name = scanner.nextLine();

                System.out.println("Enter surname: ");
                String surname = scanner.nextLine();

                System.out.println("Enter date of birth ");
                String dateOfBirthInput = scanner.nextLine();

                DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("d/M/yyyy");
                LocalDate dateOfBirth = LocalDate.parse(dateOfBirthInput, dateFormat);
                LocalDate dateOfEmployment = LocalDate.now();
                Person.TypeOfEmployment employmentType = null;

                boolean isValid = false;
                do {
                  System.out.println("Enter type of employment: ");
                  String employment = scanner.nextLine();
                  try {
                    employmentType = Person.TypeOfEmployment.valueOf(employment.toUpperCase());
                    isValid = true;
                  } catch (IllegalArgumentException e) {
                    System.out.println("Invalid type of employment. Please try again.");
                  }
                } while (!isValid);

                Person personToAdd =
                    new Person(name, surname, dateOfBirth, dateOfEmployment, employmentType);
                facade.addPerson(personToAdd);
              }
                // b) display (list)
              case 2 -> {
                for (Person person : facade.people) {
                  System.out.println(person);
                }
              }
                // c) remove
              case 3 -> {
                int i = 1;
                System.out.println("Choose which person to remove");
                for (Person person : facade.people) {
                  System.out.println(i++ + " " + person);
                }
                int personId = scanner.nextInt() - 1;
                scanner.nextLine();
                facade.removePerson(personId);
              }

              case 4 -> {}
              default -> System.out.println("Invalid input option");
            }
          }
        }
        case 5 -> {}
        default -> System.out.println("Bye");
      }

      System.out.print("\033[H\033[2J");
      System.out.flush();
    }
  }
}
