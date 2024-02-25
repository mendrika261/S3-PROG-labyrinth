package listener;

import resource.Player;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseMoveListener implements MouseListener {
    Player player;
    boolean selected;
    FieldMouseListener destination;

    public MouseMoveListener(Player player) {
        this.setPlayer(player);
        this.setDestination(new FieldMouseListener(getPlayer()));
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setDestination(FieldMouseListener destination) {
        this.destination = destination;
    }

    public FieldMouseListener getDestination() {
        return destination;
    }

    public void setSelected() {
        selected = !selected;
    }

    public boolean isSelected() {
        return selected;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if(!isSelected()) {
            getPlayer().getGame().getMyWindow().getField().addMouseListener(getDestination());
            getPlayer().setSelected(true);
            setSelected();
        } else {
            getPlayer().getGame().getMyWindow().getField().removeMouseListener(getDestination());
            getPlayer().setSelected(false);
            setSelected();
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
