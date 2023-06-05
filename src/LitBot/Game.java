package LitBot;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
public class Game {

    static final String[] cardStrings = {"2S", "3S", "4S", "5S", "6S", "7S", "2H", "3H", "4H", "5H", "6H", "7H", "2D", "3D", "4D", "5D", "6D", "7D", "2C", "3C", "4C", "5C", "6C", "7C", "9S", "TS", "JS", "QS", "KS", "AS", "9H", "TH", "JH", "QH", "KH", "AH", "9D", "TD", "JD", "QD", "KD", "AD", "9C", "TC", "JC", "QC", "KC", "AC", "8S", "8H", "8D", "8C", "BJ", "RJ"};

    public Game(Team teamOne, Team teamTwo){
        Game.teamOne = teamOne;
        Game.teamTwo = teamTwo;
    }

    /*
    Contains all the cards, ordered by set, with the player
    field of the respective card denoting who has the card.
    Sets are in order of:
    Low Spades, Low Hearts, Low Diamonds, Low Clubs
    High Spades, High Hearts, High Diamonds, High Clubs,
    Eights/jokers
     */
    static CardHolder[][] cards = new CardHolder[9][6];

    static Team teamOne;
    static Team teamTwo;

    // Converts the integer representation of a card
    // into the appropriate two-character format
    public static String cardIntToChar(int card){
        if(card < 0 || card > 54){
            throw new IllegalArgumentException("ERROR: INVALID CARD");
        }
        return cardStrings[card];
    }

    // Converts the two-character format of a card
    // into the appropriate integer representation
    public static int cardCharToInt(String card){
        for (int i = 0; i < cardStrings.length; i++) {
            if(cardStrings[i].toLowerCase(Locale.ROOT).equals(card.toLowerCase(Locale.ROOT))){
                return i;
            }
        }
        throw new IllegalArgumentException("ERROR: INVALID CARD");
    }

    // Returns the number of cards the player has
    public static int cardsInHand(Player player){
        int output = 0;
        for (CardHolder[] set: cards) {
            for (CardHolder cardHolder: set) {
                if(cardHolder.equals(player)){
                    output++;
                }
            }
        }
        return output;
    }

    // returns a player on the opposite team than that
    // of activePlayer
    public Player chooseOpponent(Player activePlayer){
        System.out.println("Choose one of the following:");
        for (int i = 0; i < teamOne.players.size(); i++) {
            System.out.println(i + ") " + teamOne.players.get(i).NAME);
        }
        int inputtedInt = -1;
        while(inputtedInt < 1 || inputtedInt > teamOne.players.size()){
            while (Driver.input.hasNext()) {
                if (Driver.input.hasNextInt()) {
                    inputtedInt = Driver.input.nextInt();
                    break;
                } else {
                    System.out.println("Please enter one of the numbers specified above!");
                    Driver.input.next();
                }
            }
        }
        return teamOne.players.get(inputtedInt - 1);
    }

    /*
    Repeatedly asks the player for a valid string input
    and converts it into a card. Optional argument: array
    of cards which are not valid choices to select.
     */
    public int chooseCardExcept(int[] excludedCards){
        List<Integer> options = new ArrayList<>();
        for (int i = 0; i < 54; i++) {
            options.add(i);
        }
        for (int excluded:excludedCards) {
            options.remove(excluded);
        }
        int[] optionsArray = new int[options.size()];
        for (int i = 0; i < optionsArray.length; i++) {
            optionsArray[i] = options.get(i);
        }
        return chooseCardFrom(optionsArray);
    }

    public int chooseCardFrom(int[] options){
        int output;
        while(true){
            output = Driver.input.nextInt();
            for (int option: options) {
                if(option == output){
                    return option;
                } else {
                    System.out.println("NOT A VALID CHOICE! TRY AGAIN...");
                }
            }
        }
    }
}
