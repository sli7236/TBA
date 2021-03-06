package Game;
import People.Person;
import Rooms.*;
import Items.Item;

import java.util.Scanner;

public class Runner {

    private static boolean gameOn = true;

    public static void main(String[] args) {
        Hallway[][] hallway = new Hallway[10][10];

        Board building = new Board(hallway);
        for (int x = 0; x< hallway.length; x++) {
            for (int y = 0; y < hallway[x].length; y++) {
                hallway[x][y] = new Hallway(x, y);
            }
        }

        Scanner in = new Scanner(System.in);
        System.out.println("What is your first name?");
        String first = in.nextLine();
        System.out.println("What is your last name?");
        String family = in.nextLine();
        System.out.println("Hi " + first + " " + family + ". Your objective is to escape Brooklyn Tech. Each time you move, your health decreases by 5 (because school slowly kills you). Good luck!");
        Person p = new Person(first, family, 0, 0, 100, 95, 3);

        //Create cafeteria
        hallway[5][5] = new Cafeteria(5, 5);

        //Create library
        hallway[6][7] = new Library(6, 7);

        //Create APCSA room
        hallway[3][1] = new APCSA(3, 1);

        //Create random room with chips
        int x = (int)(Math.random()*hallway.length);
        int y = (int)(Math.random()*hallway.length);
        hallway[x][y] = new Chips(x, y);

        //Create random room with an apple
        x = (int)(Math.random()*hallway.length);
        y = (int)(Math.random()*hallway.length);
        hallway[x][y] = new Apple(x, y);

        //Create random room with cookies
        x = (int)(Math.random()*hallway.length);
        y = (int)(Math.random()*hallway.length);
        hallway[x][y] = new Cookies(x, y);

        //Create random room with a book
        x = (int)(Math.random()*hallway.length);
        y = (int)(Math.random()*hallway.length);
        hallway[x][y] = new Book(x, y);

        //Create 1st WinningRoom
        x = (int)(Math.random()*hallway.length);
        y = (int)(Math.random()*hallway.length);
        hallway[x][y] = new WinningRoom(x, y);

        //Create 2nd WinningRoom
        x = (int)(Math.random()*hallway.length);
        y = (int)(Math.random()*hallway.length);
        hallway[x][y] = new WinningRoom(x, y);

        //Create 3rd WinningRoom
        x = (int)(Math.random()*hallway.length);
        y = (int)(Math.random()*hallway.length);
        hallway[x][y] = new WinningRoom(x, y);

        //Create 4th WinningRoom
        x = (int)(Math.random()*hallway.length);
        y = (int)(Math.random()*hallway.length);
        hallway[x][y] = new WinningRoom(x, y);

        hallway[0][0].enterRoom(p);
        building.printBoard(p);

        while(gameOn && p.getHealth() > 0 )
        {
            System.out.println("Where would you like to move? (Choose N, S, E, W)");
            String move = in.nextLine();
            if(validMove(move, p, hallway))
            {
                building.printBoard(p);
                System.out.println("Your coordinates: row = " + p.getxLoc() + " col = " + p.getyLoc());
                p.setHealth(-5);
                System.out.print("Health: " + p.getHealth() + ", ");
                System.out.print("GPA: " + p.getGPA() + ", ");
                System.out.print("Wealth: $" + p.getWealth() + " ");
                System.out.println();
                if (p.getHealth() <=0)
                {
                    System.out.println("You ran out of health!");
                    gameOff();
                }



            }
            else {
                System.out.println("Please choose a valid move.");
            }


        }
        in.close();
    }



    public static boolean validMove(String move, Person p, Hallway[][] map)
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
