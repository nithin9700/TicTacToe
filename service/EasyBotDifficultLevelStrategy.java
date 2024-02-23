package service;

import Model.*;
import Exception.NoMoveForBot;
import java.util.List;

public class EasyBotDifficultLevelStrategy implements BotDifficultLevelStrategy{
    @Override
    public Move makeMove(Board board, Player bot) {
            List<List<Cell>> matrix = board.getMatrix();
            for(int i = 1;i <= matrix.size();i++){
                for(int j = 1;j <= matrix.size();j++){
                    if(matrix.get(i - 1).get(j - 1).getCellType().equals(CellType.EMPTY)){
                        board.getMatrix().get(i -1).get(j -1).setPlayer(bot);
                        board.getMatrix().get(i - 1).get(j - 1).setCellType(CellType.FILLED);
                        return new Move(board.getMatrix().get(i - 1).get(j - 1), bot);
                    }
                }
            }
            throw new NoMoveForBot("There are no empty cells in the board");
    }
}
