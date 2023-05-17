package TicTacToe.Models;

public class Bot extends Player {
    BotDifficultyLevel botDifficultyLevel;
    public Bot(BotDifficultyLevel botDifficultyLevel, String Name, char aChar){
        super(Name, aChar, PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;

    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }
}
