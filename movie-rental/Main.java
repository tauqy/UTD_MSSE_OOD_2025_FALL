// --- IMPORTS ---
import Item.Book.Book;
import Item.Book.BookType;
import Item.Item;
import Item.Movie.Movie;
import Item.Movie.MovieType;
import Item.VideoGame.VideoGame;
import Item.VideoGame.VideoGameType;
import Item.Music.Music;
import Item.Music.MusicType;
import Item.GamingConsole.GameConsole;
import Item.GamingConsole.GameConsoleType;
import Item.Popcorn.Popcorn;
import Item.Popcorn.PopcornSize;

import Purchase.Purchase;
import Rental.Rental;

// --- COUPON IMPORTS ---
import Rental.Coupons.FiftyPercentOffRentalCoupon;
import Rental.Coupons.FreeMovieRedemptionRentalCoupon;
import Rental.Coupons.OneDollarOffRentalCoupon;
import Purchase.Coupons.FreeMoviePurchaseSeniorCoupon;
import Purchase.Coupons.OneDollarOffPurchaseCoupon;
import Transaction.Coupons.FiveDollarOffPurchaseTransactionCoupon;
import Transaction.Coupons.FiveDollarOffRentalTransactionCoupon;
import Transaction.Transaction;

public class Main {
    public static void main(String[] args){
        System.out.println("==========================================");
        System.out.println("      INITIATING SYSTEM VALIDATION        ");
        System.out.println("==========================================");

        // ==================================================================
        // 1. SETUP INVENTORY (Using Correct Enums)
        // ==================================================================

        // MOVIES (Rentable & Purchasable)
        Item movieNewRelease = new Movie("Dune: Part Two", MovieType.NEW_RELEASE);
        Item movieRegular    = new Movie("The Godfather", MovieType.REGULAR);
        Item movieChildren   = new Movie("Frozen", MovieType.CHILDREN);

        // BOOKS (Rentable & Purchasable)
        Item bookAction      = new Book("Harry Potter", BookType.ACTION); // Assuming ACTION exists in your Enum

        // MUSIC (Rentable Only - per your specific Factory design)
        Item musicCd         = new Music("Taylor Swift - 1989", MusicType.POP);

        // VIDEO GAMES (Purchasable Only)
        Item videoGame       = new VideoGame("Call of Duty", VideoGameType.ACTION);

        // CONSOLES (Purchasable Only)
        Item gameConsole     = new GameConsole("PS4", GameConsoleType.PS4); // Using PS4 enum for now

        // POPCORN (Purchasable Only)
        Item popcornLarge    = new Popcorn("Large Butter", PopcornSize.LARGE);

        // ==================================================================
        // 2. CREATE TRANSACTION OBJECT
        // ==================================================================
        Transaction transaction = new Transaction();

        // ==================================================================
        // 3. VALIDATE RENTALS & RENTAL COUPONS
        // ==================================================================
        System.out.println("\n--- Processing Rentals ---");

        // TEST 1: Rent New Release Movie + 50% Off Coupon
        Rental rental1 = new Rental(movieNewRelease, 3); // 3 days
        new FiftyPercentOffRentalCoupon(rental1);
        transaction.addRental(rental1);
        System.out.println("Added: Rental (Movie) + 50% Off Coupon");

        // TEST 2: Rent Book (No Coupon)
        Rental rental2 = new Rental(bookAction, 7); // 7 days
        transaction.addRental(rental2);
        System.out.println("Added: Rental (Book)");

        // TEST 3: Rent Music + $1 Off Coupon
        Rental rental3 = new Rental(musicCd, 5);
        new OneDollarOffRentalCoupon(rental3);
        transaction.addRental(rental3);
        System.out.println("Added: Rental (Music) + $1 Off Coupon");

        // NOTE: We do NOT rent Popcorn/VideoGame here to avoid "Unknown Item Type" exception.

        // ==================================================================
        // 4. VALIDATE PURCHASES & PURCHASE COUPONS
        // ==================================================================
        System.out.println("\n--- Processing Purchases ---");

        // TEST 4: Buy Regular Movie (Simulating Senior Logic later)
        Purchase purchase1 = new Purchase(movieRegular);
        // Validating Senior Coupon: args usually (Purchase, customerAge)
        new FreeMoviePurchaseSeniorCoupon(purchase1, 70);
        transaction.addPurchase(purchase1);
        System.out.println("Added: Purchase (Movie) + Senior Coupon");

        // TEST 5: Buy Video Game + $1 Off Coupon
        Purchase purchase2 = new Purchase(videoGame);
        new OneDollarOffPurchaseCoupon(purchase2);
        transaction.addPurchase(purchase2);
        System.out.println("Added: Purchase (VideoGame) + $1 Off Coupon");

        // TEST 6: Buy Console
        Purchase purchase3 = new Purchase(gameConsole);
        transaction.addPurchase(purchase3);
        System.out.println("Added: Purchase (Console)");

        // TEST 7: Buy Popcorn
        Purchase purchase4 = new Purchase(popcornLarge);
        transaction.addPurchase(purchase4);
        System.out.println("Added: Purchase (Popcorn)");

        // TEST 8: Buy Children's Movie (To bump up count for transaction coupons)
        Purchase purchase5 = new Purchase(movieChildren);
        transaction.addPurchase(purchase5);
        System.out.println("Added: Purchase (Children's Movie)");

        // ==================================================================
        // 5. VALIDATE TRANSACTION COUPONS
        // ==================================================================
        System.out.println("\n--- Applying Transaction Coupons ---");

        // Validate Rental Transaction Coupon (e.g., if rentals > 2, get $5 off)
        new FiveDollarOffRentalTransactionCoupon(transaction);
        System.out.println("Applied: $5 Off Rental Transaction Coupon");

        // Validate Purchase Transaction Coupon (e.g., if purchases > 2, get $5 off)
        new FiveDollarOffPurchaseTransactionCoupon(transaction);
        System.out.println("Applied: $5 Off Purchase Transaction Coupon");

        // ==================================================================
        // 6. GENERATE INITIAL STATEMENT
        // ==================================================================
        // Create Customer with Age 70 to satisfy Senior Coupon requirements
        Customer customer = new Customer("Jane Doe", 70, transaction);

        System.out.println("\n==========================================");
        System.out.println("           INITIAL STATEMENT              ");
        System.out.println("==========================================");
        System.out.println(customer.printStatement());

        // ==================================================================
        // 7. VALIDATE POINTS REDEMPTION (FREE ITEM)
        // ==================================================================
        System.out.println("\n--- Processing Point Redemption ---");

        int totalPoints = transaction.getTotalReward(transaction);
        System.out.println("Total Points Available: " + totalPoints);

        // Create a specific rental to redeem
        Movie redemptionMovie = new Movie("Reward Movie: Avatar", MovieType.NEW_RELEASE);
        Rental redemptionRental = new Rental(redemptionMovie, 1); // 1 day rental

        // Check if we have enough points (Assuming 10 points needed)
        if(totalPoints >= 10) {
            new FreeMovieRedemptionRentalCoupon(redemptionRental, totalPoints);
            transaction.addRental(redemptionRental);
            System.out.println("Success: Points redeemed for free movie.");
        } else {
            System.out.println("Skipped: Not enough points for redemption.");
        }

        // ==================================================================
        // 8. FINAL STATEMENT (XML & TEXT)
        // ==================================================================
        System.out.println("\n==========================================");
        System.out.println("            FINAL XML STATEMENT           ");
        System.out.println("==========================================");
        // Assuming printXmlStatement() exists based on your previous code
        System.out.println(customer.printXmlStatement());
    }
}