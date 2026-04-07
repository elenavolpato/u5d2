package entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    private List<Pizza> pizzas;
    private List<Topping> toppings;
    private List<Drink> drinks;

    public void print() {
        System.out.println("------- PIZZERIA MENU -------");

        System.out.println("\nPIZZAS");
        pizzas.forEach(p -> {
            // Build the base string
            String info = String.format("%s | Calories: %d | Price: %.2f€",
                    p.getName(), p.getCalories(), p.getPrice());

            if (p.isXL()) {
                info += " (XL Format)";
            }

            System.out.println(info);
        });
        System.out.println("XL Pizza: + 2€");


        System.out.println("\nTOPPINGS");
        toppings.forEach(t -> System.out.println(t.getName() + " | Calories: " + t.getCalories() + " | Price: " + t.getPrice() + "€"));

        System.out.println("\nDRINKS");
        drinks.forEach(d -> System.out.println(d.getName() + " | Calories: " + d.getCalories() + " | Price: " + d.getPrice() + "€"));
    }
}