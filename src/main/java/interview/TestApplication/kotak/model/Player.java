package interview.TestApplication.kotak.model;

import interview.TestApplication.kotak.service.FireStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anju
 * @created on 20/03/25 and 10:24 AM
 */
public class Player {
    String name;
    List<Ship> ships;
    FireStrategy fireStrategy;

    public Player(String name,FireStrategy fireStrategy) {
        this.name = name;
        this.fireStrategy = fireStrategy;
    }




    public CordinatePair playNext(){
        return fireStrategy.fire();
    }

    public boolean checkIfHit(CordinatePair pair){
        for (Ship ship:ships) {
            if(ship.x == pair.x && ship.y == pair.y){
                System.out.println("Opponent ship is hit at cordinate x:y "+ pair.x+ ":"+ pair.x);
                ship.isDistroyed = true;
                return true;
            }
        }
        System.out.println("Fire is miss");
        return false;
    }

    public void addShip(Ship shipA) {
        if(ships == null)
            ships = new ArrayList<>();
        ships.add(shipA);
    }

    public String getName() {
        return name;
    }

    public List<Ship> getShips() {
        return ships;
    }





}
