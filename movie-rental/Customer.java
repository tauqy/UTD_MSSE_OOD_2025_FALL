import Purchase.Purchase;
import Rental.Rental;
import Transaction.Transaction;

public class Customer {
    private String name;
    private int age;

    private Transaction transaction;

    public Customer(String name, int age, Transaction transaction){
        this.name = name;
        this.age = age;
        this.transaction = transaction;
    }

    public String getName() {
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public String printStatement(){
        StringBuilder statement = new StringBuilder();
        if(!transaction.getPurchases().isEmpty() || !transaction.getRentals().isEmpty()) {
            statement.append("Transaction Record for ").append(this.getName()).append("\n");
            if (!this.transaction.getRentals().isEmpty()) {
                statement.append("Rental Record\n");
                statement.append("\tItem Name\t\t\tPrice\t\tFrequent Rental Points\n");
                for (Rental rental : transaction.getRentals()) {
                    statement.append("\t")
                            .append(rental.getItem().getTitle())
                            .append("\t\t")
                            .append(rental.getPrice(rental))
                            .append("\t\t\t")
                            .append(rental.getFrequentRentalPoint(rental))
                            .append("\n");
                }
            }
            if (!this.transaction.getPurchases().isEmpty()) {
                statement.append("Purchase Record\n");
                statement.append("\tItem Name\t\t\tPrice\t\tFrequent Rental Points\n");
                for (Purchase purchase : transaction.getPurchases()) {
                    statement.append("\t")
                            .append(purchase.getItem().getTitle())
                            .append("\t\t")
                            .append(purchase.getPrice(purchase))
                            .append("\t\t\t")
                            .append(purchase.getFrequentPurchasePoint(purchase))
                            .append("\n");
                }
            }
            statement.append("Transaction Summary\n");
            statement.append("Total Amount owed: $")
                    .append(String.valueOf(this.transaction.getTotalCost()))
                    .append("\n");
            statement.append("Total Rewards: ")
                    .append(String.valueOf(this.transaction.getTotalReward()));
        }
        else{
            statement.append("Not Transaction recorded\n");
        }
        return statement.toString();
    }

    public String printXmlStatement(){
        StringBuilder xmlStatement = new StringBuilder();
        if(!this.transaction.getRentals().isEmpty() || !this.transaction.getPurchases().isEmpty()) {
            xmlStatement.append("<customer name=\"").append(this.getName()).append("\">\n");
            if (!transaction.getRentals().isEmpty()) {
                xmlStatement.append("<rentalRecord>\n");
                for (Rental rental : transaction.getRentals()) {
                    xmlStatement.append("<Rental title=\"").append(rental.getItem().getTitle())
                            .append("\" daysRented=\"").append(rental.getDaysRented())
                            .append("\" charge=\"").append(rental.getPrice(rental))
                            .append("\" points=\"").append(rental.getFrequentRentalPoint(rental))
                            .append("\"/>\n");
                }
                xmlStatement.append("</rentalRecord>\n");
            }
            if (!transaction.getPurchases().isEmpty()) {
                xmlStatement.append("<purchaseRecord>\n");
                for (Purchase purchase : transaction.getPurchases()) {
                    xmlStatement.append("<Purchase title=\"").append(purchase.getItem().getTitle())
                            .append("\" charge=\"").append(purchase.getPrice(purchase))
                            .append("\" points=\"").append(purchase.getFrequentPurchasePoint(purchase))
                            .append("\"/>\n");
                }
                xmlStatement.append("</purchaseRecord>\n");
            }
            xmlStatement.append("  <totals>\n")
                    .append("    <totalCost>").append(transaction.getTotalCost()).append("</totalCost>\n")
                    .append("    <totalPoints>").append(transaction.getTotalReward()).append("</totalPoints>\n")
                    .append("  </totals>\n")
                    .append("</customer>");
        }
        else{
            xmlStatement.append("<No Transactions recorded></No Transaction recorded>");
        }
        return xmlStatement.toString();
    }
}