package Model;

import service.BotDifficultLevelStrategy;
import service.BotDifficultLevelStrategyFactoryUI;

public class Bot extends  Player{
    private BOTDIFFICULTYLEVEL botdifficultylevel;
    public Bot(int id, char symbol, BOTDIFFICULTYLEVEL botdifficultylevel) {
        super(id, "Chitti", symbol,PLAYERTYPE.BOT);
        this.botdifficultylevel = botdifficultylevel;
    }
    public Move makeMove(Board board){
        BotDifficultLevelStrategy b = BotDifficultLevelStrategyFactoryUI.pickStrategy(botdifficultylevel);
        return b.selectMove(board);
    }
}
