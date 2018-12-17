package Rooms;

import People.MainCharacter;

public class Room {
    int xLoc,yLoc;
    boolean occupied = false;
    public Room(int x, int y)
    {
        xLoc = x;
        yLoc = y;
    }
    public int getxLoc()
    {
        return xLoc;
    }
    public int getyLoc()
    {
        return yLoc;
    }

    public void enterRoom(MainCharacter x)
    {
        System.out.println("You enter a room.");
        occupied = true;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
    }


    public void leaveRoom(MainCharacter x)
    {
        occupied = false;
    }

}
