package display;

import listener.ControllerListener;
import resource.Player;

import javax.swing.*;
import java.awt.*;

public class Controller extends JPanel {
    JButton up;
    JButton down;
    JButton left;
    JButton right;
    JButton reset;

    public Controller() {
        this.setLayout(new BorderLayout());

        this.setUp(new JButton("Up"));
        this.setDown(new JButton("Down"));
        this.setLeft(new JButton("Left"));
        this.setRight(new JButton("Right"));
        this.setReset(new JButton("Reset"));

        this.add(getUp(), BorderLayout.NORTH);
        this.add(getDown(), BorderLayout.SOUTH);
        this.add(getRight(), BorderLayout.EAST);
        this.add(getLeft(), BorderLayout.WEST);
        this.add(getReset(), BorderLayout.CENTER);
    }

    public void setDown(JButton down) {
        this.down = down;
        this.getDown().setFocusable(false);
    }

    public void setRight(JButton right) {
        this.right = right;
        this.getRight().setFocusable(false);
    }

    public void setUp(JButton up) {
        this.up = up;
        this.getUp().setFocusable(false);
    }

    public void setLeft(JButton left) {
        this.left = left;
        this.getLeft().setFocusable(false);
    }

    public JButton getDown() {
        return down;
    }

    public JButton getLeft() {
        return left;
    }

    public JButton getRight() {
        return right;
    }

    public JButton getUp() {
        return up;
    }

    public void setReset(JButton reset) {
        this.reset = reset;
        this.getReset().setFocusable(false);
    }

    public JButton getReset() {
        return reset;
    }
}
