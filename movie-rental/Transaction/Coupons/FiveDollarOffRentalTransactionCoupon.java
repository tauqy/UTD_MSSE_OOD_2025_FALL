package Transaction.Coupons;

import Transaction.Transaction;

public class FiveDollarOffRentalTransactionCoupon extends TransactionCouponDecorator {

    private static final int RENTAL_COUNT_THRESHOLD = 2;
    private static final double DISCOUNT_AMOUNT = 5.00;

    public FiveDollarOffRentalTransactionCoupon(Transaction transaction){
        super(transaction.getTransactionStrategy());
        transaction.setTransactionStrategy(this);
    }

    @Override
    public double getTotalCost(Transaction transaction)  {
        double currentPrice = super.getTotalCost(transaction);
        int rentalCount = transaction.getRentals().size();

        return rentalCount >= RENTAL_COUNT_THRESHOLD ?
                currentPrice - DISCOUNT_AMOUNT :
                currentPrice;
    }
}
