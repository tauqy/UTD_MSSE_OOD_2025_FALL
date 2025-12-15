package Transaction.Coupons;

import Transaction.Transaction;

public class FiveDollarOffPurchaseTransactionCoupon extends TransactionCouponDecorator {
    private static final int PURCHASE_COUNT_THRESHOLD = 5;
    private static final double DISCOUNT_AMOUNT = 5.00;

    public FiveDollarOffPurchaseTransactionCoupon(Transaction transaction) {
        super(transaction.getTransactionStrategy());
        transaction.setTransactionStrategy(this);
    }

    @Override
    public double getTotalCost(Transaction transaction)  {
        double currentPrice = super.getTotalCost(transaction);
        int purchaseCount = transaction.getPurchases().size();

        return purchaseCount >= PURCHASE_COUNT_THRESHOLD ?
                currentPrice - DISCOUNT_AMOUNT :
                currentPrice;
    }
}
