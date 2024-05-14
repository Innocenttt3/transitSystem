package org.kamilG;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Truck implements Vehicle {
  int loadCapacity;
  LocalDateTime dateOfProduction;
  long mileage;
  float currentFuelLevel;
  FuelType fuelType;
  Location location;
  String make;
  String model;

  @Override
  public String getInfo() {
    return this.make + " " + this.model + " " + this.mileage + " " + this.dateOfProduction;
  }

  @Override
  public void sentToWarehouse(Warehouse warehouse) {}

  @Override
  public void updateMileage(int mileage) {}

  public enum FuelType {
    Pb95,
    Pb98,
    Pb100,
    ON,
    Ev,
  }
}
