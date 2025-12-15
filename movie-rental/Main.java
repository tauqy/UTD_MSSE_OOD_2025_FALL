import Item.Book.Book;
import Item.Book.BookType;
import Item.Item;
import Item.Movie.Movie;
import Item.Movie.MovieType;
import Purchase.Purchase;
import Rental.Coupons.FiftyPercentOffRentalCoupon;
import Rental.Coupons.FreeMovieRedemptionRentalCoupon;
import Rental.Coupons.OneDollarOffChildrenMovieCoupon;
import Rental.Coupons.OneDollarOffRentalCoupon;
import Purchase.Coupons.FreeMoviePurchaseSeniorCoupon;
import Rental.Rental;
import Transaction.Coupons.FiveDollarOffPurchaseTransactionCoupon;
import Transaction.Coupons.FiveDollarOffRentalTransactionCoupon;
import Transaction.Transaction;

public class Main {
    public static void main(String[] args){
        int customerPoints = 0;

        // ==================================================================
        // 1. SETUP ITEMS
        // ==================================================================
        Item harryPotterBook = new Book("Harry Potter", BookType.ACTION);
        Item doctorSleepBook = new Book("Doctor Sleep", BookType.HORROR);
        Item tenetMovie      = new Movie("Tenet", MovieType.NEW_RELEASE);
        Item casablancaMovie = new Movie("Casablanca", MovieType.REGULAR);
        Item frozenMovie     = new Movie("Frozen II", MovieType.CHILDREN);
        Item annabella       = new Movie("Annabella", MovieType.NEW_RELEASE);
        Item moanaMovie      = new Movie("Moana", MovieType.CHILDREN);
        Item inceptionMovie  = new Movie("Inception", MovieType.NEW_RELEASE);

        // ==================================================================
        // 2. SETUP RENTALS
        // ==================================================================
        Rental harryPotterBookRental = new Rental(harryPotterBook, 10);
        Rental doctorSleepBookRental = new Rental(doctorSleepBook, 10);
        Rental tenetMovieRental      = new Rental(tenetMovie, 10);
        Rental casablancaMovieRental = new Rental(casablancaMovie, 2);

        // Age-Restricted Rental Coupon
        Rental moanaRental = new Rental(moanaMovie, 2);
        new OneDollarOffChildrenMovieCoupon(moanaRental, 20);

        // Apply Standard Coupons
        new FiftyPercentOffRentalCoupon(harryPotterBookRental);
        new FiftyPercentOffRentalCoupon(tenetMovieRental);
        new OneDollarOffRentalCoupon(doctorSleepBookRental);

        // ==================================================================
        // 3. SETUP PURCHASES
        // ==================================================================
        System.out.println("=== Testing Senior Citizen Free Purchase (Target: 65+ y/o) ===");

        // Senior Citizen Purchase (Free)
        Purchase seniorPersonPurchase = new Purchase(inceptionMovie);
        new FreeMoviePurchaseSeniorCoupon(seniorPersonPurchase, 70);
        System.out.println("Age 70 buying 'Inception': $" + seniorPersonPurchase.getPrice(seniorPersonPurchase));

        // Standard Purchases
        Purchase frozenMoviePurchase = new Purchase(frozenMovie);

        // ==================================================================
        // 4. CREATE TRANSACTION
        // ==================================================================
        Transaction transaction = new Transaction();

        // Add 5 Rentals
        transaction.addRental(harryPotterBookRental);
        transaction.addRental(doctorSleepBookRental);
        transaction.addRental(tenetMovieRental);
        transaction.addRental(casablancaMovieRental);
        transaction.addRental(moanaRental);

        // Add Purchases
        transaction.addPurchase(frozenMoviePurchase);
        transaction.addPurchase(frozenMoviePurchase);
        transaction.addPurchase(frozenMoviePurchase);
        transaction.addPurchase(seniorPersonPurchase);

        // ==================================================================
        // 5. CUSTOMER & INITIAL PRINTS (BOTH FORMATS)
        // ==================================================================
        Customer tauqeer = new Customer("Tauqeer Murtaza", 70, transaction);

        System.out.println("\n--- Statement Before Transaction Discounts ---");
        System.out.println(tauqeer.printStatement());
        System.out.println(tauqeer.printXmlStatement()); // <--- XML OUTPUT

        // ==================================================================
        // 6. APPLY TRANSACTION COUPONS
        // ==================================================================
        new FiveDollarOffRentalTransactionCoupon(transaction);

        transaction.addPurchase(frozenMoviePurchase); // Add 5th purchase to trigger coupon
        new FiveDollarOffPurchaseTransactionCoupon(transaction);

        System.out.println("\n--- After Transaction Discounts ---");
        System.out.println(tauqeer.printStatement());
        System.out.println(tauqeer.printXmlStatement()); // <--- XML OUTPUT

        // ==================================================================
        // 7. FREE MOVIE REDEMPTION LOGIC
        // ==================================================================
        System.out.println("\n=== Final Statement with Redemption ===");

        customerPoints = transaction.getTotalReward(transaction);
        System.out.println("Points available for redemption: " + customerPoints);

        Rental freeMovieRental = new Rental(annabella, 1);
        new FreeMovieRedemptionRentalCoupon(freeMovieRental, customerPoints);
        transaction.addRental(freeMovieRental);

        // Final Print in Both Formats
        System.out.println(tauqeer.printStatement());
        System.out.println(tauqeer.printXmlStatement()); // <--- XML OUTPUT
    }
}