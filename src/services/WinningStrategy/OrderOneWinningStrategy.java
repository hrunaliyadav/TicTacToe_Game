package services.WinningStrategy;

import models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneWinningStrategy implements WinningStrategy{
    private int dimension;
    private List<HashMap<Character, Integer>> rowHashMapList;
    private List<HashMap<Character, Integer>> colHashMapList;
    private HashMap<Character, Integer> leftDigonal;
    private HashMap<Character, Integer> rightDigonal;
    private HashMap<Character, Integer> cornerHashmap;

    public OrderOneWinningStrategy(int dimension) {
        this.dimension = dimension;
        this.rowHashMapList = new ArrayList<>();
        this.colHashMapList = new ArrayList<>();
        this.leftDigonal = new HashMap<>();
        this.rightDigonal = new HashMap<>();
        this.cornerHashmap = new HashMap<>();

        for(int i=0; i<dimension; i++){
            rowHashMapList.add(new HashMap<>());
            colHashMapList.add(new HashMap<>());
        }
    }

    @Override
    public Player checkWinner(Board board, Move lastmove) {
        Player player = lastmove.getPlayer();
        char symbol = player.getSymbol();
        int row = lastmove.getCell().getRow();
        int col = lastmove.getCell().getCol();

        boolean winner = (checkcorner(row,col) && winnerCheckForCorners(board.getMatrix(),symbol))
                || checkAndUpdateRowHashMap(row,symbol)
                || checkAndUpdateColHashmap(col,symbol)
                || (checkAndUpdateLeftDigonal(symbol) && checkleftdigonal(row,col))
                || (checkAndUpdateRightDigonal(symbol) && checkrightdigonal(row,col));
        if (winner){
            return player;
        }else
            return null;
    }

    private boolean checkleftdigonal(int row, int col){
        return row == col;
    }

    private boolean checkrightdigonal(int row, int col){
        return ((row+col) == (dimension-1));
    }

    private boolean checkcorner(int row, int col){
        return (
                (row==0 && col==0)
                        ||(row==0 && col==dimension-1)
                        ||(row==dimension-1 && col==0)
                        ||(row==dimension-1 && col==dimension-1)
        );
    }

    private boolean checkAndUpdateRowHashMap(int row, char symbol){
        HashMap<Character, Integer> rowHashmap = rowHashMapList.get(row);
        if(rowHashmap.containsKey(symbol)){
            rowHashmap.put(symbol,rowHashmap.get(symbol)+1);
            return rowHashmap.get(symbol)==dimension;
        }else{
            rowHashmap.put(symbol,1);
        }
        return false;
    }

    private boolean checkAndUpdateColHashmap(int col, char symbol){
        HashMap<Character,Integer> colhashmap = colHashMapList.get(col);
        if(colhashmap.containsKey(symbol)){
            colhashmap.put(symbol,colhashmap.get(symbol)+1);
            return colhashmap.get(symbol) == dimension;
        }else{
            colhashmap.put(symbol,1);
        }
        return false;
    }

    private boolean checkAndUpdateLeftDigonal(char symbol) {
        if (leftDigonal.containsKey(symbol)) {
            leftDigonal.put(symbol, leftDigonal.get(symbol) + 1);
            return leftDigonal.get(symbol) == dimension;
        } else {
            leftDigonal.put(symbol, 1);
        }
        return false;
    }

    private boolean checkAndUpdateRightDigonal(char symbol){
        if(rightDigonal.containsKey(symbol)){
            rightDigonal.put(symbol,rightDigonal.get(symbol)+1);
            return rightDigonal.get(symbol) == dimension;
        }else{
            rightDigonal.put(symbol,1);
        }
        return false;
    }

    private boolean winnerCheckForCorners(List<List<Cell>> matrix, char symbol){
        if (cornerHashmap.containsKey(symbol)) {
            cornerHashmap.put(symbol, cornerHashmap.get(symbol)+1);
            return cornerHashmap.get(symbol) == 4;
        }else{
            cornerHashmap.put(symbol,1);
        }
        return false;
    }
}
