public class HumanPlayerFactory implements PlayerFactory{

    public Player createPlayer(String name, char symbol) {
        return new HumanPlayer(name, symbol);
    }
}
