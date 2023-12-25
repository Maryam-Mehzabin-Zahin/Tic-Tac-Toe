import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Move extends TicTacToe{
    protected int createAIMove(Set<Integer> freeCells) {
        List<Integer> shuffledList = new ArrayList<>(freeCells);
        Collections.shuffle(shuffledList);
        return shuffledList.get(0);
    }
}
