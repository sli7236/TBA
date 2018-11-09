package Game;

import People.Person;
import Spots.Spot;

public class Library {
    Spot[][] map;

    public Library(Spot[][] map) { this.map = map; }

    public Library(int height, int width)
    {
        this.map = map;
    }

    public void addRoom(Spot spot, int row, int col)
    {
        map[row][col] = spot;
    }

    public void printBoard(Person player)
    {
        for(Spot[] i : map)
        {
            for (Spot j : i)
            {
                if (player.getxLoc() == j.getxLoc() && player.getyLoc() == j.getyLoc())
                {
                    System.out.print("[P]");
                }
                else
                {

                    System.out.print("[-]");
                }
            }
            System.out.println();
        }
    }
}
