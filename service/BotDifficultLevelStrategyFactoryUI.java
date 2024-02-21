package service;

import Model.BOTDIFFICULTYLEVEL;

public class BotDifficultLevelStrategyFactoryUI {
    public static BotDifficultLevelStrategy pickStrategy(BOTDIFFICULTYLEVEL botdifficultylevel){
        if (BOTDIFFICULTYLEVEL.EASY.equals(botdifficultylevel)) {
            new EasyBotDifficultLevelStrategy();
        } else if (BOTDIFFICULTYLEVEL.MEDIUM.equals(botdifficultylevel)) {
            new MediumBotDifficultLevelStrategy();
        } else if (BOTDIFFICULTYLEVEL.HARD.equals(botdifficultylevel)) {
            new HardBotDifficultLevelStrategy();
        }
        return null;
    }
}
