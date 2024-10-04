package services.BotStrategy;

import models.*;

public interface BotPlayingStrategy {
    Move makeMove(Board board, Player player);
}
