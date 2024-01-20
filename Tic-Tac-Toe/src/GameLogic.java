import java.util.HashMap;

public class GameLogic {

    private  HashMap<Integer, Character> board;

    public void checkResult(HashMap<Integer, Character> board, final int position, final char ch) {
        this.board = board;
        checkRowWise(position, ch);

    }

    private void checkRowWise(int position, char ch) {
        if(position < 3) {
            checkFirstRow(ch);
        } else if (position > 3 && position < 6) {
            checkSecondRow(ch);
        }else {
            checkThirdRow(ch);
        }
    }

    private void checkFirstRow(char ch) {
        for(int i = 0; i < 3; i++) {
            if(board.get(i) != ch) return;
        }
        selectWinner(ch);
        System.exit(0);
    }

    private void checkSecondRow(char ch) {
        for(int i = 3; i < 6; i++) {
            if(board.get(i) != ch) return;
        }
        selectWinner(ch);
        System.exit(0);
    }

    private void checkThirdRow(char ch) {
        for(int i = 6; i < 9; i++) {
            if(board.get(i) != ch) return;
        }
        selectWinner(ch);
        System.exit(0);
    }

    private static void selectWinner(final char ch) {
        if(ch == 'X'){
            System.out.println("\nGame over. You won.");
        }
        if(ch == 'O') {
            System.out.println("\nGame over. Computer won.");
        }
    }
}
