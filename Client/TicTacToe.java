package Client;

import Controller.GameController;
import Model.*;
import service.WinningStrategy.WinningStrategyName;

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
        Game game = new GameController().createGame(dimension,playerList, WinningStrategyName.OrderOneWinningStrategy);
        int playerIndex = -1;
        boardList.add(game.getCurrentBoard());
        while (game.getGameStatus().equals(GameStatus.IN_PROGRESS)){
            playerIndex++;
            playerIndex = playerIndex % playerList.size();
            System.out.println(playerList.get(playerIndex).getName());
            Move playedMove = gameController.executeMove(game, playerList.get(playerIndex));
            moveList.add(playedMove);
            game.setMakeMove(moveList);
            boardList.add(game.getCurrentBoard());
            Player winner = gameController.checkWinner(game, playedMove);
            if(winner != null){
                System.out.println("Winner is: " + winner.getName());
                System.out.println("Final Board Status");
                gameController.displayGame(game);
                break;
            }
            System.out.println("Current Board Status");
            gameController.displayGame(game);
//            System.out.println("Do you want Undo the game? Y or N");
//            String undo = sc.next();
            //if(undo.equalsIgnoreCase("y")) gameController.Undo(game);
            if(boardList.size() == (dimension * dimension)){
                game.setGameStatus(GameStatus.DRAW);
                System.out.println("Your Match is DRAW");
            }
        }

        System.out.println("Do you want to replay? Y or N");
        String replay = sc.next();
        if(replay.equalsIgnoreCase("y")) {
            gameController.replayGame(game,boardList);
        }
    }
}
/*
|$||$||a|
|a||a||$|
|$|| ||a|
 */