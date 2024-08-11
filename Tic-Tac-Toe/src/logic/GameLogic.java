package logic;

import java.util.HashMap;
import java.util.Set;

public interface GameLogic {
    Set<Integer> getFreeCells(final HashMap<Integer, Character> board);
    Boolean checkResult(final HashMap<Integer, Character> board, int position, char symbol);
}
