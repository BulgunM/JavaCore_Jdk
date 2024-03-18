package jdk.homework6;

import org.apache.commons.math3.random.RandomDataGenerator;

import java.util.ArrayList;
import java.util.List;

public class MontyHallParadox {
    public static void main(String[] args) {
        List<Game> games = new ArrayList<>();
        RandomDataGenerator randomDataGenerator = new RandomDataGenerator();

        for (int i = 0; i < 1000; i++) {
            int prizeDoor = randomDataGenerator.nextInt(0, 3);
            int initialChoice = randomDataGenerator.nextInt(0, 3);
            int remainingDoor = 3 - prizeDoor - initialChoice;

            int finalChoice = remainingDoor;
            boolean won = finalChoice == prizeDoor;

            games.add(new Game(prizeDoor, initialChoice, finalChoice, won));
        }

        long wins = games.stream().filter(Game::isWon).count();
        long losses = games.size() - wins;

        System.out.println("Победы: " + wins);
        System.out.println("Поражения: " + losses);
    }
}
