public class AIPlayerFactory implements PlayerFactory{

    public Player createPlayer(String name, char symbol) {
        return new AIPlayer(name, symbol);
    }
}
