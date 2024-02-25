package listener;

import resource.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardControllerListener implements KeyListener {
    Player player;

    public KeyboardControllerListener(Player player) {
        this.setPlayer(player);
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        if(keyEvent.getKeyChar() == 'Z')
            getPlayer().moveUp();
        else if(keyEvent.getKeyChar() == 'S')
            getPlayer().moveDown();
        else if(keyEvent.getKeyChar() == 'Q')
            getPlayer().moveLeft();
        else if(keyEvent.getKeyChar() == 'D')
            getPlayer().moveRight();
        else if(keyEvent.getKeyChar() == 'R')
            getPlayer().resetMove();
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
