package listener;

import display.Field;
import resource.Player;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FieldMouseListener implements MouseListener {
    Field field;
    Player player;

    public FieldMouseListener(Field field) {
        this.setField(field);
    }

    public FieldMouseListener(Player player) {
        this.setPlayer(player);
    }

    public void setField(Field field) {
        this.field = field;
    }

    public Field getField() {
        return field;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }



    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        int caseX = (int) (mouseEvent.getX()/50), caseY = (int) (mouseEvent.getY()/50);

        if(getPlayer() != null) {
            getPlayer().place(caseX, caseY);

            getPlayer().setSelected(false);
            getPlayer().getMouseMoveListener().setSelected();
            getPlayer().getGame().getMyWindow().getField().removeMouseListener(this);
        }

        if(mouseEvent.isShiftDown()) {
            if(getField().getCase(caseX, caseY).isBlock())
                getField().getCase(caseX, caseY).removeBlock();
            else
                getField().getCase(caseX, caseY).toBlock();
            getField().repaint();
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
