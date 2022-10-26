public class Tree extends Product {

    private int height;
    private int code;

    public Tree(String name, double price, int height, int code) {
        super(name, price);
        this.height = height;
        this.code = code;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Tree{" + super.toString() +
                " height=" + height +
                ", code=" + code +
                '}';
    }
}
