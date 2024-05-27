package org.kamilG.stateManager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.kamilG.Person;

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
      case 1 -> handleAddPerson(menuContext);
      case 2 -> handleDisplayPersons(menuContext);
      case 3 -> handleRemovePerson(menuContext);
      case 4 -> menuContext.setCurrentState(new MainMenuState());
      default -> System.out.println("Invalid input option");
    }
  }

  private void handleRemovePerson(MenuContext menuContext) {
    int i = 1;
    System.out.println("Choose which person to remove");
    for (Person person : menuContext.getFacade().getPersons()) {
      System.out.println(i++ + " " + person);
    }
    int personId = menuContext.getScanner().nextInt() - 1;
    menuContext.getScanner().nextLine();
    menuContext.getFacade().removePerson(personId);
  }

  private void handleAddPerson(MenuContext menuContext) {
    System.out.println("Enter name: ");
    String name = menuContext.getScanner().nextLine();

    System.out.println("Enter surname: ");
    String surname = menuContext.getScanner().nextLine();

    System.out.println("Enter date of birth format(d/M/yyyy):  ");
    String dateOfBirthInput = menuContext.getScanner().nextLine();

    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("d/M/yyyy");
    LocalDate dateOfBirth = LocalDate.parse(dateOfBirthInput, dateFormat);
    LocalDate dateOfEmployment = LocalDate.now();
    Person.TypeOfEmployment employmentType = null;

    boolean isValid = false;
    do {
      System.out.println("Enter type of employment (FULL_TIME/PART_TIME/EXTERNAL):");
      String employment = menuContext.getScanner().nextLine();
      try {
        employmentType = Person.TypeOfEmployment.valueOf(employment.toUpperCase());
        isValid = true;
      } catch (IllegalArgumentException e) {
        System.out.println("Invalid type of employment. Please try again.");
      }
    } while (!isValid);

    menuContext
        .getFacade()
        .addPerson(new Person(name, surname, dateOfBirth, dateOfEmployment, employmentType));
  }

  private void handleDisplayPersons(MenuContext menuContext) {
    for (Person person : menuContext.getFacade().getPersons()) {
      System.out.println(person);
    }
  }
}
