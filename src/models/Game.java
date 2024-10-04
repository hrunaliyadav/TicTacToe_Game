package models;

import enums.GameStatus;
import enums.PlayerType;
import exceptions.InvalidBotCount;
import exceptions.InvalidDimensionSize;
import exceptions.InvalidNoOfPlayers;
import exceptions.InvalidSymbolException;
import services.WinningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {
    private Board currentboard;
    private Player currentplayer;
    private List<Player> players;
    private List<Move> moves;
    private GameStatus gameStatus;
    private WinningStrategy winningStrategy;
    private List<Board> boardStatus;
    private int noOfSymbols;



    public Game(Board currentboard, List<Player> players, WinningStrategy winningStrategy) {
        this.currentboard = currentboard;
        this.currentplayer = null;
        this.players = players;
        this.moves = new ArrayList<>();
        this.gameStatus = GameStatus.INPROGRESS;
        this.winningStrategy = winningStrategy;
        this.noOfSymbols = noOfSymbols;
        this.boardStatus = new ArrayList<>();
    }

    public static Builder builder(){
        return new Builder();
    }

    public List<Board> getBoardStatus() {
        return boardStatus;
    }

    public void setBoardStatus(List<Board> boardStatus) {
        this.boardStatus = boardStatus;
    }

    public Board getCurrentboard() {
        return currentboard;
    }

    public void setCurrentboard(Board currentboard) {
        this.currentboard = currentboard;
    }

    public Player getCurrentplayer() {
        return currentplayer;
    }

    public void setCurrentplayer(Player currentplayer) {
        this.currentplayer = currentplayer;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public WinningStrategy getWinningStrategy() {
        return winningStrategy;
    }

    public void setWinningStrategy(WinningStrategy winningStrategy) {
        this.winningStrategy = winningStrategy;
    }

    public int getNoOfSymbols() {
        return noOfSymbols;
    }

    public void setNoOfSymbols(int noOfSymbols) {
        this.noOfSymbols = noOfSymbols;
    }

    //Creating Builder Design Pattern
    public static class Builder{
        private int dimension;
        private Board currentboard;
        private List<Player> players;
        private WinningStrategy winningStrategy;

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setCurrentboard(Board currentboard) {
            this.currentboard = currentboard;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategy(WinningStrategy winningStrategy) {
            this.winningStrategy = winningStrategy;
            return this;
        }

        //validate
        public void validateNoOfPlayers(){
            if(players.size()>dimension || players.size()<dimension-2){
                throw new InvalidNoOfPlayers("Players size should be N OR N-1");
            }
        }

        public void validateNoOfSymbols(){
            //Unique Symbol -> HashSet
            HashSet<Character> symbol = new HashSet<>();
            for(Player player : players){
                symbol.add(player.getSymbol());
            }
            if(symbol.size() != players.size()){
                throw new InvalidSymbolException("Symbol size should equal to Players size");
            }
        }

        public void validateDimensionSize(){
            if(dimension<3 || dimension>10){
                throw new InvalidDimensionSize("Dimension or Board Size should be 3 to 10");
            }
        }

        public void validateBotCount(){
            long botcount = players.stream().filter(player -> player.getPlayerType().equals(PlayerType.BOT)).count();
            if(botcount!=1){
                throw new InvalidBotCount("You can add only one Bot");
            }
        }

        public void validate(){
            validateBotCount();;
            validateDimensionSize();;
            validateNoOfSymbols();
            validateNoOfPlayers();
        }
        public Game build(){
            validate();
            return new Game(new Board(dimension),players,winningStrategy);
        }
    }
}
