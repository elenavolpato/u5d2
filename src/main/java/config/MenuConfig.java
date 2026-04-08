package config;

import entities.Drink;
import entities.Menu;
import entities.Pizza;
import entities.Topping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


//Exercise #1
//Implement a Spring project containing the model for a menu printing system for a pizzeria.
//
//The pizzeria offers pizza and drinks, which have a price and nutritional information that must appear on the menu. Every pizza has a base of tomato and mozzarella (margherita) and can be enriched with various toppings that can be added multiple times (e.g., margherita + double ham).
//Topping combinations have a name (e.g., Hawaiian Pizza for a margherita with ham and pineapple), and these names must appear on the menu.
//
//1.1 Define the class hierarchy for pizzas, drinks, toppings, and the menu.
//
//1.2 Create a configuration class for Beans containing various Beans for pizzas, toppings, and drinks.
//
//1.3 From the main method, call the entities.Drink.Menu type Bean (also defined in the configuration class) and print its content to the screen.
//
//Optional: Provide the possibility to include XL format pizzas on the menu.
//Optional: Use Lombok.
@Configuration
public class MenuConfig {

    // toppings
    @Bean
    public Topping tomatoTopping() {
        return new Topping("Tomato", 0, 0.0);
    }
    @Bean(name = "cheese")
    public Topping cheeseTopping() {
        return new Topping("Cheese", 92, 0.69);
    }

    @Bean(name = "ham")
    public Topping hamTopping() {
        return new Topping("Ham", 35, 0.99);
    }

    @Bean(name = "onions")
    public Topping onionsTopping() {
        return new Topping("Onions", 22, 0.69);
    }

    @Bean(name = "pineapple")
    public Topping pineappleTopping() {
         Topping p = new Topping("Pineapple", 24, 0.79);
        System.out.println("here" + p);
        return p;
    }

    @Bean(name = "salami")
    public Topping salamiTopping() {
        return new Topping("Salami", 86, 0.99);
    }

    // drinks
    @Bean (name="lemonade")
    public Drink lemonade(){
        return new Drink("Lemonade", 128, 1.29, "0.33l");
    }

    @Bean (name="water")
    public Drink water(){
        return new Drink("Water", 0, 1.29, "0.5l");
    }

    @Bean (name="wine")
    public Drink wine(){
        return new Drink("Wine", 607, 7.49, "0.75l, 13%");
    }

    // pizzas
    @Bean
    public Pizza margheritaPizza(){
        Pizza p = new Pizza("Margherita");
        p.getToppingList().add(tomatoTopping());
        p.getToppingList().add(cheeseTopping());
        return p;
    }

    @Bean
    public Pizza salamiPizza(){
        Pizza p = new Pizza("Salami");
        p.getToppingList().add(tomatoTopping());
        p.getToppingList().add(cheeseTopping());
        p.getToppingList().add(salamiTopping());
        return p;
    }

    @Bean
    public Pizza hawaiianPizza(){
        Pizza p = new Pizza("Hawaiian Pizza");
        p.getToppingList().add(tomatoTopping());
        p.getToppingList().add(cheeseTopping());
        p.getToppingList().add(hamTopping());
        p.getToppingList().add(pineappleTopping());
        return p;
    }

    @Bean
    public Pizza customPizzaDoubleHam() {
        Pizza p = new Pizza("Custom Pizza: Margherita + Double Ham");
        p.getToppingList().add(tomatoTopping());
        p.getToppingList().add(cheeseTopping());
        p.getToppingList().add(hamTopping());
        p.getToppingList().add(hamTopping());
        p.setXL(true);
        return p;
    }


    @Bean
    public Menu pizzeriaMenu2(List<Pizza> pizzas, List<Topping> toppings, List<Drink> drinks){
        return new Menu(pizzas, toppings, drinks);
    }





}
