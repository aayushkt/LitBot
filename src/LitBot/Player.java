package LitBot;

import java.util.ArrayList;
import java.util.List;
public class Player {
    boolean LitBotTeam;
    String name;
    List<Card> hand = new ArrayList<Card>();

    public Player(String name, boolean LitBotTeam){
        this.name = name;
        this.LitBotTeam = LitBotTeam;
    }

    public void printHand(){
        for (Card c: hand ) {
            System.out.println(c);
        }
    }
}
