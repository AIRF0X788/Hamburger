package hamburger;

import java.util.ArrayList;
import java.util.List;

class Hamburger {
    private String name;
    private double price;
    private List<String> toppings;

    public Hamburger(String name, double price) {
        this.name = name;
        this.price = price;
        toppings = new ArrayList<>();
    }

    public void addTopping(String topping, double price) {
        if (toppings.size() < 5) {
            toppings.add(topping);
            this.price += price;
        } else {
            System.out.println("Impossible d'ajouter plus de garnitures à l'hamburger.");
        }
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public List<String> getToppings() {
        return toppings;
    }
}