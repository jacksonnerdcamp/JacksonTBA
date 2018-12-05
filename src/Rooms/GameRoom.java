package Rooms;

import Game.Runner;
import People.MainCharacter;
import Rooms.Room;

public class GameRoom extends Room {
    public GameRoom(int x, int y)
    {
        super(x,y);
    }
    @Override
    public void enterRoom(MainCharacter object) {
        occupied = true;
        object.setxLoc(this.xLoc);
        object.setyLoc(this.yLoc);
        System.out.println("This is the game room! Play a game and you can win a prize.");
    }
}
