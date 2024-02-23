package service.WinningStrategy;

public class WinningStrategyFactory {

    public static WinningStrategy getConstructor(WinningStrategyName winningStrategyName, int dimension){
        return new OrderOneWinningStrategy(dimension);
    }
}
