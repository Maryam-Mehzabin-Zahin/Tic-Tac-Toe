import java.util.Scanner;

public class SmartAIPlayer implements Player {

    private final String name;
    private final char symbol;
    private final Scanner scanner;

    public SmartAIPlayer(final String name, final char symbol) {
        this.name = name;
        this.symbol = symbol;
        this.scanner = GameManager.getInstance().getScanner();
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
        return 0;
    }

}