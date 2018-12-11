package Game;

import People.MainCharacter;
import Rooms.GameRoom;
import Rooms.Room;

import java.util.Scanner;

public class Runner {
    private static boolean gameOn = true;

    public static void main(String[] args)
    {
        Room[][] building = new Room[5][5];

        //Fill the building with normal rooms
        for (int x = 0; x<building.length; x++)
        {
            for (int y = 0; y < building[x].length; y++)
            {
                building[x][y] = new Room(x,y);
            }
        }


        //Create a random GameRoom.
        GameRoom pokerRoom = new GameRoom((int)(Math.random() * 5),(int)(Math.random() * 5));
        System.out.println(pokerRoom.getyLoc());
        System.out.println(pokerRoom.getxLoc());
        //Setup player 1 and the input scanner
        String firstName;
        String lastName;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter first name: ");
        firstName = in.nextLine();
        System.out.println("Enter your last name: ");
        lastName = in.nextLine();
        System.out.println("Hi, " + firstName + " " + lastName + ", type Start to begin");
        in.nextLine();
        People.MainCharacter player1 = new MainCharacter(firstName, lastName, 0,0);
        building[0][0].enterRoom(player1);
        while(gameOn)
        {
            System.out.println("Where would you like to move? (Choose N, S, E, W)");
            String move = in.nextLine();
            if(validMove(move, player1, building))
            {
                //this is the method for printing a board.
                int n = 0;
                for(int i = 0; i < building[i].length - 1; i++)
                {
                    while(n < building.length)
                    {
                        if(i == player1.getxLoc() && n == player1.getyLoc())
                        {
                            System.out.print("[p1]");
                        }
                        else if(i == pokerRoom.getxLoc() && n == pokerRoom.getyLoc())
                        {
                            System.out.print("[pr]");
                        }
                        else
                        {
                            System.out.print("[  ]");
                        }
                        n++;
                    }
                    n = 0;
                    System.out.println();
                }
                System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc());

            }
            else {
                System.out.println("Please choose a valid move.");
            }


        }
        in.close();
    }

    /**
     * Checks that the movement chosen is within the valid game map.
     * @param move the move chosen
     * @param p person moving
     * @param map the 2D array of rooms
     * @return
     */
    public static boolean validMove(String move, MainCharacter p, Room[][] map)
    {
        move = move.toLowerCase().trim();
        switch (move) {
            case "n":
                if (p.getxLoc() > 0)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()-1][p.getyLoc()].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }
            case "e":
                if (p.getyLoc()< map[p.getyLoc()].length -1)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()][p.getyLoc() + 1].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }

            case "s":
                if (p.getxLoc() < map.length - 1)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()+1][p.getyLoc()].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }

            case "w":
                if (p.getyLoc() > 0)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()][p.getyLoc()-1].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }
            default:
                break;

        }
        return true;
    }
    public static void gameOff()
    {
        gameOn = false;
    }



}
