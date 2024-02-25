package display;

import resource.Game;

import javax.swing.*;

public class MyWindow extends JFrame {
    int caseDimension = 50;
    Field field;
    GameInformation gameInformation;

    public MyWindow(Game game) {
        /* window initialisation */
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(getCaseDimension()*game.getSizeX()+205, getCaseDimension()* game.getSizeY()+30);
        //this.setResizable(false);
        this.setTitle("Lab");
        this.setVisible(true);

        /* field of game */
        this.setField(new Field(game));
        getField().setBounds(0, 0, getCaseDimension()*game.getSizeX(), getCaseDimension()* game.getSizeY());
        this.add(getField());

        /* score of player */
        this.setGameInformation(new GameInformation(game));
        getGameInformation().setBounds(getCaseDimension()*game.getSizeX(), 0, 200, getCaseDimension()*game.getSizeY());
        this.add(getGameInformation());
    }
    public int getCaseDimension() {
        return caseDimension;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public Field getField() {
        return field;
    }

    public void setGameInformation(GameInformation gameInformation) {
        this.gameInformation = gameInformation;
    }

    public GameInformation getGameInformation() {
        return gameInformation;
    }
}
