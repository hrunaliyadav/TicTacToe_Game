package models;

import enums.*;
import services.BotStrategy.BotStrategyFactory;

public class Bot extends Player{
    private BotLevel botLevel;

    public Bot(int id, String name, char symbol, BotLevel botLevel) {
        super(id, name="Chitti", symbol='$', PlayerType.BOT);
        this.botLevel = botLevel;
    }

    public Move makeMove (Board board){
        return BotStrategyFactory.getBotPlayingStrategy().makeMove(board, this);
    }

}
