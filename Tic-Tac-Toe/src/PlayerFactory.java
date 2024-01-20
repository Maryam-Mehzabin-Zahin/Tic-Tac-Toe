public class PlayerFactory {
    public static Player createHumanPlayer(String name, char symbol) {
        return new HumanPlayer(name, symbol);
    }
}
