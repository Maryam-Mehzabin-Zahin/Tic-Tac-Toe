import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class TicTacToe {
    private static Move move;
    private static final HashMap<Integer, Character> board = new HashMap<Integer, Character>();

    public static void main(String[] args) {
        setMove(new Move());
        initiateBoard();
        createTurn();
    }

    private static void createTurn() {
        Scanner scanner = new Scanner(System.in);
        int random = new Random().nextInt(2);
        while(true) {
            if(random == 0) {
                System.out.println("\nComputer's turn");
                int input = move.createAIMove(checkBoard());
                board.put(input, 'O');
                System.out.println("Computer chose cell: " + (input + 1));
                checkResult(input, 'O');
                checkBoard();
            }else {
                while(true) {
                    System.out.println("\nYour turn. Choose an empty cell from 1-9");
                    int input = scanner.nextInt();
                    if(board.get(input-1) == ' ') {
                        board.put(input-1, 'X');
                        checkResult(input-1, 'X');
                        checkBoard();
                        break;
                    }
                }
            }
            printBoard();
            random = (random + 1) % 2;
        }
    }

    private static void initiateBoard() {
        System.out.println("\nTic Tac Toe Board");
        int cell = 0;
        for(int i = 0; i < 3; i++ ) {
            for(int j = 0; j < 3; j++) {
                board.put(cell, ' ');
                System.out.print(cell + 1);
                if (j < 2) System.out.print(" |");
                cell++;
            }
            if(cell > 8) break;
            System.out.println();
            System.out.println("--+--+--");
        }
    }
    private static void printBoard() {
        System.out.println("\nTic Tac Toe Board");
        for (int i = 0; i < board.size(); i++) {
            if(i % 3 == 0 && i > 0 ) {
                System.out.println("\n--+--+--");
            }
            if(board.get(i) == ' ') {
                System.out.print(i+1);
            } else {
                System.out.println(board.get(i));
            }
            if(i % 3 != 2) {
                System.out.print(" |");
            }
        }
    }

    private static Set<Integer> checkBoard(){
        Set<Integer> freeCells = new HashSet<>();
        for(int i = 0; i < board.size(); i++) {
            if(board.get(i) == ' ') {
                freeCells.add(i);
            }
        }
        if(freeCells.isEmpty()) {
            System.out.println("Game Tied");
            System.exit(0);
        }
        return freeCells;
    }

    private static void checkResult(int position, char ch) {
        checkRowWise(position, ch);
        checkColumnWise(position, ch);
        checkDiagonal(position, ch);
    }

    private static void checkDiagonal(int position, char ch) {
        if(position %  4 == 0) {
            checkFirstDiagonal(ch);
        }
        if(position % 2 == 0) {
            checkSecondDiagonal(ch);
        }
    }

    private static void checkSecondDiagonal(char ch) {
        for(int i = 0; i < 9; ) {
            if(board.get(i) != ch) return;
            i+=2;
        }
        selectWinner(ch);
        System.exit(0);
    }

    private static void checkFirstDiagonal(char ch) {
        for(int i = 0; i < 9; ) {
            if(board.get(i) != ch) return;
            i+=4;
        }
        selectWinner(ch);
        System.exit(0);
    }

    private static void checkColumnWise(int position, char ch) {
        if(position % 3 == 0) {
            checkFirstColumn(ch);
        }
        if(position % 3 == 1) {
            checkSecondColumn(ch);
        }
        if(position % 3 == 2) {
            checkThirdColumn(ch);
        }

    }

    private static void checkThirdColumn(char ch) {
        for(int i = 2 ; i < 9; ) {
            if(board.get(i) != ch) return;
            i+=3;
        }
        selectWinner(ch);
        System.exit(0);
    }

    private static void checkSecondColumn(char ch) {
        for(int i = 1 ; i < 8; ) {
            if(board.get(i) != ch) return;
            i+=3;
        }
        selectWinner(ch);
        System.exit(0);
    }

    private static void checkFirstColumn(char ch) {
        for(int i = 0 ; i < 8; ) {
            if(board.get(i) != ch) return;
            i+=3;
        }
        selectWinner(ch);
        System.exit(0);
    }

    private static void checkRowWise(int position, char ch) {
        if(position < 3) {
            checkFirstRow(ch);
        } else if (position > 3 && position < 6) {
            checkSecondRow(ch);
        }else {
            checkThirdRow(ch);
        }
    }

    private static void checkThirdRow(char ch) {
        for(int i = 6; i < 9; i++) {
            if(board.get(i) != ch) return;
        }
        selectWinner(ch);
        System.exit(0);
    }

    private static void checkSecondRow(char ch) {
        for(int i = 3; i < 6; i++) {
            if(board.get(i) != ch) return;
        }
        selectWinner(ch);
        System.exit(0);
    }

    private static void checkFirstRow(char ch) {
        for(int i = 0; i < 3; i++) {
            if(board.get(i) != ch) return;
        }
        selectWinner(ch);
        System.exit(0);
    }

    private static void selectWinner(final char ch) {
        if(ch == 'X'){
            System.out.println("Game over. You won.");
        }
        if(ch == 'O') {
            System.out.println("Game over. Computer won.");
        }
    }

    public static void setMove(final Move move) {
        TicTacToe.move = move;
    }
}
