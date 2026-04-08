package entities;

import lombok.*;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


//
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private int orderNum;
    private OrderStatus status;
    private int seatsNum;
    private LocalTime orderTime;
    private List<MenuItem> orderItems = new ArrayList<>();
    private Table table;
    private double coverCharge;


    public Order(int orderNum, Table table, int seatsNum, double coverCharge){
        // check if table is adequate for the number of guests
        if(seatsNum > table.getMaxSeats()){
            throw new IllegalArgumentException("Cannot place " + seatsNum + "people at this table meant for " + table.getMaxSeats());
        }
        this.orderNum = orderNum;
        this.table = table;
        this.seatsNum = seatsNum;
        this.coverCharge = coverCharge;
        this.status = OrderStatus.IN_PROGRESS;
        this.orderTime = LocalTime.now();
        this.table.setStatus(TableStatus.OCCUPIED); //switch its state to OCCUPIED
    }


    public double getTotalPrice(){
        double itemsTotal = orderItems.stream().mapToDouble(MenuItem::getPrice).sum();
        return itemsTotal + (coverCharge * seatsNum);
    }
    public void printOrder() {
        System.out.println("ORDINE N: " + orderNum);
        System.out.println("Tavolo: " + table.getTableNum());
        System.out.println("Stato: " + status);
        System.out.println("Coperti: " + seatsNum);
        System.out.println("Ora: " + orderTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        System.out.println("Elementi:");
        orderItems.forEach(item ->
                System.out.format("- %s (%.2f€)%n", item.getName(), item.getPrice())
        );
        System.out.format("TOTALE: %.2f€%n", getTotalPrice());
        System.out.println("\n");
    }



    //Validation: Before creating an order, you'll eventually need to check if the numeroCoperti (number of guests) for the order is less than or equal to the table's numeroCopertiMassimo.
}
