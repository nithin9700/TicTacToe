package Controller;

import Model.*;
import service.WinningStrategy;

import java.util.List;


public class GameController {
    private Game game;
    public Game createGame(int dimension, List<Player> playerList, WinningStrategy winningStrategy){
        return Game.builder().setPlayerList(playerList).setDimension(dimension).build();
    }

    public void displayGame(Game game){
        game.getCurrentBoard().display();
    }

    public Player getWinner(Game game){
        return null;
    }

    public GameStatus getGameStatus(Game game){
        return game.getGameStatus();
    }

    public Player checkWinner(Game game, Move lastMovePlayed){
        return null;
    }

    public Move executeMove(Game game, Player player){
        return null;
    }

    public Board undo(Game game){
        return game.undoStep();
    }
    public void replayGame(Game game){
        game.replayGame();
    }

}
