package Controller;

import Model.*;
import service.WinningStrategy.WinningStrategy;
import service.WinningStrategy.WinningStrategyFactory;
import service.WinningStrategy.WinningStrategyName;

import java.util.List;


public class GameController {
    private Game game;
    public Game createGame(int dimension, List<Player> playerList){
        return Game.builder()
                .setPlayerList(playerList)
                .setDimension(dimension)
                .setWinningStrategy(WinningStrategyFactory.getConstructor(WinningStrategyName.OrderOneWinningStrategy, dimension))
                .build();
    }

    public void displayGame(Game game){
        game.getCurrentBoard().display();
    }

    public GameStatus getGameStatus(Game game){
        return game.getGameStatus();
    }

    public Player checkWinner(Game game, Move lastMovePlayed){
        return game.getWinningStrategy().winningStrategy(lastMovePlayed);
    }

    public Move executeMove(Game game, Player player){
        return player.makeMove(game.getCurrentBoard());
    }

    public Board Undo(Game game){
        return game.undoStep();
    }
    public void replayGame(Game game){
        game.replayGame();
    }

}
