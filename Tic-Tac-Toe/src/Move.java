import java.util.Random;
import java.util.Set;

public class Move extends TicTacToe{
    protected int createAIMove(Set<Integer> freeCells) {
        return new Random().nextInt(freeCells.size());
    }
}
