import java.util.HashMap;

abstract class Player {
    private final String name;
    private final char symbol;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }
    public char getSymbol() {
        return symbol;
    }

    public abstract void move(HashMap<Integer, Character> board);
}
