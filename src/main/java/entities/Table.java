package entities;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Table {
    private int tableNum;
    private int maxSeats;
    private TableStatus status;
}
