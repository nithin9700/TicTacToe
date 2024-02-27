package Client;

import Controller.GameController;
import Model.*;
import service.WinningStrategy.WinningStrategy;
import service.WinningStrategy.WinningStrategyFactory;
import service.WinningStrategy.WinningStrategyName;

import javax.xml.transform.Source;
import java.util.*;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GameController gameController = new GameController();
        int id = 1;
        List<Player> playerList = new ArrayList<>();
        List<Move> moveList = new ArrayList<>();
        List<Board> boardList = new ArrayList<>();
        System.out.println("Welcome to TicTacToe Game");
        System.out.println("Please enter the board size between 3 to 10:");
        int dimension = sc.nextInt();
        System.out.println("Do you want Bot? Y or N");
        String botCheck = sc.next();
        if(botCheck.equalsIgnoreCase("Y")){
            Bot bot = new Bot(id, '$', BotDifficultyLevel.EASY);
            id++;
            playerList.add(bot);
        }
        while (id < dimension){
            System.out.println("Please enter player name");
            String playerName = sc.next();
            System.out.println("Please enter player symbol");
            char symbol = sc.next().charAt(0);
            while(botCheck.equalsIgnoreCase("Y") && symbol == '$'){
                System.out.println("you cannot select the symbol which auto assign to bot");
                symbol = sc.next().charAt(0);
            }
            Player player = new Player(id, playerName, symbol, PlayerType.HUMAN);
            playerList.add(player);
            id++;
        }
        Collections.shuffle(playerList);
        Game game = new GameController().createGame(dimension,playerList);
        int playerIndex = -1;
        boardList.add(game.getCurrentBoard());
        game.setCurrentBoard(game.clone());
        while (game.getGameStatus().equals(GameStatus.IN_PROGRESS)){
            playerIndex++;
            playerIndex = playerIndex % playerList.size();
            System.out.println(playerList.get(playerIndex).getName());
            Move playedMove = gameController.executeMove(game, playerList.get(playerIndex));
            Player player = playedMove.getPlayer();
            System.out.println("Current Board Status");
            gameController.displayGame(game);
            moveList.add(playedMove);
            game.setMakeMove(moveList);
            boardList.add(game.getCurrentBoard());
            game.setCurrentBoard(game.clone());

            if(player.getPlayertype() == PlayerType.HUMAN) {
                System.out.println("Do you want to undo the step? Y or N");
                String undoInput = sc.next();
                if (undoInput.equalsIgnoreCase("Y")) {
                    game.setBoardList(boardList);
                    game.setCurrentBoard(game.undoStep());
                    System.out.println("Current Board Status");
                    gameController.displayGame(game);
                    boardList = new ArrayList<>(game.getBoardList());;
                }
            }
            Player winner = gameController.checkWinner(game, playedMove);
            if(winner != null){
                System.out.println("Winner is: " + winner.getName());
                System.out.println("Final Board Status");
                gameController.displayGame(game);
                break;
            }

            if(moveList.size() == (dimension * dimension)){
                game.setGameStatus(GameStatus.DRAW);
                System.out.println("Your Match is DRAW");
            }
        }
        game.setBoardList(boardList);
        System.out.println("Do you want to replay? Y or N");
        String replay = sc.next();
        if(replay.equalsIgnoreCase("y")) {
            gameController.replayGame(game);
        }

    }
}
