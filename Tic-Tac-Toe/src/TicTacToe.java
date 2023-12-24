import java.util.HashMap;


public class TicTacToe {
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';
    private static final HashMap<Integer, Character> board = new HashMap<Integer, Character>();

    public static void main(String[] args) {
        initiateBoard();
        printBoard();
    }

    private static void initiateBoard() {
        int cell = 0;
        for(int i = 0; i < 3; i++ ) {
            for(int j = 0; j < 3; j++) {
                board.put(cell, ' ');
                System.out.print("?");
                if(j<2) System.out.print(" |");
                cell++;
            }
            if(cell > 8 ) break;
            System.out.println();
            System.out.println("--+--+--");
        }
    }
    private static void printBoard() {
        
    }

}
