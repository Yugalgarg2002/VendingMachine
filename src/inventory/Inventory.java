package inventory;

import item.*;

public class Inventory {
    private ItemShelf[] inventory;

    public Inventory(int n) {
        inventory = new ItemShelf[n];
        initialEmptyInventory();
    }

    private void initialEmptyInventory() {
        int startCode = 101;
        for (int i = 0; i < inventory.length; i++) {
            ItemShelf itemShelf = new ItemShelf();
            itemShelf.setItemCode(startCode);
            itemShelf.setSoldOut(true);
            inventory[i] = itemShelf;
            startCode++;
        }
    }

    public ItemShelf[] getInventory() {
        return inventory;
    }

    public void setInventory(ItemShelf[] inventory) {
        this.inventory = inventory;
    }

    public void addItem(Item item, int itemCode) {
        for (ItemShelf shelf : inventory) {
            if (shelf.getItemCode() == itemCode) {
                if (shelf.isSoldOut() == true) {
                    shelf.setItem(item);
                    shelf.setSoldOut(false);
                }
            }
        }
    }

    public Item getItem(int itemCode) {
        for (ItemShelf shelf : inventory) {
            if (shelf.getItemCode() == itemCode) {
                if (shelf.isSoldOut()) {
                    System.out.println("Item already sold out.");
                    return new Item();
                } else {
                    return shelf.getItem();
                }

            }
        }

        System.out.println("Invalid Item Code");
        return new Item();
    }

    public void updateSoldOutItem(int itemCode) {
        for (ItemShelf shelf : inventory) {
            if (shelf.getItemCode() == itemCode) {
                shelf.setSoldOut(true);
            }
        }
    }
}
