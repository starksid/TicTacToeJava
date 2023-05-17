package TicTacToe.winningStrategy;

import TicTacToe.Models.Board;
import TicTacToe.Models.GameStatus;
import TicTacToe.Models.Player;

public interface WinningStrategy {
    boolean checkWinner(Board board, Player player, int row, int col);
}
