package services.BotStrategy;

import enums.CellType;
import exceptions.GameOverException;
import models.*;

import java.util.List;

public class RandomBotPlayingStrategy implements BotPlayingStrategy{
    public Move makeMove(Board board, Player bot) {
        List<List<Cell>> matrix = board.getMatrix();
        for(int i=0;i<matrix.size();i++){
            for(int j=0;j<matrix.size();j++){
                if(matrix.get(i).get(j).getCellType().equals(CellType.EMPTY)){
                    board.getMatrix().get(i).get(j).setPlayer(bot);
                    board.getMatrix().get(i).get(j).setCellType(CellType.FILLED);
                    return new Move(board.getMatrix().get(i).get(j), bot);
                }
            }
        }
        throw new GameOverException("There are no empty cells in the board");
    }
}
