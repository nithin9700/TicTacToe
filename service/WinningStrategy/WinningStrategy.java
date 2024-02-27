package service.WinningStrategy;

import Model.Move;
import Model.Player;

public interface WinningStrategy{
    Player winningStrategy(Move lastMove);
    void removeSymbolUndoStep(int i, int j, char symbol);

}
