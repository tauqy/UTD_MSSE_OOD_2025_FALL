package Transaction;

import Purchase.Purchase;
import Rental.Rental;

import java.util.ArrayList;

public class Transaction implements DiscountTransaction, DiscountTransactionRewards {

    private ArrayList<Rental> rentals;
    private ArrayList<Purchase> purchases;

    private DiscountTransaction transactionStrategy;

    public Transaction(){
        this.rentals = new ArrayList<>();
        this.purchases = new ArrayList<>();

        this.transactionStrategy = new RegularTransactionPriceStrategy();
    }

    public DiscountTransaction getTransactionStrategy(){
        return this.transactionStrategy;
    }

    public void setTransactionStrategy(DiscountTransaction discountTransaction){
        this.transactionStrategy = discountTransaction;
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

    public double getTotalRentalCost(Transaction transaction) {
        double totalCost = 0;
        for(Rental rental: transaction.getRentals()){
            totalCost += rental.getPrice(rental);
        }
        return totalCost;
    }

    public double getTotalPurchaseCost(Transaction transaction) {
        double totalCost = 0;
        for(Purchase purchase: transaction.getPurchases()){
            totalCost += purchase.getPrice(purchase);
        }
        return totalCost;
    }

    @Override
    public double getTotalCost(Transaction transaction) {
        return this.transactionStrategy.getTotalCost(transaction);
    }

    @Override
    public int getTotalReward(Transaction transaction) {
        int totalReward = 0;
        for(Rental rental: transaction.getRentals()){
            totalReward += rental.getFrequentRentalPoint(rental);
        }
        for (Purchase purchase: transaction.getPurchases()){
            totalReward += purchase.getFrequentPurchasePoint(purchase);
        }
        return totalReward;
    }
}
