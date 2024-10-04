package models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int dimension;

    private List<List<Cell>> matrix;

    public Board(int dimension) {
        this.dimension = dimension;
        matrix = new ArrayList<>(); //outside Arrayside
        for(int i=0; i<dimension;  i++){
            matrix.add(new ArrayList<>());  //adding internal ArrayList
            for(int j=0; j<dimension; j++){
                matrix.get(i).add(new Cell(i,j));  // adding cells in internal arrylist
            }
        }
    }

    public void displayBoard(){
        for(int i=0; i<dimension; i++){
            List<Cell> cells = matrix.get(i);
            for(Cell cell : cells){
                cell.displaycell();
            }
            System.out.println();
        }
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public List<List<Cell>> getMatrix() {
        return matrix;
    }

    public void setMatrix(List<List<Cell>> matrix) {
        this.matrix = matrix;
    }
}
