package org.kamilG;

import java.util.ArrayList;
import java.util.List;

public abstract class ItemHolder {
  private List<Item> items = new ArrayList<>();

  public List<Item> getItems() {
    return items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }

  public ItemHolder() {}

  public ItemHolder(List<Item> items) {
    this.items = items;
  }

  public void addItems(List<Item> addedItems) {
    List<Item> addedItemsNew = new ArrayList<>(addedItems);

    for (Item addedItem : addedItems) {
      boolean found = false;
      for (Item warehouseItem : items) {
        if (addedItem.name.equals(warehouseItem.name)) {
          warehouseItem.addQuantity(addedItem.getQuantity());
          addedItemsNew.remove(addedItem);
          found = true;
          break;
        }
      }
      if(!found) {
        items.add(addedItem);
      }
    }

    //items.addAll(addedItemsNew);
  }

  public Item transferItems(int itemId, int amount) {
    if (amount <= 0) return null;
    if (amount >= this.items.get(itemId).getQuantity()) {
      Item itemToRemove = this.items.get(itemId);
      this.items.remove(itemToRemove);

      return itemToRemove;
    }

    int tmpQuantity = this.items.get(itemId).getQuantity() - amount;
    this.items.get(itemId).setQuantity(tmpQuantity);

    return new Item(this.items.get(itemId).name, amount);
  }

  public void transferAllItems(ItemHolder itemHolder) {
    itemHolder.addItems(items);
    items.clear();
  }
}
