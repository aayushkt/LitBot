package LitBot;

public class InputHandler {

    // Asks for any string input from the user
    // this will be used when players enter their names
    public static String chooseAnyString(){
        return null;
    }


    // Asks the player to enter any card,
    // return the appropriate card index number
    // 0-53. See Game.cardStrings, Game.cardCharToInt()
    public static int chooseAnyCard(){
        return -1;
    }

    // A list of players will be given. This function will
    // convey that to the user and then ask them to select
    // one. this function will return their selection.
    // This will be used when a player asks an opponent a
    // question, all the opponents will be passed as an arg.
    public static Player choosePlayer(Player[] playerOptions){
        return null;
    }

    // Similar to choosePlayer(), but with integers (0-53)
    // representing cards. This will be used when a player
    // wants to ask for a card, but can only ask for specific
    // onces (i.e. cards in sets they have)
    public static int chooseCard(int[] cardOptions){
        return -1;
    }

    // The player should be displayed the list of string options
    // and then prompted to select one. Return the selection.
    public static String chooseString(String[] stringOptions){
        return null;
    }
}
