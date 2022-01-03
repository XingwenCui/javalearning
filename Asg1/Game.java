package Asg1;
import java.util.Scanner;
/**
 * This class Game is used to play the Javaio game and contain the game functions which will be used in the game
 * You can creat an object and call gameStart() method to play Javaio
 *
 * @author Xingwen Cui
 * @version 2021.11.20
 */
public class Game
{
    private Player player;  // The Player object in the game
    private RNG rng;   // The RNG object in the game

    /**
     * Default Constructor for objects of class Game
     */
    public Game()
    {
        player = new Player();
        rng = new RNG();
    }

    /**
     * Non-default Constructor for objects of class Game
     *
     * @param newPlayer         a Player input to pass the new Player object 
     * @param newRng            a RNG input to pass the new Player object
     */
    public Game(Player newPlayer, RNG newRng)
    {
        player = newPlayer;
        rng = newRng;
    }

    /**
     * Method dice to implement the rolling dice function and print sentence
     *
     */
    private void dice()
    {
        int length = rng.generateRandomNumber(6,1);
        player.updatePosition(length);
        System.out.println("You rolled " + length + ", move " + length + " distance.");
    }

    /**
     * Method displayState to display current states of the objects of class game
     *
     */
    public void displayState()
    {
        System.out.println(player);
        System.out.println(rng);
    }

    /**
     * Method encounter to to implement the option when Javaio choose encounter
     *
     */
    private void encounter()
    {
        int occur = rng.generateRandomNumber(5,1);
        if (occur == 1)
            System.out.println("Nothing happened, keep going.");
        else if (occur == 2)
            findCoins();
        else if (occur == 3)
            findMushroom();
        else if (occur == 4)
            findJump();
        else
            findTurtle();
    }

    /**
     * Method findCoinsto to implement the case when Javaio find the random number of coins
     *
     */
    private void findCoins()
    {
        int coins = rng.generateRandomNumber(10,1);
        int yourCoins = player.getCoins() + coins;
        player.setCoins(yourCoins);
        System.out.println("Congratulate, you got " + coins + "coins!");
        System.out.println("Now you have " + yourCoins + " coins");
    }

    /**
     * Method findJump to implement the case when Javaio find a jump prize
     *
     */
    private void findJump()
    {
        int jumps = player.getJumps() + 1;
        player.setJumps(jumps);
        System.out.println("Congratuate! You add a jump.");
        System.out.println("Now you have "+ jumps + " chance");
    }

    /**
     * Method findMushroom to implement the case when Javaio find a mushroom
     *
     */
    private void findMushroom()
    {
        System.out.println("You encounter a mushroom!");
        if (!player.getStatus())
        {
            player.setStatus(true);
            System.out.println("Wow, you eat the mushroom, supersized!");
        }
        else
        {
            System.out.println("But you have been supersized.");
            System.out.println("You can't eat it. Keep going！");
        }
    }

    /**
     * Method findTurtle to implement the case when Javaio meet a turtle
     *
     */
    private void findTurtle()
    {
        while (true)
        {
            int playerNum = rng.generateRandomNumber(100,1);
            int turtleNum = rng.generateRandomNumber(100,1);
            System.out.println("Dangerous! Your encounter a turtle!");
            System.out.println("Your number is " + playerNum);
            System.out.println("Turtle number is " + turtleNum);
            if (playerNum > turtleNum)
            {
                System.out.println("Great! You defeat the turtle, keep going!");
                break;
            }
            else if (playerNum < turtleNum)
            {
                System.out.println("Oh no, you are defeated by the turtle");
                if (player.getStatus())
                {
                    player.setStatus(false);
                    System.out.println("You don't lose your heart, but you are not supersized now...");
                    break;
                }
                else
                {
                    player.updateHearts(-1);
                    System.out.println("No! You lose one Hearts. Now you have" + player.getHearts() + "/3 hearts.");
                    if (player.getHearts() > 0)
                    {
                        System.out.println("And you lose your " + player.getCoins() + " coins, NO!");
                        player.setCoins(0);
                    }
                    break;
                }
            }
            else
            {
                System.out.println("You and turtle have the same number, play again.");
                pressEnter();
            }
        }
    }

