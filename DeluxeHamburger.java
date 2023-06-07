package hamburger;

public class DeluxeHamburger extends Hamburger {
    public DeluxeHamburger() {
        super("Deluxe Hamburger", 5.99);
    }

    public void addTopping(String topping) {
        System.out.println("Impossible d'ajouter des garnitures supplémentaires au menu Deluxe.");
    }
    
}
