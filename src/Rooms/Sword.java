package Rooms;
import Game.Runner;
import People.MainCharacter;
import Rooms.Room;
public class Sword extends Room{
    public Sword(int x, int y)
    {
        super(x,y);
    }

    @Override
    public void enterRoom(MainCharacter x)
    {
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);

    }
}
