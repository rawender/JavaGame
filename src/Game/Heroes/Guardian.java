package Game.Heroes;

import Game.Realisation.GameWindow;
import Game.Realisation.Team;

public class Guardian extends Hero {   //Класс защитник для создания конкретной реализации героя

    public Guardian(Team team) {
        super(team, "Защитник", 200, 200, 50, 0);
    }

    @Override
    public void hit(Hero hero) {
        // если герой не он сам, он может ударить
        if (!hero.equals(this)) {
            // если герой который бьет жив, он может ударить
            if (health > 0) {
                damageInfo(hero);
                hero.causeDamage(damage);
            }
        }
    }

    @Override
    public void healing(Team hero) {
        GameWindow.printText("Защитники не умеют лечить!");
        System.out.println("Защитники не умеют лечить!");
    }
}
