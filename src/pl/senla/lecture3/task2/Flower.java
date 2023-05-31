package pl.senla.lecture3.task2;

public class Flower {

    private String name;
    private int price;
    private boolean inBouquet;

    public Flower(String name, int price, boolean inBouquet) {
        this.name = name;
        this.price = price;
        this.inBouquet = inBouquet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isInBouquet() {
        return inBouquet;
    }

    public void setInBouquet(boolean inBouquet) {
        this.inBouquet = inBouquet;
    }

    @Override
    public String toString() {
        return "\nFlower{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", inBouquet=" + inBouquet +
                '}';
    }
}
