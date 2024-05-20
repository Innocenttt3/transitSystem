package org.kamilG;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Truck extends Vehicle {
    public Truck(
            int loadCapacity,
            int yearOfProduction,
            long mileage,
            float currentFuelLevel,
            Truck.FuelType fuelType,
            String location,
            String make,
            String model
    ) {
        this.loadCapacity = loadCapacity;
        this.yearOfProduction = yearOfProduction;
        this.mileage = mileage;
        this.currentFuelLevel = currentFuelLevel;
        this.fuelType = fuelType;
        this.location = location;
        this.make = make;
        this.model = model;
    }
}
