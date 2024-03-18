package jdk.homework6;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class Game {
    private int prizeDoor;
    private int initialChoice;
    private int finalChoice;
    private boolean won;
}
