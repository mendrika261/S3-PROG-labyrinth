package display;

import resource.Game;

import javax.swing.*;

public class GameInformation extends JPanel {
    Controller controller;
    Score score;

    public GameInformation(Game game) {
        this.setLayout(null);

        this.setScore(new Score(game));
        this.getScore().setBounds(20, 50, 160, 100);
        this.add(getScore());

        this.setController(new Controller());
        this.getController().setBounds(20, 180, 160, 100);
        this.add(getController());
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public Controller getController() {
        return controller;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public Score getScore() {
        return score;
    }
}
