import java.util.HashMap;
import java.util.Scanner;

public class HumanPlayer extends Player{

    public HumanPlayer(final String name, final char symbol) {
        super(name, symbol);
    }
    private GameLogic gameLogic;

    @Override
    public void move(HashMap<Integer, Character> board) {
        while(true) {
            System.out.println("\nYour turn. Choose an empty cell from 1-9\n");
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            if(board.get(input-1) == ' ') {
                board.put(input-1, 'X');
                gameLogic.checkResult(board, input-1, 'X');
                break;
            }
        }
    }
}
