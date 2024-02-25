package resource;

import display.Case;
import display.Marker;

import java.awt.*;
import java.util.Vector;

public class Main {
    public static void main(String[] args) throws Exception {
        Vector<Player> players = new Vector<>();
        players.add(new Player(Color.BLUE));
        players.add(new Player(Color.RED));

        Game game = new Game(10, 10, players);
    }
}
