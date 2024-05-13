
public class AIPlayer implements Player{
    private final String name;
    private final char symbol;
    private final MoveStrategy moveStrategy;

    public AIPlayer(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
        this.moveStrategy = new RandomMoveStrategy(GameManager.getInstance().getRandom());
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public int move() {
        return moveStrategy.makeMove();
    }
}
