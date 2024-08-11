import java.util.Scanner;

public class HumanPlayer implements Player{

    private final String name;
    private final char symbol;
    private final Scanner scanner;

    public HumanPlayer(final String name, final char symbol) {
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

    public int move() {
        System.out.println("\nIt's your turn, " + name + ". Choose a position (0-8):");
        return scanner.nextInt();
    }
}
