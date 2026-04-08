package config;

import entities.Table;
import entities.TableStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfig {

    @Bean(name="table1")
    public Table table1(){
        return new Table(1, 4, TableStatus.FREE);
    }
    @Bean(name="table2")
    public Table table2(){
        return new Table(2, 6, TableStatus.FREE);
    }
    @Bean(name="table3")
    public Table table3(){
        return new Table(3, 2, TableStatus.FREE);
    }

    @Bean(name="table4")
        public Table table4(){
            return new Table(4, 4, TableStatus.FREE);
    }


}
