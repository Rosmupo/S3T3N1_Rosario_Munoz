
import java.util.ArrayList;
import java.util.UUID;

public class Ticket {

    private String ticketId = UUID.randomUUID().toString();
    ArrayList<Product> productsList;
    private double total;



    public Ticket( ) {
        productsList = new ArrayList<Product>();
    }

    public void addProduct(Product p) {
        productsList.add(p);
    }

    public void calculateTotal() {
        double total = 0;
        for (Product product : productsList) {
            total += product.getPrice();
        }
        this.total = total;

    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public ArrayList<Product> getProductsList() {
        return productsList;
    }

    public void setProductsList(ArrayList<Product> productsList) {
        this.productsList = productsList;
    }

    public double getTotal() {
        double sum = 0;

        for (Product product : productsList) {
            sum += product.getPrice();
        }
        total = sum;
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void addProductsToTicket(int option, Florist florist) {

        switch (option) {

            case 1:
                System.out.println("Ha seleccionado agregar flor");
                if (florist.getFlowerList().get(0)== null){
                    System.out.println("no hay flores para agregar al ticket");
                } else {
                    productsList.add(florist.getFlowerList().get(0));
                    florist.getFlowerList().remove(0);
                    calculateTotal();
                }
                break;
            case 2:

                break;
            case 3:

                break;
        }

    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", total=" + total +
                '}';
    }
}


