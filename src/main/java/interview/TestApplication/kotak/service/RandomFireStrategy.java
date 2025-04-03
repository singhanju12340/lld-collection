package interview.TestApplication.kotak.service;

import interview.TestApplication.kotak.model.CordinatePair;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author anju
 * @created on 20/03/25 and 10:27 AM
 */
public class RandomFireStrategy implements FireStrategy{
    Set<CordinatePair> alreadyFired;
    int minX;  // N/2
    int maxX;
    int maxRange; // N
    Random random = new Random();

    public RandomFireStrategy(int maxRange,int minX,  int maxX) {
        alreadyFired= new HashSet<>();
        this.maxRange = maxRange;
        this.minX = minX;
        this.maxX = maxX;
    }

    @Override
    public CordinatePair fire() {
        int x = random.nextInt((maxX - minX) + 1) + maxX;
        int y = random.nextInt(maxRange);
        CordinatePair cordinatePair = new CordinatePair(x, y);
        while(alreadyFired.contains(cordinatePair)){
            x = random.nextInt((maxX - minX) + 1) + maxX;
            y = random.nextInt(maxRange);
            cordinatePair = new CordinatePair(x, y);
        }
        alreadyFired.add(cordinatePair);
        return cordinatePair;
    }
}
