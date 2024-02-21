package Model;
import java.lang.String;
import java.util.Scanner;
import Exception.InvalidMoveException;

public class Player {
    private int id;
    private char symbol;
    private  String name;

    private PLAYERTYPE playertype;
    public Player(){}
    public Player(int id, String name, char symbol, PLAYERTYPE playertype) {
        this.playertype = playertype;
        this.id = id;
        this.name = name;
        this.symbol = symbol;
    }

    public Move makeMove(Board board){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the row:");
        int row = sc.nextInt();
        System.out.println("Enter the Col");
        int col = sc.nextInt();

        if(board.getMatrix().get(row).get(col).equals(CELLTYPE.FILLED)){
            throw new InvalidMoveException("you cannot place you symbol which is filled by other player");
        }

        if(row < 0 && row >= board.getDimension() || col < 0 && col >= board.getDimension()){
            throw new InvalidMoveException("You have move out of the board");
        }

        Cell playedMoveCell = board.getMatrix().get(row).get(col);
        playedMoveCell.setCellType(CELLTYPE.FILLED);
        playedMoveCell.setPlayer(this);
        return new Move(playedMoveCell, this);
    }

    public PLAYERTYPE getPlayertype() {
        return playertype;
    }

    public void setPlayerType(PLAYERTYPE playertype) {
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