import Item.Book.Book;
import Item.Book.BookType;
import Item.Item;
import Item.Movie.Movie;
import Item.Movie.MovieType;
import Purchase.Purchase;
import Rental.Coupons.FiftyPercentOffRentalCoupon;
import Rental.Coupons.OneDollarOffRentalCoupon;
import Rental.Rental;
import Transaction.Transaction;

public class Main {
    public static void main(String[] args){

        //Books
        Item harryPotterBook = new Book("Harry Potter", BookType.ACTION);
        Item doctorSleepBook = new Book("Doctor Sleep", BookType.HORROR);
        //Movies
        Item tenetMovie = new Movie("Tenet", MovieType.NEW_RELEASE);
        Item casablancaMovie = new Movie("Casablanca", MovieType.REGULAR);
        Item frozenMovie = new Movie("Frozen II", MovieType.CHILDREN);

        //Rental
        Rental harryPotterBookRental = new Rental(harryPotterBook, 10);
        Rental doctorSleepBookRental = new Rental(doctorSleepBook, 10);
        Rental tenetMovieRental = new Rental(tenetMovie, 10);
        Rental casablancaMovieRental = new Rental(casablancaMovie, 2);

        //Rental Coupons
        new FiftyPercentOffRentalCoupon(harryPotterBookRental);
        new FiftyPercentOffRentalCoupon(tenetMovieRental);
        new OneDollarOffRentalCoupon(doctorSleepBookRental);

        Purchase frozenMoviePurchase = new Purchase(frozenMovie);


        //Transaction
        Transaction transaction = new Transaction();
        //Rental Transaction
        transaction.addRental(harryPotterBookRental);
        transaction.addRental(doctorSleepBookRental);
        transaction.addRental(tenetMovieRental);
        transaction.addRental(casablancaMovieRental);
        //Purchase Transaction
        transaction.addPurchase(frozenMoviePurchase);

        //Customer
        Customer tauqeer = new Customer("Tauqeer Murtaza", 15, transaction);
        System.out.println(tauqeer.printStatement());
        System.out.println(tauqeer.printXmlStatement());
    }
}