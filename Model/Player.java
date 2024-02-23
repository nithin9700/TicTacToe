package Model;
import java.lang.String;
import java.util.Scanner;
import Exception.InvalidMoveException;

public class Player {
    private int id;
    private char symbol;
    private  String name;

    private PlayerType playertype;
    public Player(){}
    public Player(int id, String name, char symbol, PlayerType playertype) {
        this.playertype = playertype;
        this.id = id;
        this.name = name;
        this.symbol = symbol;
    }

    public Move makeMove(Board board){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the row:");
        int row = sc.nextInt() - 1;
        while (row >= board.getDimension()){
            System.out.println("The value is greater the board size, Please enter the lesser value");
            row = sc.nextInt() - 1;
        }
        System.out.println("Enter the Col:");
        int col = sc.nextInt() - 1;
        while (col >= board.getDimension()){
            System.out.println("The value is greater the board size, Please enter the lesser value");
            col = sc.nextInt() - 1;
        }
        if(board.getMatrix().get(row).get(col).getCellType().equals(CellType.FILLED)){
            throw  new InvalidMoveException("Invalid move");
        }

        if(row < 0 || row >= board.getDimension() || col < 0 || col >= board.getDimension()){
            throw new InvalidMoveException("You have move out of the board");
        }

        Cell playedMoveCell = board.getMatrix().get(row).get(col);
        playedMoveCell.setCellType(CellType.FILLED);
        playedMoveCell.setPlayer(this);
        return new Move(playedMoveCell, this);
    }

    public PlayerType getPlayertype() {
        return playertype;
    }

    public void setPlayerType(PlayerType playertype) {
        this.playertype = playertype;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}