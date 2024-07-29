import java.util.HashMap;

public class SmartAIPlayer implements Player {

    private final String name;
    private final char symbol;
    private final HashMap<Integer, Character> board;

    public SmartAIPlayer(final String name, final char symbol) {
        this.name = name;
        this.symbol = symbol;
        this.board = GameManager.getInstance().getBoard();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public char getSymbol() {
        return this.symbol;
    }

    @Override
    public int move() {
        return 8;
    }

}