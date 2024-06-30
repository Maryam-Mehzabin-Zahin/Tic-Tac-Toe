package logic;

import java.util.HashMap;

public interface GameLogic {
    Boolean checkResult(final HashMap<Integer, Character> board, int position, char symbol);
}
