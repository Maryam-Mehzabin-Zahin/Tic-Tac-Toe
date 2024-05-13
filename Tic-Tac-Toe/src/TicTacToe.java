import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class TicTacToe {
    public static HashMap<Integer, Character> board = GameManager.getInstance().getBoard();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        PlayerFactory humanPlayerFactory = new HumanPlayerFactory();
        PlayerFactory aiPlayerFactory = new AIPlayerFactory();

        Player humanPlayer = humanPlayerFactory.createPlayer(userName, 'X');
        Player opponent = aiPlayerFactory.createPlayer("AI Player 1", 'O');


        Player[] players = {humanPlayer, opponent};
        GameManager.getInstance().getPlayers()[0] = humanPlayer;
        GameManager.getInstance().getPlayers()[1] = opponent;


        int currentPlayerIndex = GameManager.getInstance().getCurrentPlayerIndex();

        while (!isGameEnded(board)) {
            Player currentPlayer = players[currentPlayerIndex];
            int move = currentPlayer.move();
            if (isValidMove(move, board)) {
                board.put(move, currentPlayer.getSymbol());
                currentPlayerIndex = (currentPlayerIndex + 1) % 2;
                GameManager.getInstance().setCurrentPlayerIndex(currentPlayerIndex);
                displayBoard(board);
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
        return;
    }


    private static boolean isGameEnded(HashMap<Integer, Character> board) {
        Set<Integer> freeCells = getFreeCells(board);
        if(freeCells.isEmpty()) {
            System.out.println("Game Tied");
            System.exit(0);
        }
        return false;
    }

    private static Set<Integer> getFreeCells(final HashMap<Integer, Character> board) {
        Set<Integer> freeCells = new HashSet<>();
        for(int i = 0; i < board.size(); i++) {
            if(board.get(i) == ' ') {
                freeCells.add(i);
            }
        }
        return freeCells;
    }

    private static boolean isValidMove(int move, HashMap<Integer, Character> board) {
        Set<Integer> freeCells = getFreeCells(board);
        return freeCells.contains(move);
    }

    private static void displayBoard(HashMap<Integer, Character> board) {
    }
}