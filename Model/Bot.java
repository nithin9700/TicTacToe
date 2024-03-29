package Model;

import static service.BotDifficultLevelStrategy.BotDifficultLevelStrategyFactoryUI.pickStrategy;

public class Bot extends  Player{
    private final BotDifficultyLevel  botdifficultylevel;
    public Bot(int id, char symbol, BotDifficultyLevel botdifficultylevel) {
        super(id, "Chitti", symbol, PlayerType.BOT);
        this.botdifficultylevel = botdifficultylevel;
    }
    public Move makeMove(Board board){

        return pickStrategy(botdifficultylevel).makeMove(board, this);
        
    }
}
