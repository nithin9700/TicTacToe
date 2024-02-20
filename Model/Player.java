package Model;
import java.lang.String;

public class Player {
    private int id;
    private char symbol;
    private  String name;

    private PLAYERTYPE playertype;
    public Player(int id, String name, char symbol) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
    }

    public PLAYERTYPE getPlayertype() {
        return playertype;
    }

    public void setPlayertype(PLAYERTYPE playertype) {
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