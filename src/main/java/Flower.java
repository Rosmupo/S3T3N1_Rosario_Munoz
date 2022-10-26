public class Flower extends Product {


    private String color;
    private int code;

    public Flower(String name, double price, String color, int code) {
        super(name, price);
        this.color = color;
        this.code = code;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Flower{" + super.toString() +
                ", color='" + color + '\'' +
                ", code=" + code +

                '}';
    }
}
