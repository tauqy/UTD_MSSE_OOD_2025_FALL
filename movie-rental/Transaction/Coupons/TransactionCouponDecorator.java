package Transaction.Coupons;

import Transaction.DiscountTransaction;

public class TransactionCouponDecorator implements DiscountTransaction {
    protected DiscountTransaction discountTransaction;

    public TransactionCouponDecorator(DiscountTransaction discountTransaction){
        this.discountTransaction = discountTransaction;
    }

    @Override
    public double getTotalCost()  {
        return this.discountTransaction.getTotalCost();
    }

    @Override
    public int getTotalReward() {
        return this.discountTransaction.getTotalReward();
    }
}
