package listener;

import display.Controller;
import resource.Player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerListener implements ActionListener {
    Player player;
    Controller controller;

    public ControllerListener(Player player, Controller controller) {
        this.setPlayer(player);
        this.setController(controller);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == getController().getUp())
            getPlayer().moveUp();
        else if(actionEvent.getSource() == getController().getDown())
            getPlayer().moveDown();
        else if(actionEvent.getSource() == getController().getLeft())
            getPlayer().moveLeft();
        else if(actionEvent.getSource() == getController().getRight())
            getPlayer().moveRight();
        else if(actionEvent.getSource() == getController().getReset())
            getPlayer().resetMove();
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public Controller getController() {
        return controller;
    }
}
