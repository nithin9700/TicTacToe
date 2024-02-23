package service;

import Model.Board;
import Model.Bot;
import Model.Move;
import Model.Player;

public interface BotDifficultLevelStrategy {
    Move makeMove(Board board, Player player);
}
