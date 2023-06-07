package hamburger;

public class Meal {
    private Hamburger hamburger;
    private Drink drink;
    private Side side;

    public Meal() {
        this.hamburger = new Hamburger("Hamburger normal", 3.99);
        this.drink = new Drink("Coca-Cola", "Petit", 1.49);
        this.side = new Side("Frites", 1.99);
    }

    public Meal(Hamburger hamburger, Drink drink, Side side) {
        this.hamburger = hamburger;
        this.drink = drink;
        this.side = side;
    }

    public void display() {
        System.out.println("Commande de repas :");
        System.out.println("Hamburger : " + hamburger.getName() + " - " + hamburger.getPrice());
        System.out.println("Garnitures supplémentaires : " + hamburger.getToppings());
        System.out.println("Boisson : " + drink.getName() + " - " + drink.getSize() + " - " + drink.getPrice());
        System.out.println("Accompagnement : " + side.getName() + " - " + side.getPrice());
        System.out.println("Prix total : " + getTotalPrice());
    }

    private double getTotalPrice() {
        return hamburger.getPrice() + drink.getPrice() + side.getPrice();
    }
}
