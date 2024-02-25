package display;

import java.awt.*;

public class Marker extends Perso {

    public Marker(Color color) {
        super(color);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(getColor());
        g.fillOval(getWidth()/3, getHeight()/3, getWidth()/3, getHeight()/3);
    }
}
