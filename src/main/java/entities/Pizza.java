package entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString(callSuper = true)
public class Pizza extends MenuItem {
    private List<Topping> toppingList = new ArrayList<>();
    private boolean isXL = false;

    public Pizza(String name) {
        this.setName(name);
    }

    public void addTopping(Topping topping) {
        this.toppingList.add(topping);
    }


    @Override
    public double getPrice() {
        //all'inizio solo prezzo impasto
        double total = 4.3;
        for (Topping t : toppingList){
            total+= t.getPrice();
        }
        return isXL ? total + 2 : total;
    }

    @Override
    public int getCalories() {
        int totalCalories = 700; // calorie dello impasto
        for(Topping t: toppingList){
            totalCalories += t.getCalories();
        }
        return isXL ? (int)(totalCalories *1.5) : totalCalories;
    }
}
