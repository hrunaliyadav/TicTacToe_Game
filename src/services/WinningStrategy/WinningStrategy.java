package services.WinningStrategy;

import models.*;

public interface WinningStrategy {
    Player checkWinner(Board board, Move lastMove);
}
