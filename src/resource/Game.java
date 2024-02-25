package resource;

import display.Controller;
import display.MyWindow;
import listener.ControllerListener;
import listener.KeyboardControllerListener;
import listener.MouseMoveListener;

import java.util.Vector;

public class Game {
    MyWindow MyWindow;
    int sizeX;
    int sizeY;
    int caseDimension=50;
    Vector<Player> players = new Vector<>();

    public Game(int sizeX, int sizeY, Vector<Player> players) {
        this.setSizeX(sizeX);
        this.setSizeY(sizeY);

        this.setPlayers(players);
        this.setMyWindow(new MyWindow(this));
        this.setPlayersField();

        int x, y;
        for(int i=0; i<10; i++) {
             x = (int) (Math.random()*10);
             y = (int) (Math.random()*10);
             if(getMyWindow().getField().getCase(x, y) != null)
                 getMyWindow().getField().getCase(x, y).toBlock();
        }

    }

    public void setMyWindow(display.MyWindow myWindow) {
        MyWindow = myWindow;
    }

    public display.MyWindow getMyWindow() {
        return MyWindow;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public int getSizeY() {
        return sizeY;
    }

    public int getCaseDimension() {
        return caseDimension;
    }

    public Vector<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Vector<Player> players) {
        this.players = players;
        for(int i=0; i<getPlayers().size(); i++) {
            this.getPlayers().get(i).setGame(this);
        }
    }

    public void setPlayersField() {
        for(int i=0; i<getPlayers().size(); i++) {
            this.getMyWindow().getField().add(this.getPlayers().get(i));
            this.getPlayers().get(i).place(0, 0);
            this.getPlayers().get(i).resetMove();
            this.getPlayers().get(i).setMouseMoveListener(new MouseMoveListener(getPlayers().get(i)));
        }

        //getMyWindow().getGameInformation().getController().setPlayer(getPlayers().get(0));
        getMyWindow().addKeyListener(new KeyboardControllerListener(getPlayers().get(1)));
        Controller c = getMyWindow().getGameInformation().getController();
        c.getUp().addActionListener(new ControllerListener(getPlayers().get(0), c));
        c.getDown().addActionListener(new ControllerListener(getPlayers().get(0), c));
        c.getLeft().addActionListener(new ControllerListener(getPlayers().get(0), c));
        c.getRight().addActionListener(new ControllerListener(getPlayers().get(0), c));
        c.getReset().addActionListener(new ControllerListener(getPlayers().get(0), c));

    }
}
