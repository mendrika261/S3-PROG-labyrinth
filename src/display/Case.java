package display;

import javax.swing.*;
import java.awt.*;

public class Case extends JPanel {
    boolean isBlock;
    public Case() {
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawRect(0, 0, getWidth()-1, getHeight()-1);
        if(isBlock)
            g.fillRect(0, 0, getWidth()-1, getHeight()-1);
    }

    public void toBlock() {
        this.isBlock = true;
        this.repaint();
    }

    public void removeBlock() {
        this.isBlock = false;
        this.repaint();
    }

    public boolean isBlock() {
        return isBlock;
    }
}
