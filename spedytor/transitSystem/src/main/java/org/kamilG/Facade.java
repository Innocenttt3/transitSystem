package org.kamilG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Facade extends ItemHolder {
  List<Warehouse> warehouses = new ArrayList<>();
  List<Commission> commissions = new ArrayList<>();
  List<Vehicle> vehicles = new ArrayList<>();
  List<Person> people = new ArrayList<>();

  Facade() {
    this.setItems(
        new ArrayList<>(Arrays.asList(
            new Item("Coders' tears", 105253),
            new Item("Michas", 60),
            new Item("Papieska Kremówka", 2137))));
  }

  void addWarehouse(Warehouse warehouse) {
    warehouses.add(warehouse);
  }

  void removeWarehouse(int warehouseId) {
    Warehouse warehouse = warehouses.get(warehouseId);
    warehouse.transferAllItems(this);

    removeWarehouse(warehouse);
  }

  void removeWarehouse(Warehouse warehouse) {
    warehouses.remove(warehouse);
  }

  void addCommission(Commission commission) {
    commissions.add(commission);
  }

  void removeCommission(Commission commission) {
    commissions.remove(commission);
  }

  void addVehicle(Vehicle vehicle) {
    vehicles.add(vehicle);
  }

  void removeVehicle(int vehicleId) {
    vehicles.remove(vehicleId);
  }

  void removeVehicle(Vehicle vehicle) {
    vehicles.remove(vehicle);
  }

  void addPerson(Person person) {
    people.add(person);
  }

  void removePerson(int id) {
    people.remove(id);
  }

  void fulfillCommission(Commission commission) {
    commission.fulfillCommission();
  }
}
