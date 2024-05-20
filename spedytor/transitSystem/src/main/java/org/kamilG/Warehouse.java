package org.kamilG;

import java.util.ArrayList;
import java.util.List;

public class Warehouse extends ItemHolder {
  String city;

  public Warehouse(String city, List<Item> items) {
    super(items);
    this.city = city;
  }

  void updateWarehouse() {
    // TODO
  }

  String getCity() {
    return city;
  }

  @Override
  public String toString() {
    return this.city + ": " + getItems().toString();
  }
}
