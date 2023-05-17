package TicTacToe.Models;

import TicTacToe.winningStrategy.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    List<Player> players;
    Board board;
    Player winner;
    int currentPlayerIndex;
    GameStatus gameStatus;
    List<Move> moves;
    List<WinningStrategy> winningStrategies;

    private Game(){}

    public static Builder getBuilder(){
        return new Builder();
    }

    public static class Builder{
        int dimension;
        List<Player> players;
        private Builder(){
            this.players = new ArrayList<>();
            this.dimension = 0;

        }
        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Game build(){
            Game game = new Game();
            game.gameStatus = GameStatus.IN_PROGRESS;
            game.currentPlayerIndex = 0;
            game.moves = new ArrayList<>();
            game.players = players;
            game.board = new Board(dimension);
            game.winningStrategies = new ArrayList<>();
            game.winningStrategies.add(new ColWinningStrategy());
            game.winningStrategies.add(new RowWinningStrategy());
            game.winningStrategies.add(new LeftDiagonalWinningStrategy());
            game.winningStrategies.add(new RightDiagonalWinningStrategy());

            return game;
        }
    }
    public void displayBoard(){
        this.board.displayBoard();
    }
    public void DecideMove(){
        Scanner scn = new Scanner(System.in);
        Player player = players.get(currentPlayerIndex);
        System.out.println(player.Name + "please give input for the row");
        int row = scn.nextInt();
        System.out.println(player.Name + "please give input for col");
        int col = scn.nextInt();
        if(row<0 || row>=3 || col<0 || col>=3){
            System.out.println("wrong input");
        }else{
            Cell cell = board.getBoard().get(row).get(col);
            if(cell.getCellState().equals(CellState.EMPTY)){
                cell.setCellState(CellState.FILLED);
                cell.setPlayer(player);
                for(int i=0; i<4; i++){
                    if(winningStrategies.get(i).checkWinner(board, player, row, col)==true){
                        System.out.println(player.Name + " has Won the tic tac toe game with symbol of " + player.aChar );
                        gameStatus = GameStatus.SUCCESS;
                    }
                }
                moves.add(new Move(player, cell));
                if(moves.size()==9){
                    gameStatus = GameStatus.DRAW;
                    System.out.println("DRAW, No one has won this tic tac toe game");
                }
                currentPlayerIndex+=1;
                currentPlayerIndex%=2;

            }
            else{
                System.out.println("This Cell is already Filled!");
            }


        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }
}
