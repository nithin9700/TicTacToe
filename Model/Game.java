package Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import Exception.*;
import service.WinningStrategy;

public class Game {
    private GAMESTATUS GameStatus;
    private int dimension;
    private Player currentPlayer;
    private List<Player> playerList;
    private Board currentBoard;
    private List<Move> makeMove;
    private WinningStrategy winningStrategy;
    private List<Board> boardList;


    private Game(List<Player> playerList, Board currentBoard, WinningStrategy winningStrategy) {
        this.playerList = playerList;
        this.currentBoard = currentBoard;
        this.winningStrategy = winningStrategy;
        this.makeMove = new ArrayList<>();
        this.GameStatus = GAMESTATUS.IN_PROGRESS;
        this.boardList = new ArrayList<>();
    }
    public Builder builder(){
        return new Builder();
    }
    public GAMESTATUS getGameStatus() {
        return GameStatus;
    }

    public List<Board> getBoardList() {
        return boardList;
    }

    public void setBoardList(List<Board> boardList) {
        this.boardList = boardList;
    }

    public void setGameStatus(GAMESTATUS gameStatus) {
        GameStatus = gameStatus;
    }
    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public Board getCurrentBoard() {
        return currentBoard;
    }

    public void setCurrentBoard(Board currentBoard) {
        this.currentBoard = currentBoard;
    }

    public List<Move> getMakeMove() {
        return makeMove;
    }

    public void setMakeMove(List<Move> makeMove) {
        this.makeMove = makeMove;
    }

    public WinningStrategy getWinningStrategy() {
        return winningStrategy;
    }

    public void setWinningStrategy(WinningStrategy winningStrategy) {
        this.winningStrategy = winningStrategy;
    }


    public static class Builder{
        private int dimension;
        private Player currentPlayer;
        private WinningStrategy winningStrategy;
        private List<Player> playerList;
        private Board currentBoard;
        private List<Move> makeMove;



        public int getDimension() {
            return dimension;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Player getCurrentPlayer() {
            return currentPlayer;
        }

        public Builder setCurrentPlayer(Player currentPlayer) {
            this.currentPlayer = currentPlayer;
            playerList.add(currentPlayer);
            return this;
        }
        public List<Player> getPlayerList() {
            return playerList;
        }

        public Builder setPlayerList(List<Player> playerList) {
            this.playerList = playerList;
            return this;
        }

        public Board getCurrentBoard() {
            return currentBoard;
        }

        public Builder setCurrentBoard(Board currentBoard) {
            this.currentBoard = currentBoard;
            return this;
        }

        public List<Move> getMakeMove() {
            return makeMove;
        }

        public Builder setMakeMove(List<Move> makeMove) {
            this.makeMove = makeMove;
            return this;
        }

        public WinningStrategy getWinningStrategy() {
            return winningStrategy;
        }

        public Builder setWinningStrategy(WinningStrategy winningStrategy) {
            this.winningStrategy = winningStrategy;
            return this;
        }

        private void validateBotCount(){
            int botCount = 0;
            for (Player player : playerList) {
                if(player.getPlayertype().equals(PLAYERTYPE.BOT)) botCount++;
            }
            if(botCount > 1 || botCount < 0){
                throw new InvalidPlayerException("at least player need to board size - 2 or ");
            }
        }
        private void validateSymbol(){
            HashSet<Character> set = new HashSet<>();
            for(Player player : playerList){
                set.add(player.getSymbol());
            }
            if(set.size() != playerList.size()){
                throw new InvalidSymbolException("Some players symbol are matching");
            }
        }

        private void validateNoOfPlayer(){
            if(playerList.size() < dimension - 2 || playerList.size() >= dimension){
                throw new InvalidPlayerException("Player are not matching according to the board size selection Note: player need to at least board size - 2");

            }
        }
        private void validate(){
            validateBotCount();
            validateSymbol();
            validateNoOfPlayer();
        }

        public Game build(){
            return new Game(playerList, new Board(dimension), winningStrategy);
        }
    }
}
