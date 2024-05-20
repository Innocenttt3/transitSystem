package org.kamilG;

import java.time.LocalDate;

public class Person {
  private String name;
  private String surname;
  private LocalDate dateOfBirth;
  private LocalDate dateOfEmployment;
  private TypeOfEmployment typeOfEmployment;

  public enum TypeOfEmployment {
    FULL_TIME,
    PART_TIME,
    EXTERNAL
  }

  public Person(
      String name,
      String surname,
      LocalDate dateOfBirth,
      LocalDate dateOfEmployment,
      TypeOfEmployment typeOfEmployment) {
    this.name = name;
    this.surname = surname;
    this.dateOfBirth = dateOfBirth;
    this.dateOfEmployment = dateOfEmployment;
    this.typeOfEmployment = typeOfEmployment;
  }

  @Override
  public String toString() {
    return this.name
        + " "
        + this.surname
        + " "
        + this.dateOfBirth
        + " "
        + this.dateOfEmployment
        + " "
        + this.typeOfEmployment;
  }
}
