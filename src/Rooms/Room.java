package Rooms;

import People.MainCharacter;

public class Room {
    boolean occupied = false;
    int xLoc,yLoc;

    public Room(int x, int y)
    {
        xLoc = x;
        yLoc = y;
    }

    /**
     * Method controls the results when a person enters this room.
     * @param x the Person entering
     */
    public void enterRoom(MainCharacter x)
    {
        System.out.println("You enter a plain old room");
        occupied = true;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
    }

    /**
     * Removes the player from the room.
     * @param x
     */
    public void leaveRoom(MainCharacter x)
    {
        occupied = false;
    }

}
