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
//    this.setItems(
//        new ArrayList<>(Arrays.asList(
//            new Item("Coders' tears", 105253),
//            new Item("Papieska Kremówka", 2137)))
//    );
//
//    this.persons = new ArrayList<>(Arrays.asList(
//            new Person("Andrzej","Duda", LocalDate.of(1972,5,16), LocalDate.of(1972,5,16), Person.TypeOfEmployment.PART_TIME)
//    ));
//
//    this.vehicles = new ArrayList<>(Arrays.asList(new Truck(15, 1939, 1234, 4321, Vehicle.FuelType.PB, "Uzbekistan", "Dacia", "Logan")));
//
//    this.warehouses =
//        new ArrayList<>(Arrays.asList(new Warehouse("Berlin", new ArrayList<>(List.of(new Item("Michas", 60)))), new Warehouse("Moskwa", new ArrayList<>())));
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
