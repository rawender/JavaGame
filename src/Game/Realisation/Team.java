package Game.Realisation;

import Game.Heroes.Hero;
import java.util.ArrayList;

public class Team {
    private String teamName;
    private ArrayList<Hero> heroesTeam;
    private GameWindow game;

    public Team( String teamName, GameWindow game) {
        this.teamName = teamName;
        this.heroesTeam = new ArrayList <>();
        this.game = game;
    }

    public GameWindow getGame() {
        return game;
    }

    public String getTeamName() {
        return teamName;
    }

    void add(Hero hero) {
        heroesTeam.add(hero);
    }

    void clear() {
        heroesTeam.clear();
    }
    public int size() {
        return heroesTeam.size();
    }

    public Hero get(int index) {
        return heroesTeam.get(index);
    }

    void set(int index, Hero hero) {
        heroesTeam.set(index, hero);
    }

    int teamDeadCount() {
        int count = 0;
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getHealth() <= 0) {
                count++;
            }
        }
        return count;
    }
}
