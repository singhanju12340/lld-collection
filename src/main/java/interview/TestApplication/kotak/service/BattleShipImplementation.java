package interview.TestApplication.kotak.service;

import interview.TestApplication.kotak.model.CordinatePair;
import interview.TestApplication.kotak.model.Player;
import interview.TestApplication.kotak.model.Ship;

import java.util.List;

/**
 * @author anju
 * @created on 20/03/25 and 10:29 AM
 */
public class BattleShipImplementation implements BattleShip{
    List<Player> players;


    char[][] board;
    int boardSize;

    boolean gameStarted;


    public BattleShipImplementation(List<Player> players, int boardSize) {
        this.players = players;
        this.board = new char[boardSize][boardSize];
        this.boardSize = boardSize;
        gameStarted = false;
    }


    public void initGame(){
        gameStarted = true;
        int playerIndex = 0;

        Player currentPlayer = players.get(playerIndex);
        Player opponentPlayer = players.get(playerIndex^1);
        //add ships

        while(true){

            CordinatePair fireCordinate = currentPlayer.playNext();

            if(opponentPlayer.checkIfHit(fireCordinate)) // check and mark distrooyed
                updateBoard(fireCordinate, 'X');
            printBoard();
            if(checkIfAllShipsDistroyed(opponentPlayer)){
                System.out.println("Game Over Player Win "+ currentPlayer.getName());
                return;
            }
            // get next player after end of this game
            opponentPlayer = currentPlayer;
            currentPlayer = players.get(playerIndex^1);
        }
    }

    public void addShip(int x, int y, int bx, int by) {
        Ship shipA = new Ship("SH"+x+":"+y, x,y,0);
        Ship shipB = new Ship("SH"+bx+":"+by, bx,by,0);
        board[x][y] = 'A';
        board[bx][by] = 'B';

        players.get(0).addShip(shipA);
        players.get(1).addShip(shipB);
    }

    @Override
    public void addPlayer(Player player) {
        players.add(player);
    }

    @Override
    public void printBoard() {
        for(int i=0;i<boardSize;i++){
            for(int j=0; j<boardSize;j++){
                System.out.print(board[i][j]);
            }
            System.out.println("");

        }

        System.out.println("-------");

    }

    public void updateBoard(CordinatePair pair, char updateSym) {
        board[pair.getX()][pair.getY()] = updateSym;
    }

    @Override
    public boolean checkIfAllShipsDistroyed(Player player) {
        for (Ship ship:player.getShips()) {
            if(!ship.isDistroyed())
                return false;
        }
        return true;
    }
}
