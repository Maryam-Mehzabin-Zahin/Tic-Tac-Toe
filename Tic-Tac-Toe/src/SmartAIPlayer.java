import logic.GameLogic;
import logic.GameLogicImpl;

import java.util.HashMap;

public class SmartAIPlayer implements Player {

    private final String name;
    private final char symbol;
    private final HashMap<Integer, Character> board;
    private final GameLogic gameLogic;


    public SmartAIPlayer(final String name, final char symbol) {
        this.name = name;
        this.symbol = symbol;
        this.board = GameManager.getInstance().getBoard();
        gameLogic = new GameLogicImpl();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public char getSymbol() {
        return this.symbol;
    }

    @Override
    public int move() {
        return findBestMove();
    }
    private int findBestMove() {
        int bestVal = -1000;
        int bestMove = -1;

        // Traverse all cells
        for (int i = 0; i < 9; i++) {
            // Check if cell is empty
            if (board.get(i) == ' ') {
                // Make the move
                board.put(i, symbol);

                // Compute the evaluation function for this move
                int moveVal = minimax(0, false, i);

                // Undo the move
                board.put(i, ' ');

                // If the value of the current move is more than the best value, update best
                if (moveVal > bestVal) {
                    bestMove = i;
                    bestVal = moveVal;
                }
            }
        }

        return bestMove;
    }

    private boolean isMovesLeft() {
        return !gameLogic.getFreeCells(board).isEmpty();
    }

    // Minimax algorithm implementation
    private int minimax(int depth, boolean isMax, int move) {
        int score = evaluate(move);

        // If Maximizer has won
        if (score == 10) return score;

        // If Minimizer has won
        if (score == -10) return score;

        if (!isMovesLeft()) return 0;

        //If isMax is true, it tries to maximize the score (AI's move).
        //If isMax is false, it tries to minimize the score (opponent's move).
        if (isMax) {
            int best = -1000;
            for (int i = 0; i < 9; i++) {
                if (board.get(i) == ' ') {
                    board.put(i, symbol);
                    best = Math.max(best, minimax(depth + 1, false, i));
                    board.put(i, ' ');
                }
            }
            return best;
        }
        else {
            int best = 1000;
            for (int i = 0; i < 9; i++) {
                if (board.get(i) == ' ') {
                    board.put(i, 'X');
                    best = Math.min(best, minimax(depth + 1, true, i));
                    board.put(i, ' ');
                }
            }
            return best;
        }
    }

    private int evaluate(int move) {

            if (gameLogic.checkResult(board, move, symbol)) {
                return +10;
            }
            if (gameLogic.checkResult(board, move, 'X')) {
                return -10;
            }
            return 0;
    }

}