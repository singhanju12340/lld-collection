package interview.TestApplication.kotak.service;

import interview.TestApplication.kotak.model.Player;
import interview.TestApplication.kotak.model.Ship;

import java.util.List;

/**
 * @author anju
 * @created on 20/03/25 and 10:23 AM
 */
public interface BattleShip {

    void addShip(int x, int y, int ax, int by);
    void addPlayer(Player player);
    void printBoard();


    boolean checkIfAllShipsDistroyed(Player player);

}
