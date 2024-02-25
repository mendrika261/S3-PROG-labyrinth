package display;

import resource.Game;

import javax.swing.*;
import java.awt.*;

public class Perso extends JPanel {
    Game game;
    Color color;
    boolean selected;

    public Perso(Color color) {
        this.setColor(color);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(getColor());
        if(selected)
            g.drawOval(getWidth()/4, getHeight()/4, getWidth()/2, getHeight()/2);
        else
            g.fillOval(getWidth()/4, getHeight()/4, getWidth()/2, getHeight()/2);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public int caseXToPixel(int caseX) {
        return caseX*getGame().getCaseDimension();
    }

    public int caseYToPixel(int caseY) {
        return caseY*getGame().getCaseDimension();
    }

    public void place(int caseX, int caseY) {
        this.setBounds(caseXToPixel(caseX), caseYToPixel(caseY), getGame().getCaseDimension(), getGame().getCaseDimension());
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        this.getGame().getMyWindow().getField().repaint();
    }
}
