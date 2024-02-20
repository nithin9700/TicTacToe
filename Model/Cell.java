package Model;

public class Cell {
    int i;
    int j;
    CellType cellType;
    Player player;

    public Cell(int i, int j){
        this.i = i;
        this.j = j;
        this.cellType = CellType.EMPTY;
    }


}
