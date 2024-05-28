package org.kamilG;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Facade extends ItemHolder {
  List<Warehouse> warehouses = new ArrayList<>();
  List<Commission> commissions = new ArrayList<>();
  List<Vehicle> vehicles = new ArrayList<>();
  List<Person> persons = new ArrayList<>();

  Facade() {
    //Example data set
//    this.setItems(
//        new ArrayList<>(Arrays.asList(
//            new Item("Mleko", 2115),
//            new Item("Jajka", 1234)))
//    );
//
//    this.persons = new ArrayList<>(Arrays.asList(
//            new Person("Jan","Kowalski", LocalDate.of(1972,5,16), LocalDate.of(1972,5,16), Person.TypeOfEmployment.PART_TIME)
//    ));
//
//    this.vehicles = new ArrayList<>(Arrays.asList(new Truck(15, 2015, 123400, 85, Vehicle.FuelType.PB, "Romania", "Dacia", "Logan")));
//
//    this.warehouses =
//        new ArrayList<>(Arrays.asList(new Warehouse("Berlin", new ArrayList<>(List.of(new Item("Maka", 60)))), new Warehouse("Paris", new ArrayList<>())));
  }

  public void addWarehouse(Warehouse warehouse) {
    warehouses.add(warehouse);
  }

  public void removeWarehouse(int warehouseId) {
    Warehouse warehouse = warehouses.get(warehouseId);
    warehouse.transferAllItems(this);

    removeWarehouse(warehouse);
  }

  void removeWarehouse(Warehouse warehouse) {
    warehouses.remove(warehouse);
  }

  public void addCommission(Commission commission) {
    commissions.add(commission);
  }

  public void removeCommission(int commissionId) {
    commissions.remove(commissionId);
  }

  void removeCommission(Commission commission) {
    commissions.remove(commission);
  }

  public void addVehicle(Vehicle vehicle) {
    vehicles.add(vehicle);
  }

  public void removeVehicle(int vehicleId) {
    vehicles.remove(vehicleId);
  }

  void removeVehicle(Vehicle vehicle) {
    vehicles.remove(vehicle);
  }

  public void addPerson(Person person) {
    persons.add(person);
  }

  public void removePerson(int id) {
    persons.remove(id);
  }

  public void fulfillCommission(int commissionId) {
    commissions.get(commissionId).fulfillCommission();
  }

  public List<Person> getPersons() {
    return persons;
  }
  public List<Vehicle> getVehicles() {
    return vehicles;
  }

  public List<Warehouse> getWarehouses() {
    return warehouses;
  }

  public List<Commission> getCommissions() {
    return commissions;
  }
}
