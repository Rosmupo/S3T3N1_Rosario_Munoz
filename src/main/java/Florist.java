import java.util.ArrayList;


public class Florist {

    private String name;
    private ArrayList<Flower> flowerList;
    private ArrayList<Tree> treeList;
    private ArrayList<Decoration> decorationList;
    private ArrayList<Ticket> ticketsList;
    private double totalValue;

    public Florist(String name) {
        this.name = name;
        flowerList = new ArrayList<>();
        treeList = new ArrayList<>();
        decorationList = new ArrayList<>();
        ticketsList = new ArrayList<>();
    }


    public Flower addFlowerToList(Flower flower){
        flowerList.add(flower);
        return flower;
    }
    public Decoration addDecorationToList(Decoration decoration) {
        decorationList.add(decoration);
        return decoration;
    }
    public Tree addTreeToList(Tree tree) {
        treeList.add(tree);
        return tree;
    }

    public void printFlowers(){
        for (Flower flo: flowerList) {
            System.out.println(flo.toString());
        }
    }
    public void printDecoration(){
        for (Decoration dec: decorationList) {
            System.out.println(dec.toString());
        }
    }
    public void printTree(){
        for (Tree tr: treeList) {
            System.out.println(tr.toString());
        }
    }

    public double getTotalValue() {

        double a = getProductsValue( flowerList);
        double b = getProductsValue(decorationList);
        double c = getProductsValue(treeList);

        totalValue = a + b + c;

        return totalValue;
    }


    public double getProductsValue(ArrayList<?> list ) {
        double sum = 0;
        for (Object obj : list) {
            Product product = (Product) obj;
            sum += product.getPrice();
        }
        return sum;
    }
    public void totalAllSales(){
        double sum = 0;
        for (Ticket ticket: ticketsList){
            sum+= ticket.getTotal();
        }
        System.out.println("El total es " + sum);
    }


    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Flower> getFlowerList() {
        return flowerList;
    }

    public void setFlowerList(ArrayList<Flower> flowerList) {
        this.flowerList = flowerList;
    }

    public ArrayList<Tree> getTreeList() {
        return treeList;
    }

    public void setTreeList(ArrayList<Tree> treeList) {
        this.treeList = treeList;
    }

    public ArrayList<Decoration> getDecorationList() {
        return decorationList;
    }

    public void setDecorationList(ArrayList<Decoration> decorationList) {
        this.decorationList = decorationList;
    }

    public ArrayList<Ticket> getTicketsList() {
        return ticketsList;
    }

    public void setTicketsList(ArrayList<Ticket> ticketsList) {
        this.ticketsList = ticketsList;
    }

    public void printTicket() {
        for (Ticket ticket: ticketsList) {
            System.out.println(ticket.toString());
        }
    }

    @Override
    public String toString() {
        return "Florist{" +
                "name='" + name + '\'' +
                ", flowerList=" + flowerList +
                ", treeList=" + treeList +
                ", decorationList=" + decorationList +
                ", ticketsList=" + ticketsList +
                ", totalValue=" + totalValue +
                '}';
    }

}
