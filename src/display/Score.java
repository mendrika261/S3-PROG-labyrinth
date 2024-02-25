package display;

import resource.Game;
import resource.Player;

import javax.swing.*;
import java.awt.*;

public class Score extends JPanel {
    JLabel p1;
    JLabel p2;
    public Score(Game game) {
        this.setLayout(new BorderLayout());

        JLabel info = new JLabel("Nombre de pas", SwingConstants.CENTER);
        this.add(info, BorderLayout.NORTH);

        Font font = new Font(Font.MONOSPACED, Font.BOLD, 50);
        this.setP1(new JLabel());
        this.getP1().setFont(font);
        this.setP2(new JLabel());
        this.getP2().setFont(font);

        this.add(getP1(), BorderLayout.WEST);
        this.add(getP2(), BorderLayout.EAST);
    }

    public void setP1(JLabel p1) {
        this.p1 = p1;
    }

    public void setP2(JLabel p2) {
        this.p2 = p2;
    }

    public JLabel getP1() {
        return p1;
    }

    public JLabel getP2() {
        return p2;
    }

    public void update(int score, int indexOfPlayer) {
        if(indexOfPlayer==0)
            this.getP1().setText(String.valueOf(score));
        else if (indexOfPlayer==1) {
            this.getP2().setText(String.valueOf(score));
        }
    }
}
