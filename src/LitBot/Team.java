package LitBot;

import java.util.List;

public class Team extends CardHolder{
    List<Player> players;

    public Team(List<Player> players){
        this.players = players;
        for (Player p: players) {
            p.team = this;
        }
    }
}
