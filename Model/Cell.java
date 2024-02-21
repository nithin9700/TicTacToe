package Model;

public class Cell {
    private int i;
    private int j;
    private CellType cellType;
    private Player player;

    public Cell(int i, int j){
        this.i = i;
        this.j = j;
        this.cellType = CellType.EMPTY;
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

    public CellType getCellType() {
        return cellType;
    }

    public void setCellType(CellType cellType) {
        this.cellType = cellType;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
