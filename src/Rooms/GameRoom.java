package Rooms;
import Game.Runner;
import People.MainCharacter;

public class NewRoom extends Room {
    public NewRoom(int x, int y)
    {
        super(x,y);
    }

    @Override
    public void enterRoom(MainCharacter object) {

        occupant = object;
        object.setxLoc(this.xLoc);
        object.setyLoc(this.yLoc);
        System.out.println("This is the game room! Play a game and you can win a prize.");
    }
}
