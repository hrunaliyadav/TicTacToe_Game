package models;

import enums.CellType;
import enums.PlayerType;
import exceptions.InvalidRowAndColumn;

import java.util.Scanner;

public class Player {
    private int id;
    private String name;
    private char symbol;
    private PlayerType playerType;

    public Player(int id, String name, char symbol, PlayerType playerType) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public Move makeMove(Board board){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter row = ");
        int row = sc.nextInt();
        System.out.println("Enter column = ");
        int col = sc.nextInt();
        int boardsize = board.getDimension();

        //validation
        if (row>=0 && row<boardsize && col>=0 && col<boardsize){
            board.getMatrix().get(row).get(col).setCellType(CellType.FILLED);
            board.getMatrix().get(row).get(col).setPlayer(this);
            return new Move(board.getMatrix().get(row).get(col),this);
        }else{
            throw new InvalidRowAndColumn("Invalid row or col. Please enter valid Row and Column");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }
}
