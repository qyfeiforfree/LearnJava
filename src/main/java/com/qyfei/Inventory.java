package com.qyfei;

public class Inventory {
    private double quantity;
    private double amount;

    public double setQuantity(double quantity) {
        return quantity;
    }

    public double setAmount(double amount) {
        return amount;
    }

    public void checkIn(double qty, double amt) {
        quantity += qty;
        amount += amt;
    }

    public double checkOut(double qty) {
        if (qty > quantity) return 0;
        double amt = amount;
        if (qty < quantity) {
            double price = (long) (amount / quantity * 100) / 100;
            amt = qty * price;
        }
        quantity -= qty;
        amount -= amt;

        return amt;
    }

    public double getAmount() {
        return amount;
    }

    public double getQuantity() {
        return quantity;
    }

}
