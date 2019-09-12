package Game.Realisation;

import Game.Heroes.Healer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ButtonActionListener implements ActionListener {
    private Team team1;
    private Team team2;

    private Random random = new Random();

    ButtonActionListener(Team teamBlue, Team teamRed) {
        this.team1 = teamBlue;
        this.team2 = teamRed;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GameWindow.clearText();
        // выбираем кто будет первый ходить
        if (team1.size() == 3 && team2.size() == 3) {
            int x = random.nextInt(2);
            do {
                if (x == 0) {
                    roundFight(team1, team2);
                    x = 1;
                    GameWindow.printText("---------------");
                    System.out.println("---------------");
                } else {
                    roundFight(team2, team1);
                    x = 0;
                    GameWindow.printText("---------------");
                    System.out.println("---------------");
                }
            } while (!checkWin(team1, team2));

            for (int i = 0; i < team1.size(); i++) {
                team1.get(i).info();
            }

            for (int i = 0; i < team2.size(); i++) {
                team2.get(i).info();
            }
            GameWindow.printText("---------------");
            System.out.println("---------------");
            GameWindow.clearComboBox();
            team1.clear();
            team2.clear();
        } else {
            GameWindow.printText("Соберите команды!");
            System.out.println("Соберите команды!");
        }
    }

    private void roundFight(Team atc, Team def) {
        GameWindow.printText("Очередь команды " + atc.getTeamName() + ".");
        System.out.println("Очередь команды " + atc.getTeamName() + ".");
        // проходим по всем участникам команды
        for (int i = 0; i < atc.size(); i++) {
            // если целитель, то он лечит
            if (atc.get(i) instanceof Healer) {
                atc.get(i).healing(atc);
            // если персонаж не целитель, то он может ударить
            } else if (def.teamDeadCount() == 3) {
                // если у всех героев команды противников не осталось здоровья, прерываем бой
                break;
            } else {
                // бьем рандомного противника
                int randomTarget;
                do {
                    randomTarget = random.nextInt(3);
                } while (def.get(randomTarget).getHealth() <= 0);
                atc.get(i).hit(def.get(randomTarget));
            }
        }
    }

    private boolean checkWin(Team team1, Team team2) {
        boolean result = false;
        if (team1.teamDeadCount() == team1.size()) {
            result = true;
            GameWindow.printText("Победили " + team2.getTeamName());
            System.out.println("Победили " + team2.getTeamName());
        } else if (team2.teamDeadCount() == team2.size()) {
            result = true;
            GameWindow.printText("Победили " + team1.getTeamName());
            System.out.println("Победили " + team1.getTeamName());
        }
        return result;
    }
}
