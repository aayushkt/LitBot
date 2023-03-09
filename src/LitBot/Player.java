package LitBot;

import java.util.ArrayList;
import java.util.List;

public class Player {
    final boolean LIT_BOT_TEAM;
    final String NAME;
    final List<Card> HAND = new ArrayList<>();

    public Player(String name, boolean LitBotTeam){
        this.NAME = name;
        this.LIT_BOT_TEAM = LitBotTeam;
    }

    public void printHand(){
        for (Card c: HAND ) {
            System.out.println(c);
        }
    }
}