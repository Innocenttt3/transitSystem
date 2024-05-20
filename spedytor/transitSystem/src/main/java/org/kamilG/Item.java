package org.kamilG;

public class Item {
  String name;
  int quantity;

  public Item(String name, int quantity) {
    this.name = name;
    this.quantity = quantity;
  }

  public void addQuantity(int amount) {
    quantity += amount;
  }

  @Override
  public String toString() {
    return name + " " + quantity;
  }
}
