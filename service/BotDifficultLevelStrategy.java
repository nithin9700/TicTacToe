package service;

import Model.Board;
import Model.Move;

public interface BotDifficultLevelStrategy {
    Move selectMove(Board board);
}
