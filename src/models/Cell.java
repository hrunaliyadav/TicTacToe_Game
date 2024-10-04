package models;

import enums.CellType;

public class Cell {
    private int row;
    private int col;
    private CellType cellType;
    private Player player;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.cellType = CellType.EMPTY;
        this.player = null;
    }

    public void displaycell(){
        if(player==null){
            System.out.print("| |");
        }else{
            System.out.print("|"+player.getSymbol()+"|");
        }
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public CellType getCellType() {
        return cellType;
    }

    public void setCellType(CellType cellType) {
        this.cellType = cellType;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
