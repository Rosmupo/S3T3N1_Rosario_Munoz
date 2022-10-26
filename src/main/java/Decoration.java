public class Decoration extends Product{

    private String material;
    private int code;

    public Decoration(String name, double price, String material, int code) {
        super(name, price);
        this.material = material;
        this.code = code;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Decoration{" + super.toString() +
                " material='" + material + '\'' +
                ", code=" + code +
                '}';
    }
}
