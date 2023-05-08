package LitBot;

public class LitBot extends Player{

    static int numOfLitBots = 1;


    public LitBot(){
        this.NAME = "Litbot " + numOfLitBots;
        numOfLitBots++;
    }
}
