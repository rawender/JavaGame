package Game.Heroes;

import Game.Realisation.GameWindow;
import Game.Realisation.Team;

public class Mage extends Hero {   //Класс маг для создания конкретной реализации героя

    public Mage(Team team) {
        super(team,"Маг", 80, 80, 100, 0);
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
        GameWindow.printText("Маги не умеют лечить!");
        System.out.println("Маги не умеют лечить!");
    }
}
