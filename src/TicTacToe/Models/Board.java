package TicTacToe.Models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    List<List<Cell>> board;
    public Board(int dimension){
        this.board = new ArrayList<>();
        for(int i=0; i<dimension; i++){
            this.board.add(new ArrayList<>());
            for(int j=0; j<dimension; j++){
                this.board.get(i).add(new Cell(i, j));
            }
        }

    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    public void displayBoard(){
        for(int i=0; i<board.size(); i++){
            for(int j=0; j<board.size(); j++){
                Cell cell = board.get(i).get(j);
                if(cell.getCellState().equals(CellState.EMPTY)){
                    System.out.print("| - |");
                }else{
                    System.out.print("| "+ cell.getPlayer().getaChar() + " |");
                }

            }
            System.out.print("\n");
        }
    }
}
