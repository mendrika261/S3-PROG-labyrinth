package display;

import listener.FieldMouseListener;
import listener.MouseMoveListener;
import resource.Game;

import javax.swing.*;
import java.awt.*;

public class Field extends JPanel {
    Case[][] cases;
    int caseDimension = 50;

    public Field(Game game) {
        this.setLayout(null);
        this.setCases(game.getSizeX(), game.getSizeY());

        this.addMouseListener(new FieldMouseListener(this));
    }

    public void setCases(int sizeX, int sizeY) {
        this.cases = new Case[sizeY][sizeX];
        for(int y=0; y<sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                this.cases[y][x] = new Case();
                this.getCase(x, y).setBounds(getCaseDimension()*x, getCaseDimension()*y, getCaseDimension(), getCaseDimension());
                this.add(this.getCase(x, y));
            }
        }
    }

    public Case[][] getCases() {
        return cases;
    }

    public Case getCase(int x, int y) {
        if(x>=0 && x<getCases()[0].length && y>=0 && y<getCases().length)
            return this.cases[y][x];
        return null;
    }

    public int getCaseDimension() {
        return caseDimension;
    }
}
