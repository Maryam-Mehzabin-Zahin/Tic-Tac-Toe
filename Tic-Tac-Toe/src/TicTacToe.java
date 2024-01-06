import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        System.out.println("Choose your opponent:");
        System.out.println("1. AI Player 1");
        System.out.println("2. AI Player 2");
        int opponentChoice = scanner.nextInt();

        Player humanPlayer = PlayerFactory.createHumanPlayer(userName, 'X');


    }
}