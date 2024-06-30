package logic;

import java.util.HashMap;
import java.util.Map;

public class GameLogicImpl implements GameLogic{

    private Map<Integer, Character> board;

    @Override
    public Boolean checkResult(final HashMap<Integer, Character> board, final int position, final char symbol) {
        this.board = board;
        return checkDiagonal(position, symbol) || checkRowWise(position, symbol) || checkColumnWise(position, symbol);
    }

    private Boolean checkDiagonal(int position, char ch) {
        if(position % 2 == 0) {
            return checkFirstDiagonal(ch) || checkSecondDiagonal(ch);
        }
        return false;
    }

    private Boolean checkSecondDiagonal(char ch) {
        for(int i = 2; i < 7; ) {
            if(board.get(i) != ch){
                return false;
            }
            i+=2;
        }
        return true;
    }

    private boolean checkFirstDiagonal(char ch) {
        for(int i = 0; i < 9; ) {
            if(board.get(i) != ch) {
                return false;
            }
            i+=4;
        }
        return true;
    }

    private Boolean checkColumnWise(int position, char ch) {
        if(position % 3 == 0) {
            return checkFirstColumn(ch);
        }
        if(position % 3 == 1) {
            return checkSecondColumn(ch);
        }
        if(position % 3 == 2) {
            return checkThirdColumn(ch);
        }
        return false;
    }

    private Boolean checkThirdColumn(char ch) {
        for(int i = 2 ; i < 9; ) {
            if(board.get(i) != ch) {
                return false;
            }
            i+=3;
        }
       return true;
    }

    private boolean checkSecondColumn(char ch) {
        for(int i = 1 ; i < 8; ) {
            if(board.get(i) != ch) {
                return false;
            }
            i+=3;
        }
       return true;
    }

    private Boolean checkFirstColumn(char ch) {
        for(int i = 0 ; i < 8; ) {
            if(board.get(i) != ch) {
                return false;
            }
            i+=3;
        }
        return true;
    }

    private Boolean checkRowWise(int position, char ch) {
        if(position < 3) {
            return checkFirstRow(ch);
        } else if (position > 3 && position < 6) {
            return checkSecondRow(ch);
        } else {
            return checkThirdRow(ch);
        }
    }

    private Boolean checkThirdRow(char ch) {
        for(int i = 6; i < 9; i++) {
            if(board.get(i) != ch){
                return false;
            }
        }
        return true;
    }

    private Boolean checkSecondRow(char ch) {
        for(int i = 3; i < 6; i++) {
            if(board.get(i) != ch)
                return false;
        }
        return true;
    }

    private Boolean checkFirstRow(char ch) {
        for(int i = 0; i < 3; i++) {
            if(board.get(i) != ch) {
                System.out.println("i " + i);
                return false;
            }
        }
        return true;
    }



}
