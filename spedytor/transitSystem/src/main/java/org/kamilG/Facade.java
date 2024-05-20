package org.kamilG;

import java.util.ArrayList;
import java.util.List;

public class Facade extends ItemHolder {
  List<Warehouse> warehouses;
  List<Commission> commissions;
  List<Vehicle> vehicles;
  List<Person> people;

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
