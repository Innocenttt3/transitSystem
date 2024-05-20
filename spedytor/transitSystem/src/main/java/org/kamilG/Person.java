package org.kamilG;

import java.time.LocalDate;

public class Person {
  private String name;
  private String surname;
  private LocalDate dateOfBirth;
  private LocalDate dateOfEmployment;
  private TypeOfEmployment typeOfEmployment;

  public enum TypeOfEmployment {
    FullTime,
    PartTime,
    External
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
}
