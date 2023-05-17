package TicTacToe.Controller;

import TicTacToe.Models.Game;
import TicTacToe.Models.GameStatus;
import TicTacToe.Models.Player;
import TicTacToe.Models.PlayerType;

import java.util.List;

public class GameController {
    public Game createGame(List<Player> players, int dimension){
        return Game.getBuilder().setPlayers(players).setDimension(dimension).build();
    }
    public void getWinner(Game game){}
    public void printBoard(Game game){
        game.displayBoard();
    }
    public void makeMove(Game game){
        game.DecideMove();
    }
    public GameStatus checkGameStatus(Game game){
        return game.getGameStatus();
    }

}
