package LitBot;

import java.lang.reflect.Type;
import java.util.*;

public class Driver {

    public static void main(String[] args){
        setupGame();
    }
    public static Scanner input = new Scanner(System.in);

    public static void setupGame(){
        setupPlayers();
    }

    public static void setupPlayers(){

        int numOfPlayers = 0;

        System.out.println("Enter an even number:");
        while (input.hasNext()) {
            if (input.hasNextInt()) {
                int number = input.nextInt();
                if (number % 2 == 0) {
                    numOfPlayers = number;
                    break;
                } else {
                    System.out.println("Please enter an even number");
                }
            } else {
                System.out.println("Please enter an even number");
                input.next();
            }
        }

        /*
         TODO:
         Probably use reflection to generate the right types
         of players instead of manually storing them in this list
         and putting them in the switch statement
        */
        List<String> playerTypes = Arrays.asList("human", "litbot");

        System.out.println("Enter the players on team one!");
        List<Player> teamOne = new ArrayList<>();
        while(teamOne.size() < numOfPlayers/2){
            System.out.println("Which type of player?");
            String rawString = input.nextLine().toLowerCase(Locale.ROOT);
            if (playerTypes.contains(rawString)){
                switch (rawString) {
                    case "human" -> teamOne.add(new Player());
                    case "litbot" -> teamOne.add(new LitBot());
                }
            }
            System.out.println("No players of type " + rawString);
        }

        Team firstTeam = new Team(teamOne);

        System.out.println("Enter the players on team one!");
        List<Player> teamTwo = new ArrayList<>();
        while(teamTwo.size() < numOfPlayers/2){
            System.out.println("Which type of player?");
            input = new Scanner(System.in);
            String rawString = input.nextLine().toLowerCase(Locale.ROOT);
            if (playerTypes.contains(rawString)){
                switch (rawString) {
                    case "human" -> teamTwo.add(new Player());
                    case "litbot" -> teamTwo.add(new LitBot());
                }
            }
        }

        Team secondTeam = new Team(teamTwo);

    }

}