package org.kamilG;

public interface Vehicle {
  String getInfo();

  void sentToWarehouse(Warehouse warehouse);

  void updateMileage(int mileage);

  String getLocation();
}
