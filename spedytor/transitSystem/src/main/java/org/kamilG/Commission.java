package org.kamilG;

import java.time.LocalDate;
import java.util.List;

public class Commission extends ItemHolder {
  private Person driver;
  private Vehicle vehicle;
  private LocalDate startDate;
  private LocalDate fulfillDate;
  private Warehouse sourceWarehouse;
  private Warehouse destinationWarehouse;
  private LocalDate deadline;

  public Commission(
          Person driver,
          Vehicle vehicle,
          LocalDate startDate,
          Warehouse sourceWarehouse,
          Warehouse destinationWarehouse,
          LocalDate deadline,
          List<Item> items) {
    this.driver = driver;
    this.vehicle = vehicle;
    this.startDate = startDate;
    this.fulfillDate = null;
    this.sourceWarehouse = sourceWarehouse;
    this.destinationWarehouse = destinationWarehouse;
    this.deadline = deadline;
    setItems(items);
  }

  void fulfillCommission() {
    this.vehicle.setLocation(destinationWarehouse.getCity());

    transferAllItems(destinationWarehouse);

    this.fulfillDate = LocalDate.now();
  }

  public LocalDate getFulfillDate () {
    return fulfillDate;
  }

  @Override
  public String toString() {
    return "Commission "
        + "driver: "
        + driver.getName()
        + " "
        + driver.getSurname()
        + ", vehicle: "
        + vehicle.getModel()
        + ", start date: "
        + startDate
        + ", fulfillment date: "
        + fulfillDate
        + ", source warehouse: "
        + sourceWarehouse.getCity()
        + ", destination warehouse: "
        + destinationWarehouse.getCity()
        + ", deadline: "
        + deadline
            +", items: "
            +getItems();
  }
}
