package LitBot;

import java.util.Scanner;

public class Player extends CardHolder{
    String NAME;
    public Team team;

    public Player(String NAME){
        this.NAME = NAME;
    }

    public Player(){
        System.out.print("Enter the player's name: ");
        this.NAME = Driver.input.next();
    }
}