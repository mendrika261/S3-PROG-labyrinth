package resource;

import display.Marker;
import display.Perso;
import listener.MouseMoveListener;

import java.awt.*;
import java.util.Vector;

public class Player extends Perso {
    int positionX;
    int positionY;
    int numOfMove;
    MouseMoveListener mouseMoveListener;
    Vector<Marker> markers = new Vector<>();

    public Player(Color color) {
        super(color);
    }


    public void setMarkers(Vector<Marker> markers) {
        this.markers = markers;
    }

    public Vector<Marker> getMarkers() {
        return markers;
    }

    public void addMarker(int x, int y) {
        this.getMarkers().add(new Marker(getColor()));

        getMarkers().lastElement().setGame(this.getGame());
        getMarkers().lastElement().place(x, y);
        this.getGame().getMyWindow().getField().add(getMarkers().lastElement());
    }

    public void removeMarker() {
        for(int i=0; i<getMarkers().size(); i++)
            this.getGame().getMyWindow().getField().remove(getMarkers().get(i));
        this.getMarkers().clear();
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public int getPositionX() {
        return positionX;
    }

    @Override
    public void place(int caseX, int caseY) {
        if(getGame().getMyWindow().getField().getCase(caseX, caseY) != null
            && !getGame().getMyWindow().getField().getCase(caseX, caseY).isBlock()) {
            super.place(caseX, caseY);
            this.setPositionX(caseX);
            this.setPositionY(caseY);
            addMove();
            addMarker(caseX, caseY);
        }
    }

    public void moveUp() {
        place(this.getPositionX(), this.getPositionY()-1);
    }

    public void moveDown() {
        place(this.getPositionX(), this.getPositionY()+1);
    }

    public void moveLeft() {
        place(this.getPositionX()-1, this.getPositionY());
    }

    public void moveRight() {
        place(this.getPositionX()+1, this.getPositionY());
    }

    public int getNumOfMove() {
        return numOfMove;
    }

    public void setNumOfMove(int numOfMove) {
        this.numOfMove = numOfMove;
    }

    public void resetMove() {
        this.setNumOfMove(0);
        getGame().getMyWindow().getGameInformation().getScore().update(getNumOfMove(), getGame().getPlayers().indexOf(this));

        this.removeMarker();
        getGame().getMyWindow().getField().repaint();
    }

    public void addMove() {
        this.setNumOfMove(getNumOfMove()+1);
        getGame().getMyWindow().getGameInformation().getScore().update(this.getNumOfMove(), getGame().getPlayers().indexOf(this));
    }

    public MouseMoveListener getMouseMoveListener() {
        return mouseMoveListener;
    }

    public void setMouseMoveListener(MouseMoveListener mouseMoveListener) {
        this.mouseMoveListener = mouseMoveListener;
        this.addMouseListener(getMouseMoveListener());
    }

}
