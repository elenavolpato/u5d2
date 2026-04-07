package entities;

import lombok.*;

@Getter
@Setter
@ToString(callSuper = true)

public class Topping extends MenuItem {
    public Topping(String name, Integer calories, double price) {
        super(name, calories, price);
    }

}
