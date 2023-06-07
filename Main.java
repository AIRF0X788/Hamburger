package hamburger;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
        	System.out.println("                            |\\ /| /|_/|\r\n"
        			+ "                          |\\||-|\\||-/|/|\r\n"
        			+ "                           \\\\|\\|//||///\r\n"
        			+ "          _..----.._       |\\/\\||//||||\r\n"
        			+ "        .'     o    '.     |||\\\\|/\\\\ ||\r\n"
        			+ "       /   o       o  \\    | './\\_/.' |\r\n"
        			+ "      |o        o     o|   |          |\r\n"
        			+ "      /'-.._o     __.-'\\   |          |\r\n"
        			+ "      \\      `````     /   |          |\r\n"
        			+ "      |``--........--'`|    '.______.'\r\n"
        			+ "       \\              /\r\n"
        			+ "        `'----------'`");
            System.out.println(" ______     __  __     ______        __  __     ______     __    __     ______     __  __     ______     ______     ______     ______    \r\n"
            		+ "/\\  ___\\   /\\_\\_\\_\\   /\\  __ \\      /\\ \\_\\ \\   /\\  __ \\   /\\ \"-./  \\   /\\  == \\   /\\ \\/\\ \\   /\\  == \\   /\\  ___\\   /\\  ___\\   /\\  == \\   \r\n"
            		+ "\\ \\  __\\   \\/_/\\_\\/_  \\ \\ \\/\\ \\     \\ \\  __ \\  \\ \\  __ \\  \\ \\ \\-./\\ \\  \\ \\  __<   \\ \\ \\_\\ \\  \\ \\  __<   \\ \\ \\__ \\  \\ \\  __\\   \\ \\  __<   \r\n"
            		+ " \\ \\_____\\   /\\_\\/\\_\\  \\ \\_____\\     \\ \\_\\ \\_\\  \\ \\_\\ \\_\\  \\ \\_\\ \\ \\_\\  \\ \\_____\\  \\ \\_____\\  \\ \\_\\ \\_\\  \\ \\_____\\  \\ \\_____\\  \\ \\_\\ \\_\\ \r\n"
            		+ "  \\/_____/   \\/_/\\/_/   \\/_____/      \\/_/\\/_/   \\/_/\\/_/   \\/_/  \\/_/   \\/_____/   \\/_____/   \\/_/ /_/   \\/_____/   \\/_____/   \\/_/ /_/ \r\n"
            		+ "                                                                                                                                         ");
            System.out.println("Veuillez sélectionner le type de menu :");
            System.out.println("1. Menu par défaut");
            System.out.println("2. Menu personnalisé");
            System.out.println("3. Menu Deluxe");

            int menuChoice = scanner.nextInt();
            scanner.nextLine();

            switch (menuChoice) {
                case 1:
                    createDefaultMeal();
                    break;
                case 2:
                    createCustomMeal(scanner);
                    break;
                case 3:
                    createDeluxeMeal(scanner);
                    break;
                default:
                    System.out.println("Choix de menu invalide.");
                    break;
            }
        }
    }

    private static void createDefaultMeal() {
        Meal defaultMeal = new Meal();
        defaultMeal.display();
    }

    private static void createCustomMeal(Scanner scanner) {
        Hamburger hamburger = new Hamburger("Hamburger personnalisé", 4.99);

        System.out.print("Voulez-vous ajouter des garnitures ? (Oui/Non) : ");
        String addToppingsChoice = scanner.nextLine();
        if (addToppingsChoice.equalsIgnoreCase("Oui")) {
            selectToppings(hamburger, scanner);
        }

        Drink drink = selectDrink(scanner);
        Side side = selectSide(scanner);

        Meal customMeal = new Meal(hamburger, drink, side);
        customMeal.display();
    }

    private static void createDeluxeMeal(Scanner scanner) {
        DeluxeHamburger deluxeHamburger = new DeluxeHamburger();

        if (!selectDeluxeToppings(deluxeHamburger, scanner)) {
            System.out.println("Le nombre maximum de garnitures pour le menu Deluxe a été atteint.");
            return;
        }

        Drink deluxeDrink = selectDrink(scanner);
        Side deluxeSide = selectSide(scanner);

        Meal deluxeMeal = new Meal(deluxeHamburger, deluxeDrink, deluxeSide);
        deluxeMeal.display();
    }

    private static boolean selectToppings(Hamburger hamburger, Scanner scanner) {
        System.out.println("Voici la liste des garnitures disponibles :");
        System.out.println("1. Tomate supplémentaire - $0.50");
        System.out.println("2. Fromage supplémentaire - $1.00");
        System.out.println("3. Salade supplémentaire - $0.75");
        System.out.println("4. Steak supplémentaire - $2");
        System.out.println("5. Supplément sauce - $0.25");
        System.out.println("0. Arrêter d'ajouter des suppléments");

        System.out.println("\nVeuillez sélectionner les garnitures supplémentaires (maximum 3) :");

        int toppingCount = 0;

        while (toppingCount < 3) {
            System.out.print("Garniture (numéro) : ");
            int toppingNumber = scanner.nextInt();
            scanner.nextLine();

            if (toppingNumber == 0) {
                break; 
            }

            String topping;
            double price;

            switch (toppingNumber) {
                case 1:
                    topping = "Tomate supplémentaire";
                    price = 0.50;
                    break;
                case 2:
                    topping = "Fromage supplémentaire";
                    price = 1.00;
                    break;
                case 3:
                    topping = "Salade supplémentaire";
                    price = 0.75;
                    break;
                case 4:
                    topping = "Steak supplémentaire";
                    price = 2;
                    break;
                case 5:
                    topping = "Supplément sauce";
                    price = 0.25;
                    break;
                default:
                    System.out.println("Numéro de garniture invalide. Veuillez réessayer.");
                    continue;
            }

            hamburger.addTopping(topping, price);
            toppingCount++;
        }

        return true;
    }

    private static boolean selectDeluxeToppings(DeluxeHamburger deluxeHamburger, Scanner scanner) {
        System.out.println("Voici la liste des garnitures disponibles :");
        System.out.println("1. Tomate supplémentaire");
        System.out.println("2. Fromage supplémentaire");
        System.out.println("3. Salade supplémentaire");
        System.out.println("4. Steak supplémentaire");
        System.out.println("5. Supplément sauce");
        System.out.println("6. Supplément bacon");
        System.out.println("7. Supplément cornichon");
        System.out.println("8. Supplément onion frit");
        System.out.println("0. Arrêter d'ajouter des suppléments");

        System.out.println("\nVeuillez sélectionner les garnitures supplémentaires (maximum 5) :");

        int toppingCount = 0; 

        while (toppingCount < 5) {
            System.out.print("Garniture (numéro) : ");
            int toppingNumber = scanner.nextInt();
            scanner.nextLine();

            if (toppingNumber == 0) {
                break; 
            }
            
            String topping;
            double price;

            switch (toppingNumber) {
            case 1:
                topping = "Tomate supplémentaire";
                price = 0;
                break;
            case 2:
                topping = "Fromage supplémentaire";
                price = 0;
                break;
            case 3:
                topping = "Salade supplémentaire";
                price = 0;
                break;
            case 4:
                topping = "Steak supplémentaire";
                price = 0;
                break;
            case 5:
                topping = "Supplément sauce";
                price = 0;
                break;
            case 6:
                topping = "Supplément bacon";
                price = 0;
                break;
            case 7:
                topping = "Supplément cornichon";
                price = 0;
                break;
            case 8:
                topping = "Supplément onion frit";
                price = 0;
                break;
                default:
                    System.out.println("Numéro de garniture invalide. Veuillez réessayer.");
                    continue;
            }

            deluxeHamburger.addTopping(topping, price);
            toppingCount++;
        }

        return true; 
    }

    private static Drink selectDrink(Scanner scanner) {
        System.out.println("Voici la liste des boissons disponibles :");
        System.out.println("1. Coca-Cola - Moyen - $1.99");
        System.out.println("2. Coca-Cola - Grand - $2.99");
        System.out.println("3. Sprite - Moyen - $1.99");
        System.out.println("4. Sprite - Grand - $2.99");

        System.out.println("\nVeuillez sélectionner une boisson :");

        int drinkChoice = scanner.nextInt();
        scanner.nextLine();

        String name;
        String size;
        double price;

        switch (drinkChoice) {
        case 1:
            name = "Coca-Cola";
            size = "Moyen";
            price = 1.99;
            break;
        case 2:
            name = "Coca-Cola";
            size = "Grand";
            price = 2.99;
            break;
        case 3:
            name = "Sprite";
            size = "Moyen";
            price = 1.99;
            break;
        case 4:
            name = "Sprite";
            size = "Grand";
            price = 2.99;
            break;
        default:
            System.out.println("Choix de boisson invalide. La boisson par défaut sera sélectionnée.");
            name = "Coca-Cola";
            size = "Moyen";
            price = 1.99;
            break;
    }

        return new Drink(name, size, price);
    }

    private static Side selectSide(Scanner scanner) {
        System.out.println("Voici la liste des accompagnements disponibles :");
        System.out.println("1. Frites - $1.49");
        System.out.println("2. Onion Rings - $2.99");

        System.out.println("\nVeuillez sélectionner un accompagnement :");

        int sideChoice = scanner.nextInt();
        scanner.nextLine();

        String name;
        double price;

        switch (sideChoice) {
            case 1:
                name = "Frites";
                price = 1.49;
                break;
            case 2:
                name = "Onion Rings";
                price = 2.99;
                break;
            default:
                System.out.println("Choix d'accompagnement invalide. L'accompagnement par défaut sera sélectionné.");
                name = "Frites";
                price = 1.49;
                break;
        }

        return new Side(name, price);
    }
}
