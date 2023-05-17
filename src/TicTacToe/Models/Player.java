package TicTacToe.Models;

public class Player {
    String Name;
    char aChar;
    PlayerType type;
    public Player(String Name, char aChar, PlayerType type){
        this.Name = Name;
        this.aChar = aChar;
        this.type = type;
    }

    public PlayerType getType() {
        return type;
    }

    public void setType(PlayerType type) {
        this.type = type;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public char getaChar() {
        return aChar;
    }

    public void setaChar(char aChar) {
        this.aChar = aChar;
    }
}
