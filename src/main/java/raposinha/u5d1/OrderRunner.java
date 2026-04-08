package raposinha.u5d1;

import entities.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@Component
@Slf4j
public class OrderRunner implements CommandLineRunner {

    private final ApplicationContext ctx;
    @Value("${cover.cost}")
    private double coverCharge;

    public OrderRunner(ApplicationContext ctx){
        this.ctx = ctx;
    }
    @Override
    public void run(String... args) throws Exception {
        log.info(" **** PIZZERIA ORDER START ****");
        Table t1 = ctx.getBean("table1", Table.class);
        Table t2 = ctx.getBean("table2", Table.class);
        Table t3 = ctx.getBean("table3", Table.class);
        Table t4 = ctx.getBean("table4", Table.class);

        // print menu
        Menu menu = ctx.getBean(Menu.class);
        menu.print();

        // create order
        Order o1 = new Order(101, t1, 3, coverCharge);
        Order o2 = new Order(102, t2, 5, coverCharge);
        Order o3 = new Order(103, t3, 2, coverCharge);
        Order o4 = new Order(104, t4, 4, coverCharge);

        // ordered items
        Pizza pizza = ctx.getBean("margheritaPizza", Pizza.class);
        Drink lemonade = ctx.getBean("lemonade", Drink.class);

        o1.getOrderItems().add(pizza);
        o1.getOrderItems().add(lemonade);

        o2.getOrderItems().addAll(List.of(
                ctx.getBean("margheritaPizza", Pizza.class),
                ctx.getBean("salamiPizza", Pizza.class),
                ctx.getBean("hawaiianPizza", Pizza.class),
                ctx.getBean("customPizzaDoubleHam", Pizza.class),
                ctx.getBean("margheritaPizza", Pizza.class), // 5th pizza
                ctx.getBean("wine", Drink.class),
                ctx.getBean("wine", Drink.class),
                ctx.getBean("wine", Drink.class),
                ctx.getBean("water", Drink.class),
                ctx.getBean("water", Drink.class)

        ));

        o3.getOrderItems().addAll(List.of(
                ctx.getBean("margheritaPizza", Pizza.class),
                ctx.getBean("salamiPizza", Pizza.class),
                ctx.getBean("lemonade", Drink.class),
                ctx.getBean("wine", Drink.class)
        ));

        o4.getOrderItems().addAll(List.of(
                ctx.getBean("hawaiianPizza", Pizza.class),
                ctx.getBean("onions", Topping.class),
                ctx.getBean("margheritaPizza", Pizza.class),
                ctx.getBean("salamiPizza", Pizza.class),
                ctx.getBean("margheritaPizza", Pizza.class),
                ctx.getBean("wine", Drink.class),
                ctx.getBean("wine", Drink.class),
                ctx.getBean("water", Drink.class)
        ));



        System.out.println("\nORDER SUMMARY:");
        o1.printOrder();
        o2.printOrder();
        o3.printOrder();
        o4.printOrder();


    }
}
