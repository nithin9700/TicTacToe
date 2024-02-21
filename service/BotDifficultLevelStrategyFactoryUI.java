package service;

import Model.BotDifficultyLevel;

public class BotDifficultLevelStrategyFactoryUI {
    public static BotDifficultLevelStrategy pickStrategy(BotDifficultyLevel botdifficultylevel){
        if (BotDifficultyLevel.EASY.equals(botdifficultylevel)) {
            new EasyBotDifficultLevelStrategy();
        } else if (BotDifficultyLevel.MEDIUM.equals(botdifficultylevel)) {
            new MediumBotDifficultLevelStrategy();
        } else if (BotDifficultyLevel.HARD.equals(botdifficultylevel)) {
            new HardBotDifficultLevelStrategy();
        }
        return null;
    }
}
