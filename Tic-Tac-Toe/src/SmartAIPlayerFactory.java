public class SmartAIPlayerFactory implements PlayerFactory{
    @Override
    public Player createPlayer(String name, char symbol) {
        return new SmartAIPlayer(name, symbol);
    }
}
