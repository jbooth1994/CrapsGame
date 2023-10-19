import java.util.Random;
import java.util.Scanner;

public class CrapsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        while (playAgain) {
            int point = 0;
            boolean gameWon = false;

            System.out.println("Welcome to the game of Craps!");

            // Initial roll
            int roll = rollDice(random);
            System.out.println("Initial roll: " + roll);

            if (roll == 2 || roll == 3 || roll == 12) {
                System.out.println("Craps! You lose.");
            } else if (roll == 7 || roll == 11) {
                System.out.println("Natural! You win.");
                gameWon = true;
            } else {
                point = roll;
                System.out.println("Point is " + point);
            }

            // Subsequent rolls
            while (!gameWon) {
                System.out.println("Rolling again...");
                int newRoll = rollDice(random);
                System.out.println("New roll: " + newRoll);

                if (newRoll == point) {
                    System.out.println("Made point and won! Congratulations!");
                    gameWon = true;
                } else if (newRoll == 7) {
                    System.out.println("Got a seven and lost. Better luck next time!");
                    break;
                }
            }

            System.out.print("Play again? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("Thanks for playing Craps!");
    }

    private static int rollDice(Random random) {
        int die1 = random.nextInt(6) + 1;
        int die2 = random.nextInt(6) + 1;
        int sum = die1 + die2;
        System.out.println("Die 1: " + die1 + ", Die 2: " + die2 + ", Sum: " + sum);
        return sum;
    }
}
