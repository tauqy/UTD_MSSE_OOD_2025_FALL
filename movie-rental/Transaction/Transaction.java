package Transaction;

import Purchase.Purchase;
import Rental.Rental;

import java.util.ArrayList;

public class Transaction implements DiscountTransaction {

    private ArrayList<Rental> rentals;
    private ArrayList<Purchase> purchases;

    public Transaction(){
        this.rentals = new ArrayList<>();
        this.purchases = new ArrayList<>();
    }

    public void addRental(Rental rental){
        this.rentals.add(rental);
    }

    public void addPurchase(Purchase purchase){
        this.purchases.add(purchase);
    }

    public ArrayList<Rental> getRentals(){
        return this.rentals;
    }

    public ArrayList<Purchase> getPurchases(){
        return this.purchases;
    }

    @Override
    public double getTotalCost() {
        double totalCost = 0;
        for(Rental rental: this.rentals){
            totalCost += rental.getPrice(rental);
        }
        for(Purchase purchase: this.purchases){
            totalCost += purchase.getPrice(purchase);
        }
        return totalCost;
    }

    @Override
    public int getTotalReward() {
        int totalReward = 0;
        for(Rental rental: this.rentals){
            totalReward += rental.getFrequentRentalPoint(rental);
        }
        for (Purchase purchase: this.purchases){
            totalReward += purchase.getFrequentPurchasePoint(purchase);
        }
        return totalReward;
    }
}
