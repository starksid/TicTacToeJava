package TicTacToe.winningStrategy;

import TicTacToe.Models.Board;
import TicTacToe.Models.Cell;
import TicTacToe.Models.CellState;
import TicTacToe.Models.Player;

public class ColWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Player player, int row, int col) {
        int count = 0;
        for(int i =0; i<board.getBoard().size(); i++){
            char playerChar = player.getaChar();
            Cell cell = board.getBoard().get(i).get(col);
            if(cell.getCellState().equals(CellState.EMPTY)){
                continue;
            }else{
                char boardChar = cell.getPlayer().getaChar();
                if(boardChar==playerChar){
                    count++;
                }
            }
        }
        if(count==3){
            return true;
        }
        return false;

    }
}
