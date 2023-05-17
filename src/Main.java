import TicTacToe.Controller.GameController;
import TicTacToe.Models.Game;
import TicTacToe.Models.GameStatus;
import TicTacToe.Models.Player;
import TicTacToe.Models.PlayerType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        for(int j = 0; j<2; j++){
            String Name = sc.next();
            char aChar = sc.next().charAt(0);
            PlayerType type = PlayerType.HUMAN;
            players.add(new Player(Name, aChar, PlayerType.HUMAN));


        }
        int dimension = 3;
        GameController gameController = new GameController();
        Game game = gameController.createGame(players, dimension);
        int i = 0;
        while(game.getGameStatus().equals(GameStatus.IN_PROGRESS)){
            gameController.makeMove(game);
            gameController.printBoard(game);


            i++;







        }



    }
}