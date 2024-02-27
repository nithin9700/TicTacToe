package Model;
import java.util.*;
public class Board {
    private List<List<Cell>> matrix;
    private int dimension;
    private Board board;
    public Board (int dimension){
        this.dimension= dimension;
        matrix = new ArrayList<>();
        for (int i = 0; i < dimension; i++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j < dimension; j++) {
                matrix.get(i).add(new Cell(i, j));
            }
        }
    }



    public void  display(){
        for (int i = 0; i < dimension; i++) {
            List<Cell> cells = matrix.get(i);
            for (Cell cell : cells) {
                cell.displayCell();
            }
            System.out.println();
        }
    }

    public List<List<Cell>> getMatrix() {
        return matrix;
    }

    public void setMatrix(List<List<Cell>> matrix) {
        this.matrix = matrix;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Board clone(){
        Board board1 = new Board(this.dimension);
        List<List<Cell>> cells = this.getMatrix();
        List<List<Cell>> cloneCells = new ArrayList<>();

        for (int i =0; i <  cells.size();i++) {
            List<Cell> newCell = new ArrayList<>();

            for (int j = 0; j < cells.size();j++) {
                newCell.add(cells.get(i).get(j).clone());
            }
            cloneCells.add(newCell);
        }
        board1.setMatrix(cloneCells);
        return board1;
    }
}
