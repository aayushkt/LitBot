package LitBot;

public class Card {
    final int VALUE;
    final Suit SUIT;
    final int ID;

    public Card(int VALUE, Suit SUIT){
        this.VALUE = VALUE;
        this.SUIT = SUIT;
        ID = SUIT.ordinal() * 13 + VALUE;
    }

    @Override
    public String toString() {
        String valueString;
        if( SUIT == Suit.Joker){
            if(VALUE == 1){
                return "Red Joker";
            }else{
                return "Black Joker";
            }
        }else{
            switch (VALUE){
                case 1:
                    valueString = "Ace";
                    break;

                case 11:
                    valueString = "Jack";
                    break;

                case 12:
                    valueString = "Queen";
                    break;

                case 13:
                    valueString = "King";
                    break;

                default:
                    valueString = VALUE + "";
                    break;
            }
        }

        return valueString + " of " + SUIT.name().substring(0, 1).toUpperCase() + SUIT.name().substring(1) + "s";
    }
}
