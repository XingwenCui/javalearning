import java.util.Scanner;
/**
 * This class Player is used to create a player with some attributes and contain methods to change these attributes
 *
 * @author Xingwen Cui
 * @version 2021.11.20
 */
public class Player
{   
    private String name; // The name of the player
    private int coins; // The total coins collected in the game
    private int position; // The position of the player on the field
    private boolean status; // Determines if the player is supersized or not
    private int hearts; // the number of hearts the player has;
    private int jumps; // the number of jumps the player has;
    
    /**
     * Default Player Constructor for objects of class Player
     */
    public Player()
    {
        name = "";
        coins = 0;
        position = 0;
        status = false;
        hearts = 3;
        jumps = 3;
    }
    
    /**
     * Non-default Player Constructor for objects of class Player
     *
     * @param name      an String input to pass the player's name of the Player
     * @param coins     an integer input to pass the player's coins of the Player
     * @param position  an integer input to pass the player's position of the Player
     * @param status    an boolean input to pass the player's status of the Player
     * @param hearts    an integer input to pass the player's hearts of the Player
     * @param jumps     an integer input to pass the player's jumps of the Player    
     */
    public Player(String name, int coins, int position, boolean status, int hearts, int jumps)
    {
        this.name = name;
        this.coins = coins;
        this.position = position;
        this.status = status;
        this.hearts = hearts;
        this.jumps = jumps;
    }

    /**
     * Method displayState to display the state of the Player objects 
     *
     */
    public void displayState()
    {
        System.out.println("Game states:");
        System.out.println("Current player is " + name);
        if (status)
            System.out.println("Javio is Supersize! Brave!");
        else
            System.out.println("Javio is normal size. Let's find the mushroom!");
        System.out.println("Javaio has: " + coins + " coins.");
        System.out.println("Javaio has " + hearts + "/3 hearts now.");
        System.out.println("Javaio has " + jumps + "/3 jumps now.");
        System.out.println("Javaio has move forward " + position + " length.");
    }
    
    /**
     * Method finalState to display the final state when the game is over of the Player objects
     *
     */
    public void finalState()
    {
        System.out.println("Javaio walked " + position + " tiles.");
        System.out.println("You left " + hearts + "/3 hearts.");
        System.out.println("You used " + jumps + "/3 jumps.");
        System.out.println("You collected " + coins + " coins totally.");        
        System.out.println("Hope you will play again later " + name + " :)");
    }
    
    /**
     * Method getCoins to get the object's current coins 
     *
     * @return      the coins which the player currently have
     */
    public int getCoins()
    {
        return coins;
    }

    /**
     * Method getHearts to get the object's current hearts left
     *
     * @return      the hearts which the player currently have
     */
    public int getHearts()
    {
        return hearts;
    }

    /**
     * Method getJumps to get the object's current jumps left
     *
     * @return      the jumps which the player currently have
     */
    public int getJumps()
    {
        return jumps;
    }
    
    /**
     * Method getName to get the object's current name
     *
     * @return      the name which the player currently is
     */
    public String getName()
    {
        return name;
    }
   
    /**
     * Method getPosition to get the object's current position
     *
     * @return      the position how long the player currently has passed
     */
    public int getPosition()
    {
        return position;
    }

    /**
     * Method getStatus to get the object's current status
     *
     * @return      the status what the player is
     */
    public boolean getStatus()
    {
        return status;
    }
    
    /**
     * Method isStringLetter to judge the input String is only composed by letter 
     *
     * @param str       a String input pass the player's name
     * @return       whether the string is only composed by letter or not
     */
    public boolean isStringLetter(String str)
    {
        for (int i = 0; i < str.length(); i++)
        {
            if (!Character.isLetter(str.charAt(i)))
                return false;
        }
        return true;
    }
    
    /**
     * Method setCoins to modify the object's coins
     *
     * @param coins     an integer input to pass the new coins of the player
     */
    public void setCoins(int coins)
    {
        this.coins = coins;
    }

    /**
     * Method setHearts to modify the object's hearts
     *
     * @param hearts    an integer input to pass the new hearts of the player
     */
    public void setHearts(int hearts)
    {
        this.hearts = hearts;
    }

    /**
     * Method setJumps to modify the object's jumps
     *
     * @param jumps     an integer input to pass the new jumps of the player
     */
    public void setJumps(int jumps)
    {
        this.jumps = jumps;
    }
    
    /**
     * Method setName to modify the object's name
     *
     * @param name      an String input to pass the new name of the player
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * Method setNewName to modify the object's name specially used for game
     *
     */
    public void setNewName()
    {
        Scanner scan = new Scanner(System.in);
        while (true)
        {
            System.out.println("Please enter your name in 3 - 12 chars and the name can only contain characters.");
            String name = scan.nextLine().replace(" ","");
            if (name.length() <= 12 && name.length() >= 3 && isStringLetter(name))
            {
                setName(name);
                System.out.println("Welcome! " + getName() + "!");
                break;
            }
            else
                System.out.println("Invalid name.");
        }
    }
    
    /**
     * Method setPosition to modify the object's name
     *
     * @param position      an integer input to pass the new position of the player
     */
    public void setPosition(int position)
    {
        this.position = position;
    }

    /**
     * Method setStatus to modify the object's status
     *
     * @param status        an boolean input to pass the new status of the player
     */
    public void setStatus(boolean status)
    {
        this.status = status;
    }
    
    /**
     * Method updateHearts modify the object's hearts base on the current hearts
     *
     * @param changeNumber  an integer input to pass the hearts that you want to add of the player
     */
    public void updateHearts(int changeNumber)
    {
        this.hearts += changeNumber;
    }
    
    /**
     * Method updatePosition modify the object's position base on the current position
     *
     * @param length        an integer input to pass the position that you want to add of the player
     */
    public void updatePosition(int length)
    {
        this.position += length;
    }
}    