    /**
     * Method to show the mannual that how to play the game
     */
    private void gameHandbook()
    {
        System.out.println(player.getName() + ", welcome to my Javaio world!");
        System.out.println("Your goal is to run 100 steps from the start to the end.");
        System.out.println("You have 3 hearts when you start the game. You can roll dice to determine how far you will go.");
        System.out.println("And you can choose encounter or jump after one jump. remember, you have 3 jumps.");
        System.out.println("Remember, you have 3 jumps at the beginning when you jump, you won't enconter anything.");
        System.out.println("When you choose encounter, you may find coins, jumps, mushroom and turtle.");
        System.out.println("When you encounter turtle, you should fight. If you defeat, you will lose 1 heart and all coins");
        System.out.println("When your heart become 0, the game will over and you lose.");
        System.out.println("But when you passed over 100 steps, you will win the game.");
        System.out.println("So let's start! Good Luck!");
        pressEnter();
        System.out.print('\u000C');
    }

    /**
     * Method gameOver to implement the function that judge the Javaio's heart when game end
     *
     */
    private void gameOver()
    {   
        System.out.print('\u000C');
        if (player.getHearts() > 0)
        {
            player.setPosition(100);
            System.out.println("Winner! " + player.getName() + " win!");
            player.finalState();
        }
        else
        {
            System.out.println("You lose. Don't be sad :)");
            player.finalState();
        }
    }

    /**
     * Method gameStart to play the game and this is the main method in class to play the game
     *
     */
    public void gameStart()
    {
        this.player = new Player();
        System.out.println("Welcome to Javaio");
        Scanner scan = new Scanner(System.in);
        player.setNewName();
        gameHandbook();
        while (player.getPosition() <= 100 && player.getHearts() > 0)
        {
            player.displayState();
            System.out.println("##########################################");
            dice();
            while (true)
            {
                if (player.getJumps() > 0)
                {
                    System.out.println("##########################################");
                    System.out.println("Enter 1 to encounter, enter 2 to jump.");
                    String option = scan.nextLine();
                    if (option.equals("1"))
                    {
                        encounter();
                        break;
                    }
                    else if(option.equals("2"))
                    {
                        jump();         
                        break;
                    }
                    else
                        System.out.println("You can only press 1 or 2, please enter again.");
                }
                else
                {   
                    encounter();
                    break;
                }
            }
            if (player.getHearts() == 0)
                break;
            pressEnter();
            System.out.print('\u000C');
        }
        gameOver();
    }

    /**
     * Method getPlayer to get the Game Player object
     *
     * @return      the Player object
     */
    public Player getPlayer()
    {
        return player;
    }

    /**
     * Method getRng to get the Game RNG object
     *
     * @return      the RNG object
     */
    public RNG getRng()
    {
        return rng;
    }

    /**
     * Method jump to implement jump option for Javio
     *
     */
    private void jump()
    {
        player.setJumps(player.getJumps() - 1);
        System.out.println("You choose the jump option.");
    }

    /**
     * Method pressEnter to implement a standard "Enter" tool when the Game running
     *
     */
    private void pressEnter()
    {
        Scanner enter = new Scanner(System.in);
        System.out.println("Press enter to continue.");
        enter.nextLine();
    }

    /**
     * Method setPlayer to set a new Player for Game object
     *
     * @param player    a new Player object to set
     */
    private void setPlayer(Player player)
    {
        this.player = player;
    }

    /**
     * Method setRng to set a new RNG for Game object
     *
     * @param rng       a new RNG object to set
     */
    private void setRng(RNG rng)
    {
        this.rng = rng;
    }
}