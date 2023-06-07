package hamburger;

class Drink {
    private String name;
    private String size;
    private double price;

    public Drink(String name, String size, double price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }
}