import Rental.DiscountRental;
import Rental.Rental;
import Transaction.Transaction;

public class Statement {
    public void PrintStatement(Customer customer){
        StringBuilder statement = new StringBuilder("Transaction Record for "+customer.getName()+"\n");
        //Show figures for this rental

    }

    public void PrintXmlStatement(Customer customer){
    }
}
