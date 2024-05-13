import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class GameManager {
    private static GameManager instance;
    private final Map<Integer, Character> board;
    private final Player[] players;
    private final Random random;
    private final Scanner scanner;
    private int currentPlayerIndex;

    private GameManager() {
        board = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            board.put(i, ' ');
        }
        players = new Player[2];
        random = new Random();
        scanner = new Scanner(System.in);
        currentPlayerIndex = 0;
    }
        public static GameManager getInstance() {
            if (instance == null) {
                instance = new GameManager();
            }
            return instance;
    }

    public HashMap<Integer, Character> getBoard() {
        return (HashMap<Integer, Character>) board;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Random getRandom() {
        return random;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

}
