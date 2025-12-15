package Purchase;

import Item.Item;
import Purchase.Strategies.FrequentPurchasePoint.Factory.ItemFrequentPurchasePointFactory;
import Purchase.Strategies.PurchasePrice.Factory.ItemPurchaseStrategyFactory;

public class Purchase implements DiscountPurchase, DiscountFrequentPurchasePoint {

    private Item item;

    private DiscountPurchase discountPurchaseStrategy;
    private DiscountFrequentPurchasePoint discountFrequentPurchasePointStrategy;

    public Purchase(Item item){
        this.item = item;

        ItemPurchaseStrategyFactory itemPurchaseStrategyFactory = new ItemPurchaseStrategyFactory();
        ItemFrequentPurchasePointFactory itemFrequentPurchasePointFactory = new ItemFrequentPurchasePointFactory();

        this.discountPurchaseStrategy = itemPurchaseStrategyFactory.getStrategy(this);
        this.discountFrequentPurchasePointStrategy = itemFrequentPurchasePointFactory.getStrategy(this);
    }

    public DiscountPurchase getDiscountPurchase(){
        return this.discountPurchaseStrategy;
    }

    public void setDiscountPurchase(DiscountPurchase discountPurchase){
        this.discountPurchaseStrategy = discountPurchase;
    }

    public void setFrequentPurchasePointStrategy(DiscountFrequentPurchasePoint strategy) {
        this.discountFrequentPurchasePointStrategy = strategy;
    }

    public DiscountFrequentPurchasePoint getFrequentPurchasePointStrategy() {
        return this.discountFrequentPurchasePointStrategy;
    }

    public Item getItem() {
        return item;
    }

    @Override
    public int getFrequentPurchasePoint(Purchase purchase) {
        return this.discountFrequentPurchasePointStrategy.getFrequentPurchasePoint(purchase);
    }

    @Override
    public double getPrice(Purchase purchase) {
        return this.discountPurchaseStrategy.getPrice(purchase);
    }
}
