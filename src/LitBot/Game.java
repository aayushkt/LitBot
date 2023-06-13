package LitBot;

import java.util.Locale;
public class Game {

    static final String[] cardStrings = {"2S", "3S", "4S", "5S", "6S", "7S", "2H", "3H", "4H", "5H", "6H", "7H", "2D", "3D", "4D", "5D", "6D", "7D", "2C", "3C", "4C", "5C", "6C", "7C", "9S", "TS", "JS", "QS", "KS", "AS", "9H", "TH", "JH", "QH", "KH", "AH", "9D", "TD", "JD", "QD", "KD", "AD", "9C", "TC", "JC", "QC", "KC", "AC", "8S", "8H", "8D", "8C", "BJ", "RJ"};

    public Game(Team teamOne, Team teamTwo){
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
    }

    /*
    Contains all the cards, ordered by set, with the player
    field of the respective card denoting who has the card.
    Sets are in order of:
    Low Spades, Low Hearts, Low Diamonds, Low Clubs
    High Spades, High Hearts, High Diamonds, High Clubs,
    Eights/jokers
     */
    CardHolder[][] cards = new CardHolder[9][6];

    Team teamOne;
    Team teamTwo;

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
    public int cardsInHand(Player player){
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
    private Player chooseOpponent(Player activePlayer){
        Team oppositeTeam;
        if(teamOne.players.contains(activePlayer)){
            oppositeTeam = teamOne;
        } else {
            oppositeTeam = teamTwo;
        }
        return InputHandler.choosePlayer((Player[])oppositeTeam.players.toArray());
    }

    // INPUT: The player whose turn it is
    // OUTPUT: The player whose turn it becomes once this turn is over
    // Note: If the player plays well, it will return the same activePlayer
    // because it will be their turn again
    public Player takeTurn(Player activePlayer){
        // first they decide 'call set' or 'ask for card'
        // if they decide to call set
            // do some magic
        // else they decided to ask for card
            // Generate list of possible cards that player can ask
            // Note: According to official rules, cannot ask for a card you have
        return null;
    }
}
