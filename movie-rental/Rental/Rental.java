package Rental;

import Item.Item;
import Rental.Strategys.FrequentRentalPoints.Factory.ItemFrequentRentalPointFactory;
import Rental.Strategys.RentalPrice.Factory.ItemRentalPriceStrategyFactory;

public class Rental implements DiscountRental, DiscountFrequentRentalPoint {
    private final Item item;
    private final int daysRented;

    private DiscountRental discountRentalStrategy;
    private final DiscountFrequentRentalPoint discountFrequentRentalPointStrategy;

    public Rental(Item item,int daysRented){
        this.item = item;
        this.daysRented = daysRented;

        //Factory creation
        ItemRentalPriceStrategyFactory rentalPriceStrategyFactory = new ItemRentalPriceStrategyFactory();
        ItemFrequentRentalPointFactory frequentRentalPointFactory = new ItemFrequentRentalPointFactory();

        //Strategy selection
        this.discountRentalStrategy = rentalPriceStrategyFactory.getRentalPriceStrategy(this);
        this.discountFrequentRentalPointStrategy = frequentRentalPointFactory.getFrequentRentalPointStrategy(this);
    }

    public DiscountRental getDiscountRental(){
        return this.discountRentalStrategy;
    }

    public void setDiscountRental(DiscountRental discountRental){
        this.discountRentalStrategy = discountRental;
    }

    public int getDaysRented() {
        return this.daysRented;
    }

    public Item getItem() {
        return this.item;
    }

    @Override
    public double getPrice(Rental rental) {
        return this.discountRentalStrategy.getPrice(this);
    }

    @Override
    public int getFrequentRentalPoint(Rental rental) {
        return this.discountFrequentRentalPointStrategy.getFrequentRentalPoint(this);
    }
}