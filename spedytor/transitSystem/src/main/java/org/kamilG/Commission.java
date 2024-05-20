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

    void fulfillCommission() {
        this.vehicle.setLocation(destinationWarehouse.getCity());

        transferAllItems(destinationWarehouse);

        this.fulfillDate = LocalDate.now();
    }
}