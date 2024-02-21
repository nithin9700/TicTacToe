package Model;

import service.BotDifficultLevelStrategy;
import service.BotDifficultLevelStrategyFactoryUI;

public class Bot extends  Player{
    private BotDifficultyLevel botdifficultylevel;
    public Bot(int id, char symbol, BotDifficultyLevel botdifficultylevel) {
        super(id, "Chitti", symbol, PlayerType.BOT);
        this.botdifficultylevel = botdifficultylevel;
    }
    public Move makeMove(Board board){
        BotDifficultLevelStrategy b = BotDifficultLevelStrategyFactoryUI.pickStrategy(botdifficultylevel);
        return b.selectMove(board);
    }
}
