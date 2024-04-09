package vendingmachine;

import java.util.ArrayList;
import java.util.List;

import coin.Coin;
import item.Item;

public class VendingMachineState {

    public VendingMachineState() {
        System.out.println("Currently Vending machine is in Idle state");
    }

    public void clickOnStartProductSelectionButton() {
        System.out.println("Vending machine is in HasMoneyState");
    }

    public void insertCoin(VendingMachine vendingMachine, Coin coin) {
        System.out.println("Vending machine is in HasMoneyState");
        System.out.println("Accepted the Coin");
        vendingMachine.getCoinList().add(coin);
    }

    public void chooseProduct(VendingMachine vendingMachine, int itemCode) {
        Item item = vendingMachine.getInventory().getItem(itemCode);
        int paidByUser = 0;
        for (Coin coin : vendingMachine.getCoinList()) {
            paidByUser += coin.getValue();
        }

        if (item.getPrice() > paidByUser) {
            refundFullMoney(vendingMachine);
            return;
        } else {
            getChange(item.getPrice(), paidByUser);
            dispenseProduct(vendingMachine, itemCode);
            return;
        }
    }

    public List<Coin> refundFullMoney(VendingMachine vendingMachine) {
        System.out.println("Returned the full amount back in the coin dispense tray.");
        vendingMachine.setVendingMachineState(new VendingMachineState());
        return vendingMachine.getCoinList();
    }

    public void updateInventory(VendingMachine vendingMachine, Item item, int itemCode) {
        vendingMachine.getInventory().addItem(item, itemCode);
    }

    public void dispenseProduct(VendingMachine vendingMachine, int itemCode) {
        System.out.println("Currently vending machine is in dispense state");
        System.out.println("Product has been dispensed");

        vendingMachine.getInventory().updateSoldOutItem(itemCode);
        vendingMachine.setVendingMachineState(new VendingMachineState());

    }

    public void getChange(int itemPrice, int paidByUser) {
        System.out.println("Returned the change in the Coin Dispense Tray: " + (paidByUser - itemPrice));
    }
}
