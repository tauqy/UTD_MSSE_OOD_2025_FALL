package Transaction.Coupons;

import Transaction.DiscountTransaction;

public class FiveDollarOffTransactionCoupon extends TransactionCouponDecorator {

    private static final int RENTAL_COUNT_THRESHOLD = 5;
    private static final double DISCOUNT_AMOUNT = 5.00;

    public FiveDollarOffTransactionCoupon(DiscountTransaction discountTransaction){
        super(discountTransaction);
    }


    public double getRentalsPrice() {
      //  double currentPrice = super.getRentalsPrice();
//        int rentalCount = super.getRentals().size();
//
//        return rentalCount >= DISCOUNT_AMOUNT ?
//                currentPrice - DISCOUNT_AMOUNT :
//                currentPrice;
        return 0;
    }
}
