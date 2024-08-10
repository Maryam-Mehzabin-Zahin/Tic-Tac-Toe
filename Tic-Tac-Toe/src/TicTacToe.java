import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import logic.GameLogic;
import logic.GameLogicImpl;

public class TicTacToe {
    private final HashMap<Integer, Character> board;
    private final GameLogic gameLogic;

    public TicTacToe() {
        board = GameManager.getInstance().getBoard();
        gameLogic = new GameLogicImpl();
    }

    public static void main(String[] args) {

        TicTacToe game = new TicTacToe();
        game.startGame();

    }

    private void startGame() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        PlayerFactory humanPlayerFactory = new HumanPlayerFactory();

        System.out.println("Choose AI Player: ");
        System.out.println("1. Regular AI");
        System.out.println("2. Smart AI (Minimax)");
        int choice = scanner.nextInt();

        PlayerFactory aiPlayerFactory;

        if (choice == 2) {
            aiPlayerFactory = new SmartAIPlayerFactory();
        } else {
            aiPlayerFactory = new AIPlayerFactory();
        }

        Player humanPlayer = humanPlayerFactory.createPlayer(userName, 'X');
        Player opponent = aiPlayerFactory.createPlayer("AI Player", 'O');


        Player[] players = {humanPlayer, opponent};
        GameManager.getInstance().getPlayers()[0] = humanPlayer;
        GameManager.getInstance().getPlayers()[1] = opponent;


        int currentPlayerIndex = GameManager.getInstance().getCurrentPlayerIndex();

        while (!isGameEnded(board)) {
            Player currentPlayer = players[currentPlayerIndex];
            int move = currentPlayer.move();
            char symbol = currentPlayer.getSymbol();
            String name = currentPlayer.getName();

            if (isValidMove(move, board)) {
                board.put(move, currentPlayer.getSymbol());
                currentPlayerIndex = (currentPlayerIndex + 1) % 2;
                GameManager.getInstance().setCurrentPlayerIndex(currentPlayerIndex);
                System.out.println("\nCell chosen: " + move);
                displayBoard(board);
                if (checkWinner(move, symbol, name)) return;
                if (isGameEnded(board)) return;
            } else {
                System.out.println("\nInvalid move. Try again.");
            }
        }
    }

    private boolean checkWinner(final int move, final char symbol, final String name) {
        final Boolean winner = gameLogic.checkResult(board, move, symbol);
        if (winner) {
            System.out.println("\nGame over. " + name + " won");
            return true;
        }
        return false;
    }

    private static boolean isGameEnded(HashMap<Integer, Character> board) {
        Set<Integer> freeCells = getFreeCells(board);
        if(freeCells.isEmpty()) {
            System.out.println("\nGame Tied");
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
        System.out.println("\nTic Tac Toe Board");
        for (int i = 0; i < board.size(); i++) {
            if(i % 3 == 0 && i > 0 ) {
                System.out.println("\n--+--+--");
            }
            if(board.get(i) == ' ') {
                System.out.print(i);
            } else {
                System.out.print(board.get(i));
            }
            if(i % 3 != 2) {
                System.out.print(" |");
            }
        }
    }
}