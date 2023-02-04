package LitBot;

import java.util.ArrayList;
import java.util.List;

public class Card {
    int value;
    Suit suit;

    public Card(int value, Suit suit){
        this.value = value;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return value + " of " + suit;
    }
}
