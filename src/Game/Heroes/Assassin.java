package Game.Heroes;

import Game.Realisation.GameWindow;
import Game.Realisation.Team;
import java.util.Random;

public class Assassin extends Hero {   //Класс лучник для создания конкретной реализации героя
    private int criticalHit;

    public Assassin(Team team, int crt) {
        super(team,"Убийца", 160, 160, 70, 0);
        Random random = new Random();
        this.criticalHit = random.nextInt(crt);
    }

    @Override
    public void hit(Hero hero) {
        // если герой не он сам, он может ударить
        if (!hero.equals(this)) {
            // если герой который бьет жив, он может ударить
            if (health > 0) {
                damageInfo(hero);
                if (criticalHit == 1) {
                    GameWindow.printText("Critical hit!");
                    System.out.println("Critical hit!");
                    hero.causeDamage(damage * 2);
                } else {
                    hero.causeDamage(damage);
                }
            }
        }
    }

    @Override
    public void healing(Team hero) {
        GameWindow.printText("Убийцы не умеют лечить!");
        System.out.println("Убийцы не умеют лечить!");
    }

}
