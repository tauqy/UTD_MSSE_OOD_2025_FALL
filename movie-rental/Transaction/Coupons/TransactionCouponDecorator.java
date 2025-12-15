package Transaction.Coupons;

import Transaction.DiscountTransaction;
import Transaction.Transaction;

public class TransactionCouponDecorator implements DiscountTransaction {
    protected DiscountTransaction discountTransaction;

    public TransactionCouponDecorator(DiscountTransaction discountTransaction){
        this.discountTransaction = discountTransaction;
    }

    @Override
    public double getTotalCost(Transaction transaction)  {
        return this.discountTransaction.getTotalCost(transaction);
    }
}
