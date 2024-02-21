package Model;

import java.util.PrimitiveIterator;

public class Cell {
    private int i;
    private int j;
    private CELLTYPE cellType;
    private Player player;

    public Cell(int i, int j){
        this.i = i;
        this.j = j;
        this.cellType = CELLTYPE.EMPTY;
        this.player = null;
    }
    public void displayCell(){
        if(player == null){
            System.out.print("| |");
        }
        else {
            System.out.print("|" + player.getSymbol()+"|");
        }
    }



    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public CELLTYPE getCellType() {
        return cellType;
    }

    public void setCellType(CELLTYPE cellType) {
        this.cellType = cellType;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
