package LitBot;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Driver {

    static List<Player> players = new ArrayList<>();
    static int LitBotTeamSets = 0;
    static int OpposingTeamSets = 0;

    public static void main(String[] args){
//        setupGame();
        System.out.println(Suit.valueOf("Spades").ordinal());
    }

    public static void setupGame(){
        setupPlayers();
        dealCards();
        // Debugging
        /*
        for (Player p: players ) {
            System.out.println(p.name);
            p.printHand();
            System.out.println();
        }
        */
        playGame(players.get(0));
    }

    public static void setupPlayers(){
        Scanner input = new Scanner(System.in);
        int numOfPlayers = 0;

        System.out.print("Enter the number of players (including LitBot): ");
        try{
            numOfPlayers = input.nextInt();
        } catch (Exception e) {
            System.out.println("Please enter an even integer.");
            //TODO: Input sanitization and error handling
            System.out.println(e);
            input.reset();
        }


        System.out.println("Enter the names of LitBot's teammates:");
        Player LitBot = new Player("LitBot", true);
        players.add(LitBot);
        for (int i = 0; i < (numOfPlayers/2) - 1; i++) {
            String name = input.next();
            Player temp = new Player(name, true);
            players.add(temp);
        }
        System.out.println("Enter the names of the opposing team:");
        for (int i = 0; i < numOfPlayers/2; i++){
            String name = input.next();
            Player temp = new Player(name, false);
            players.add(temp);
        }

    }

    public static void dealCards(){
        List<Card> deck = new ArrayList<>(54);
        for (Suit s : Suit.values()) {
            if (s == Suit.Joker){
                Card newCard = new Card(0, s);
                deck.add(newCard);
                newCard = new Card(1, s);
                deck.add(newCard);
            }else{
                for (int i = 1; i < 14; i++) {
                    Card newCard = new Card(i, s);
                    deck.add(newCard);
                }
            }
        }

        int handSize = deck.size()/(players.size());
        Random r = new Random();
        for (int i = 0; i < handSize; i++) {
            for (Player p : players) {
                int randomCardIndex = r.nextInt(deck.size());
                p.HAND.add(deck.get(randomCardIndex));
                deck.remove(randomCardIndex);
            }
        }

        int playerNum = 0;
        while(deck.size() > 0){
            int randomCardIndex = r.nextInt(deck.size());
            players.get(playerNum).HAND.add(deck.get(randomCardIndex));
            deck.remove(randomCardIndex);
            randomCardIndex = r.nextInt(deck.size());
            players.get(players.size() - playerNum - 1).HAND.add(deck.get(randomCardIndex));
            deck.remove(randomCardIndex);
            playerNum++;
        }
    }

    public static void playGame(Player startingPlayer){
        Player currentPlayer = startingPlayer;
        // TODO: Implement playing game logic
    }
}