package service;

import Model.BotDifficultyLevel;
import Exception.BotLevelIsNull;

public class BotDifficultLevelStrategyFactoryUI {
    public static BotDifficultLevelStrategy pickStrategy(BotDifficultyLevel botdifficultylevel){
//        if (botdifficultylevel.equals(BotDifficultyLevel.EASY)) {
//            new EasyBotDifficultLevelStrategy();
//        } else if(botdifficultylevel.equals(BotDifficultyLevel.MEDIUM)) {
//            new MediumBotDifficultLevelStrategy();
//        } else if (botdifficultylevel.equals(BotDifficultyLevel.HARD)){
//            new HardBotDifficultLevelStrategy();
//        }
        return new EasyBotDifficultLevelStrategy();
    }
}
