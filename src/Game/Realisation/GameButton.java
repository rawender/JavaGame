package Game.Realisation;

import javax.swing.*;

class GameButton extends JButton {
    Team teamBlue;
    Team teamRed;

    GameButton(String text, Team teamBlue, Team teamRed) {
        super(text);
        this.teamBlue = teamBlue;
        this.teamRed = teamRed;

        addActionListener(new ButtonActionListener(teamBlue, teamRed));
    }
}
