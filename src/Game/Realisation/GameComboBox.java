package Game.Realisation;

import javax.swing.*;

class GameComboBox extends JComboBox {
    Team team;
    int indexBox;

    GameComboBox(String[] items, Team team, int indexBox) {
        super(items);
        this.team = team;
        this.indexBox = indexBox;

        addActionListener(new ComboBoxActionListener(this, team, indexBox));
    }
}
