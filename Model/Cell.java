package Model;

public class Cell {
    private int i;
    private int j;
    private CellType cellType;
    private Player player;

    public Cell(Cell cell){
        this.i = cell.i;
        this.j = cell.j;
        this.cellType = cell.cellType;
        this.player = cell.player;
    }


    public Cell(int i, int j){
        this.i = i;
        this.j = j;
        this.cellType = CellType.EMPTY;
        this.player = null;
    }
    public void undoCell(){
        setCellType(CellType.EMPTY);
        setPlayer(null);
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

    public Cell clone(){
        Cell cell1 = new Cell(i, j);
        cell1.setCellType(this.cellType);
        cell1.setPlayer(this.player);
        return cell1;
    }
}
