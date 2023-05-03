package LitBot;

import java.util.ArrayList;
import java.util.List;

public class Player extends CardHolder{
    final boolean LIT_BOT_TEAM;
    final String NAME;
    final List<Card> HAND = new ArrayList<>();

    public Player(String name, boolean LitBotTeam){
        this.NAME = name;
        this.LIT_BOT_TEAM = LitBotTeam;
    }

    public void printHand(){
        System.out.println(NAME + "'s hand:");
        for (Card c: HAND ) {
            System.out.println("\t" + c);
        }
    }
}