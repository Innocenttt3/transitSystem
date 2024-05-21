package org.kamilG.stateManager;

import org.kamilG.Person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PersonManagementState implements MenuState {
  @Override
  public void handle(MenuContext menuContext) {
    System.out.println("---------- Person management ----------");
    System.out.println("1. Add");
    System.out.println("2. Display");
    System.out.println("3. Remove");
    System.out.println();
    System.out.println("4. Quit");

    int choice = menuContext.getScanner().nextInt();
    menuContext.getScanner().nextLine();
    switch (choice) {
      // a) add
      case 1 -> {
        System.out.println("Enter name: ");
        String name = scanner.nextLine();

        System.out.println("Enter surname: ");
        String surname = scanner.nextLine();

        System.out.println("Enter date of birth format(d/M/yyyy):  ");
        String dateOfBirthInput = scanner.nextLine();

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthInput, dateFormat);
        LocalDate dateOfEmployment = LocalDate.now();
        Person.TypeOfEmployment employmentType = null;

        boolean isValid = false;
        do {
          System.out.println(
                  "Enter type of employment (FULL_TIME/PART_TIME/EXTERNAL):");
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
        for (Person person : facade.persons) {
          System.out.println(person);
        }
      }
      // c) remove
      case 3 -> {
        int i = 1;
        System.out.println("Choose which person to remove");
        for (Person person : facade.persons) {
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
}
