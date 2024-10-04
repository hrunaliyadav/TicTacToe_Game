package services.WinningStrategy;

import enums.WinningStrategyNames;

public class WinningStrategyFactory {
    public static WinningStrategy getWinningStrategy(WinningStrategyNames name, int dimension){
        return new OrderOneWinningStrategy(dimension);
    }
}
