package interview.TestApplication.kotak.service;

import interview.TestApplication.kotak.model.Player;
import interview.TestApplication.kotak.model.Ship;
import org.apache.logging.log4j.core.util.CloseShieldOutputStream;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anju
 * @created on 20/03/25 and 10:31 AM
 */
public class BattleShipDemo {

    public static void main(String[] args) {

        int boardSize = 4;

        FireStrategy fireStrategyA = new RandomFireStrategy(boardSize, 0, boardSize/2-1);
        FireStrategy fireStrategyB = new RandomFireStrategy(boardSize,  boardSize/2, boardSize-1);

        Player playerA = new Player("ShipA" , fireStrategyA);
        Player playerB = new Player("ShipB", fireStrategyB);
        List<Player> playerList = new ArrayList<>();
        playerList.add(playerA);
        playerList.add(playerB);

        BattleShipImplementation battleShip = new BattleShipImplementation(playerList, boardSize);

        battleShip.addShip(0,1,2,3);

        battleShip.printBoard();

//        battleShip.addShip(2,1,0,3);
//
//        battleShip.printBoard();


        battleShip.initGame();


    }


}
