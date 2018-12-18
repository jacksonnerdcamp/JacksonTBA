package Rooms;

import Game.Runner;
import People.MainCharacter;
import Rooms.Room;

public class GameRoom extends Room {
    private String roomName = "GameRoom";
    public GameRoom(int x, int y)
    {
        super(x,y);
    }

    @Override
    public void enterRoom(MainCharacter x)
    {
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        this.startGame();
    }
    //methods
    public boolean startGame()
    {
        System.out.println();
        int[] yourDice = new int[2];
        int[] npcDice = new int[2];
        yourDice[0] = (int)(Math.random() * 5 + 1);
        yourDice[1] = (int)(Math.random() * 5 + 1);
        npcDice[0] = (int)(Math.random() * 5 + 1);
        npcDice[1] = (int)(Math.random() * 5 + 1);

        System.out.println("Your Roll:");
        int[] setHand = yourDice;
        for(int c = 0; c < 2; c++)
        {
            for (int i = 0; i < 2; i++)
            {
                if (setHand[i] == 1)
                {
                    System.out.println("|     |");
                    System.out.println("|  o  |");
                    System.out.println("|     |");
                    System.out.println();
                }
                else if (setHand[i] == 2)
                {
                    System.out.println("|o    |");
                    System.out.println("|     |");
                    System.out.println("|    o|");
                    System.out.println();
                }
                else if (setHand[i] == 3)
                {
                    System.out.println("|o    |");
                    System.out.println("|  o  |");
                    System.out.println("|    o|");
                    System.out.println();
                }
                else if (setHand[i] == 4)
                {
                    System.out.println("|o   o|");
                    System.out.println("|     |");
                    System.out.println("|o   o|");
                    System.out.println();
                }
                else if (setHand[i] == 5)
                {
                    System.out.println("|o   o|");
                    System.out.println("|  o  |");
                    System.out.println("|o   o|");
                    System.out.println();
                }
                else if (setHand[i] == 6)
                {
                    System.out.println("|o   o|");
                    System.out.println("|o   o|");
                    System.out.println("|o   o|");
                    System.out.println();
                }
            }
            System.out.println("npc's roll:");
            setHand = npcDice;
        }
        if(yourDice[0] + yourDice[1] > npcDice[0] + npcDice[1])
        {
            System.out.println("You won! You now have the key to escape!");
            return true;
        }
        else if(yourDice[0] + yourDice[1] < npcDice[0] + npcDice[1])
        {
            System.out.println("You lost. Better luck next time.");
        }
        else
        {
            System.out.println("It's a tie! Rematching...");
            startGame();
        }
        return true;
    }
}
