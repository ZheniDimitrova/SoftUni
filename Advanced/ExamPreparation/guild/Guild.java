package guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {

    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (roster.size() < capacity) {
            roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        return roster.removeIf(player -> player.getName().equals(name));
    }

    public void promotePlayer (String name) {

        for (Player player : roster){
            if (player.getName().equals(name) && !player.getRank().equals("Member")){
                player.setRank("Member");
            }
        }

    }
    public void demotePlayer (String name) {
        for (Player player : roster){
            if (player.getName().equals(name) && !player.getRank().equals("Trial")){
                player.setRank("Trial");
            }
        }

    }
    public Player[] kickPlayersByClass(String clazz) {
        Player[] kickedPlayers = roster.stream()
                .filter(player -> player.getClazz().equals(clazz))
                .toArray(Player[]::new);

        for (Player player : kickedPlayers){
            roster.remove(player);
        }
        return kickedPlayers;
    }

    public int count() {
        return roster.size();
    }
    public String report() {
        StringBuilder out = new StringBuilder();
        out.append(String.format("Players in the guild: %s:", this.name));

        for (Player player : roster){
            out.append(System.lineSeparator())
                    .append(player);
        }
        return out.toString();
    }


}
