package org.kamilG;

import java.time.LocalDate;

public class Person {
  String name;
  String surname;
  LocalDate dateOfBirth;
  LocalDate dateOfEmployment;
  TypeOfEmployment typeOfEmployment;

  public enum TypeOfEmployment {
    FullTime,
    PartTime,
    External
  }
}
