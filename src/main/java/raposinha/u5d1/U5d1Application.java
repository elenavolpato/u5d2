package raposinha.u5d1;

import config.MenuConfig;
import entities.Menu;
import entities.Pizza;
import entities.Topping;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(MenuConfig.class)
public class U5d1Application {

	public static void main(String[] args) {
		var ctx = SpringApplication.run(U5d1Application.class, args);
		Menu menu = ctx.getBean(Menu.class);
		menu.print();
		Pizza myPizza = ctx.getBean("margheritaPizza", Pizza.class);
		myPizza.addTopping(ctx.getBean("onions", Topping.class));
		System.out.println("myPizza " + myPizza);
		ctx.close();
	}
}
