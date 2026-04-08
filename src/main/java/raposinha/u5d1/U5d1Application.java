package raposinha.u5d1;

import config.MenuConfig;
import config.OrderConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({MenuConfig.class, OrderConfig.class})
public class U5d1Application {

	public static void main(String[] args) {
		SpringApplication.run(U5d1Application.class, args);

	}
}
