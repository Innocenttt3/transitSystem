package org.kamilG;

public abstract class Vehicle {
  int loadCapacity;
  int yearOfProduction;
  long mileage;
  float currentFuelLevel;
  Truck.FuelType fuelType;
  String location;
  String make;
  String model;

  String getInfo() {
    return this.make
        + " "
        + this.model
        + " "
        + this.mileage
        + " "
        + this.yearOfProduction
        + " "
        + this.loadCapacity
        + " "
        + this.yearOfProduction;
  }

  void getToWarehouse(Warehouse warehouse) {
    this.location = warehouse.getCity();
  }

  void updateMileage(int mileage) {
    this.mileage = mileage;
  }

  String getLocation() {
    return this.location;
  }

  void setLocation(String location) {
    this.location = location;
  }

  public enum FuelType {
    PB,
    ON,
    EV
  }

  @Override
  public String toString() {
    return this.make + " " + this.model + " " + this.mileage + "  " + this.currentFuelLevel;
  }
}
