package LitBot;

public class Game {

    static CardHolder[][] cards = new CardHolder[9][6];
    /*
    Contains all the cards, ordered by set, with the player
    field of the respective card denoting who has the card.
    Sets are in order of:
    Low Spades, Low Hearts, Low Diamonds, Low Clubs
    High Spades, High Hearts, High Diamonds, High Clubs,
    Eights/jokers
     */

    // Converts the integer representation of a card
    // into the appropriate two-character format
    public static String cardIntToChar(int card){
        int setOfCard = card / 6;
        int cardNum = card % 6;
        String cardChars = "";
        if(setOfCard != 8){
            // not part of eights set
            if(setOfCard < 4){
                cardChars += cardNum + 2;
            } else {
                switch (cardNum) {
                    case 0 -> cardChars += '9';
                    case 1 -> cardChars += 'T';
                    case 2 -> cardChars += 'J';
                    case 3 -> cardChars += 'Q';
                    case 4 -> cardChars += 'K';
                    case 5 -> cardChars += 'A';
                }
            }

            switch (setOfCard % 4) {
                case 0 -> cardChars += 'S';
                case 1 -> cardChars += 'H';
                case 2 -> cardChars += 'D';
                case 3 -> cardChars += 'C';
            }
        } else {
            if(cardNum > 3){
                if(cardNum == 5){
                    cardChars = "RJ";
                } else {
                    cardChars = "BJ";
                }
            } else {
                cardChars += '8';
                switch (cardNum) {
                    case 0 -> cardChars += 'S';
                    case 1 -> cardChars += 'H';
                    case 2 -> cardChars += 'D';
                    case 3 -> cardChars += 'C';
                }
            }
        }
        return cardChars;
    }

    // Converts the two-character format of a card
    // into the appropriate integer representation
    public static int cardCharToInt(String card){
        if(card.length() != 2){
            throw new IllegalArgumentException();
        }
        int set = -1;
        int cardNum = -1;
        boolean low = false;
        try {
            int cardValue = Integer.parseInt(card.substring(0, 1));
            if(cardValue < 8){
                low = true;
                cardNum = cardValue - 2;
            } else {
                if(cardValue == 8){
                    set = 8;
                }else{
                    cardNum = 0;
                }
            }
        }catch (Exception e){
            switch (card.charAt(0)){
                case 'T':
                    cardNum = 1;
                break;
                case 'J':
                    cardNum = 2;
                break;
                case 'Q':
                    cardNum = 3;
                break;
                case 'K':
                    cardNum = 4;
                break;
                case 'A':
                    cardNum = 5;
                break;
                case 'B':
                    return 52;
                case 'R':
                    return 53;
            }
        }
        if(set == -1){
            int highSet = low ? 0 : 1;
            set = switch (card.charAt(1)) {
                case 'S' -> 4 * highSet;
                case 'H' -> 1 + 4 * highSet;
                case 'D' -> 2 + 4 * highSet;
                case 'C' -> 3 + 4 * highSet;
                default -> set;
            };
        } else {
            switch (card.charAt(1)){
                case 'S':
                    return 48;
                case 'H':
                    return 49;
                case 'D':
                    return 50;
                case 'C':
                    return 51;
            }
        }
        return set*6 + cardNum;
    }
}
