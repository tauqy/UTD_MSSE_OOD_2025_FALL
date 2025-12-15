package Transaction;

import Purchase.Purchase;
import Rental.Rental;

public class RegularTransactionPriceStrategy implements DiscountTransaction{
    @Override
    public double getTotalCost(Transaction transaction) {
        double totalCost = 0;
        // Calculate Rental Costs
        for(Rental rental: transaction.getRentals()){
            totalCost += rental.getPrice(rental);
        }
        // Calculate Purchase Costs
        for(Purchase purchase: transaction.getPurchases()){
            totalCost += purchase.getPrice(purchase);
        }
        return totalCost;
    }
}
