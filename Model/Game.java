package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import Exception.*;
import service.WinningStrategy.WinningStrategy;
import service.WinningStrategy.WinningStrategyFactory;

public class Game {
    private Model.GameStatus GameStatus;
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
        this.GameStatus = Model.GameStatus.IN_PROGRESS;
        this.boardList = new ArrayList<>();
    }

    public Model.GameStatus getGameStatus() {
        return GameStatus;
    }

    public List<Board> getBoardList() {
        return boardList;
    }

    public void setBoardList(List<Board> boardList) {
        this.boardList = boardList;
    }

    public void setGameStatus(Model.GameStatus gameStatus) {
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

    public static Builder builder(){
        return new Builder();
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

        public WinningStrategy getWinningStrategy() {
            return winningStrategy;
        }

        public Builder setWinningStrategy(WinningStrategy winningStrategy) {
            this.winningStrategy = winningStrategy;
            return this;
        }
        private void validateDimension(){
            if(2 > dimension && dimension < 10) {
                throw new InvalidSizeException("Please set the size between 3 to 10");
            }
        }

        private void validateBotCount(){
            int botCount = (int)playerList.stream().filter(player -> player.getPlayertype().equals(PlayerType.BOT)).count();
            if(botCount > 1){
                throw new InvalidPlayerException("at least player need to board size - 2 or ");
            }
        }
        private void validateSymbol(){
            Set<Character> set = playerList.stream()
                    .map(Player::getSymbol)
                    .collect(Collectors.toSet());

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
            validateDimension();
            validateBotCount();
            validateSymbol();
            validateNoOfPlayer();
        }
        public Game build(){
            validate();
            return new Game(playerList, new Board(dimension), winningStrategy);
        }

        public List<Move> getMakeMove() {
            return makeMove;
        }

        public Builder setMakeMove(List<Move> makeMove) {
            this.makeMove = makeMove;
            return this;
        }
    }
    public Board undoStep(){
        Cell cell = makeMove.get(makeMove.size()- 1).getCell();
        cell.undoCell();
        makeMove.remove(makeMove.size()- 1);
        boardList.remove(boardList.size() -1);
        return this.boardList.get(boardList.size() -1);
    }

}
//1081
