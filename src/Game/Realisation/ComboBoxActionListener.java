package Game.Realisation;

import Game.Heroes.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class ComboBoxActionListener implements ActionListener {
    private GameComboBox comboBox;
    private Team team;
    private int indexBox;

    ComboBoxActionListener(GameComboBox gComboBox, Team team, int indexBox) {
        this.comboBox = gComboBox;
        this.team = team;
        this.indexBox = indexBox;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ArrayList<Hero> heroesTeam = new ArrayList<>();
        heroesTeam.add(new Warrior(team));
        heroesTeam.add(new Assassin(team, 5));
        heroesTeam.add(new Mage(team));
        heroesTeam.add(new Healer(team));
        heroesTeam.add(new Archer(team,8));
        heroesTeam.add(new Guardian(team));

        String x = Objects.requireNonNull(comboBox.getSelectedItem()).toString();

        if (team.size() <= indexBox) {
            for (Hero aHeroesTeam : heroesTeam) {
                if (aHeroesTeam.getName().equalsIgnoreCase(x)) {
                    if (findExistHero(aHeroesTeam)) {
                        comboBox.setSelectedIndex(0);
                        GameWindow.printText("В этой команде уже есть такой герой! Выберите другого.");
                        System.out.println("В этой команде уже есть такой герой! Выберите другого.");
                    } else {
                        team.add(aHeroesTeam);
                    }
                }
            }
        } else {
            for (Hero aHeroesTeam : heroesTeam) {
                if (aHeroesTeam.getName().equalsIgnoreCase(x)) {
                    if (findExistHero(aHeroesTeam)) {
                        if (!aHeroesTeam.getName().equals(team.get(indexBox).getName())) {
                            comboBox.setSelectedItem(team.get(indexBox).getName());
                            GameWindow.printText("В этой команде уже есть такой герой! Выберите другого.");
                            System.out.println("В этой команде уже есть такой герой! Выберите другого.");
                        }
                    } else {
                        team.set(indexBox, aHeroesTeam);
                    }
                }
            }
        }
    }

    private boolean findExistHero(Hero aHeroesTeam) {
        for (int i = 0; i < team.size(); i++) {
            if (team.get(i).getName().equals(aHeroesTeam.getName())) {
                return true;
            }
        }
        return false;
    }
}
