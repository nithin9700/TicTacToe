package service.WinningStrategy;

import Model.Cell;
import Model.Move;
import Model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneWinningStrategy implements WinningStrategy{
    List<HashMap<Character,Integer>> rowList;
    List<HashMap<Character,Integer>> colList;
    HashMap<Character,Integer> leftDiagonal;
    HashMap<Character,Integer> rightDiagonal;
    HashMap<Character, Integer> allFourCorner;
    int dimension;

    public OrderOneWinningStrategy(int dimension) {
        this.dimension = dimension;
        this.rowList = new ArrayList<>();
        this.colList = new ArrayList<>();
        for (int i = 0; i < dimension; i++) {
            rowList.add(new HashMap<>());
            colList.add(new HashMap<>());
        }
        this.leftDiagonal = new HashMap<>();
        this.rightDiagonal = new HashMap<>();
        this.allFourCorner = new HashMap<>();
    }
    @Override
    public Player winningStrategy(Move lastMove){
        Cell cell = lastMove.getCell();
        boolean winner = allFourCorner(lastMove.getPlayer().getSymbol())||
                checkRowAndCol(rowList.get(cell.getI()), lastMove.getPlayer().getSymbol()) ||
                checkRowAndCol(colList.get(cell.getJ()), lastMove.getPlayer().getSymbol()) ||
                checkDiagonal(cell.getI(),  cell.getJ(), lastMove.getPlayer().getSymbol());
        return winner ? lastMove.getPlayer() : null;
    }
    private boolean checkDiagonal(int i, int j, char symbol){
        if(i == j && i + j != dimension - 1){
            rowAndColUpdateHashMap(leftDiagonal, symbol);
            return (leftDiagonal.size() == 1 && leftDiagonal.get(symbol) == dimension);
        }
        else if(i + j == dimension - 1 && i != j){
            rowAndColUpdateHashMap(rightDiagonal, symbol);
            return (rightDiagonal.size() == 1 && rightDiagonal.get(symbol) == dimension);
        }
        else if(i + j == dimension - 1 && i == j){
            rowAndColUpdateHashMap(rightDiagonal, symbol);
            rowAndColUpdateHashMap(leftDiagonal, symbol);
            return (rightDiagonal.size() == 1 && rightDiagonal.get(symbol) == dimension) ||
                    (leftDiagonal.size() == 1 && leftDiagonal.get(symbol) == dimension);
        }
        return false;
    }
    private boolean checkRowAndCol(HashMap<Character, Integer> map, char symbol){
        rowAndColUpdateHashMap(map, symbol);
        return (map.size() == 1 && map.get(symbol) == dimension);
    }
    private boolean allFourCorner(char symbol) {

        rowAndColUpdateHashMap(allFourCorner, symbol);
        return (allFourCorner.size() == 1 && allFourCorner.get(symbol) == 4);
    }


    private void rowAndColUpdateHashMap(HashMap<Character, Integer> map, char symbol){
        map.put(symbol, map.getOrDefault(symbol, 0) + 1);
    }

    public void removeSymbolUndoStep(int i, int j, char symbol){
        if(i < rowList.size()) removeSymbol(rowList.get(i), symbol);
        if(j < colList.size()) removeSymbol(colList.get(j), symbol);
        if(i == j && i + j != dimension -1){
            removeSymbol(leftDiagonal, symbol);
        }
        else if(i + j == dimension - 1 && i != j){
            removeSymbol(rightDiagonal, symbol);
        }
        else if(i + j == dimension - 1 && i == j){
            removeSymbol(leftDiagonal, symbol);
            removeSymbol(rightDiagonal, symbol);
        }

    }
    private void removeSymbol(HashMap<Character, Integer>map, char symbol){
        if(map.size() > 1){
            map.remove(symbol, map.get(symbol) - 1);
        }
    }
}