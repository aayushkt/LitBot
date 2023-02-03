package LitBot;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args){
        System.out.println("Hello, world!");
        setupGame();
    }

    public static void setupGame(){
        List<Player> players = getPlayers();
        dealCards();
    }

    public static List<Player> getPlayers(){
        Scanner input = new Scanner(System.in);
        int numOfPlayers = 0;

        System.out.print("Enter the number of players (including LitBot): ");
        try{
            numOfPlayers = input.nextInt();
        } catch (Exception e) {
            System.out.println("Please enter an even integer.");
            System.out.println(e);
            input.reset();
        }

        List<Player> players = new ArrayList<Player>(numOfPlayers);

        System.out.println("Enter the names of LitBot's teammates:");
        for (int i = 0; i < (numOfPlayers/2) - 1; i++) {
            String name = input.next();
            Player temp = new Player(name, true);
            players.add(temp);
        }
        System.out.println("Enter the names of the opposing team:");
        for (int i = 0; i < numOfPlayers/2; i++){
            String name = input.next();
            Player temp = new Player(name, true);
        }

        return players;
    }

    public static void dealCards(){
        List<Card> deck = new ArrayList<Card>(52);
        for (Suit s : Suit.values()) {
            for (int i = 1; i < 14; i++) {
                Card newCard = new Card(i, s);
                deck.add(newCard);
            }
        }

    }
}