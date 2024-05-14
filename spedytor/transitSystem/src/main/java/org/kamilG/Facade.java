package org.kamilG;

import java.util.List;

public class Facade {
    List<Warehouse> warehouses;
    List<Commission> commissions;
    List<Vehicle> vehicles;
    List<Person> people;

    void addWarehouse(Warehouse warehouse) {
        warehouses.add(warehouse);
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
    void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }
    void addPerson(Person person) {
        people.add(person);
    }
    void removePerson(Person person) {
        people.remove(person);
    }
}
