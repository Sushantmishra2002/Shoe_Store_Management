import java.io.Serializable;

public class Shoe implements Serializable {
    private String brand;
    private String model;
    private int size;
    private double price;

    public Shoe(String brand, String model, int size, double price) {
        this.brand = brand;
        this.model = model;
        this.size = size;
        this.price = price;
    }

    public String getDetails() {
        return "Brand: " + brand + ", Model: " + model + ", Size: " + size + ", Price: $" + price;
    }
}
