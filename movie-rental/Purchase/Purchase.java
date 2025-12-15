package Purchase;

import Item.Item;
import Purchase.Strategys.FrequentPurchasePoint.Factory.ItemFrequentPurchasePointFactory;
import Purchase.Strategys.PurchasePrice.Factory.ItemPurchaseStrategyFactory;

public class Purchase implements DiscountPurchase, DiscountFrequentPurchasePoint {

    private Item item;

    private DiscountPurchase discountPurchaseStrategy;
    private final DiscountFrequentPurchasePoint discountFrequentPurchasePointStrategy;

    public Purchase(Item item){
        this.item = item;

        ItemPurchaseStrategyFactory itemPurchaseStrategyFactory = new ItemPurchaseStrategyFactory();
        ItemFrequentPurchasePointFactory itemFrequentPurchasePointFactory = new ItemFrequentPurchasePointFactory();

        this.discountPurchaseStrategy = itemPurchaseStrategyFactory.getStrategy(this.item);
        this.discountFrequentPurchasePointStrategy = itemFrequentPurchasePointFactory.getStrategy(this.item);
    }

    public DiscountPurchase getDiscountPurchase(){
        return this.discountPurchaseStrategy;
    }

    public void setDiscountPurchase(DiscountPurchase discountPurchase){
        this.discountPurchaseStrategy = discountPurchase;
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
