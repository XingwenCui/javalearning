package Asg2;

import java.util.*;
/**
 * This class Racer is used to create a racer with some attributes and contain methods to change these attributes
 *
 * @author Xingwen Cui
 * @version 2022.1.18
 */
public class Racer
{
    private String name; // The name of the racer
    private String strength; // The strength of the racer
    private double morality; // The morality of the player
    private double strengthBonus; // The strengthBonus of the player
    private double cheatPenalty; // The cheatPenalty of the player
    private String type; // The type of the player

    /**
     * Default Constructor for objects of Racer， Constructor
     *
     */
    public Racer()
    {
        this.name = "unknown";
        this.strength = "unknown";
        this.morality = 0.0;
        this.cheatPenalty = 0.0;
        this.strengthBonus = 0.0;
        this.type = "human";
    }
    
    /**
     * Racer Non-default Constructor
     *
     * @param name A String parameter pass racer's name
     * @param strength A String parameter pass racer's name
     * @param morality A double parameter pass racer's morality rate
     * @param strengthBonus A double parameter pass racer's strength bonus
     * @param cheatPenalty A  double parameter pass racer's cheat penalty number
     * @param type A Stirng parameter pass racer's type
     */
    public Racer(String name, String strength, double morality, double strengthBonus, double cheatPenalty,
            String type) 
    {
        this.name = name;
        this.strength = strength;
        if (morality >= 0 && morality <= 1)
            this.morality = morality;
        else
            this.morality = 0;
        if (strengthBonus >= 0 && strengthBonus <= 0.1)
            this.strengthBonus = strengthBonus;
        else
            this.strengthBonus = 0;
        if (cheatPenalty >=0 && cheatPenalty <= 0.2)
            this.cheatPenalty = cheatPenalty;
        else
            this.cheatPenalty = 0;
        if (type == "human" || type == "computer")
            this.type = type;
        else
            this.type = "human";
    }
    
    /**
     * Method getCheatPenalty to get the object's cheat penalty
     *
     * @return double
     */
    public double getCheatPenalty()
    {
        return this.cheatPenalty;
    }

    /**
     * Method getMorality to get the object's morality
     *
     * @return double
     */
    public double getMorality()
    {
        return this.morality;
    }
    
    /**
     * Method getName to get the object's Name
     *
     * @return String
     */
    public String getName()
    {
        return this.name;
    }
    
    /**
     * Method getStrength to get the object's strength name
     *
     * @return String
     */
    public String getStrength()
    {
        return this.strength;
    }
    
    /**
     * Method getStrengthBonus to get the object's StrengthBonus
     *
     * @return double
     */
    public double getStrengthBonus()
    {
        return this.strengthBonus;
    }
    
    /**
     * Method getType to access the racer's type
     *
     * @return String the racer's type
     */
    public String getType() 
    {
        return type;
    }
    
    /**
     * Method isStringLetter
     *
     * @param str A parameter to pass the str
     * @return boolean to judge the string is all char
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
     * Method setCheatPenalty to modify the cheatPenalty
     *
     * @param double cheatPenalty A parameter
     */
    public boolean setCheatPenalty(double cheatPenalty)
    {
        if (cheatPenalty > 0.0 && cheatPenalty < 0.2)
        {    
            this.cheatPenalty = cheatPenalty;
            return true;
        }
        else
            return false;
    }

    /**
     * Method setMorality to modify the morality
     *
     * @param double morality A parameter
     */
    public boolean setMorality(double morality)
    {
        if (morality >= 0 && morality <= 1)
        {
            this.morality = morality;
            return true;
        }
        else
        
            return false;
    }

    /**
     * Method setName to modify the name
     *
     * @param String name A parameter
     */
    public boolean setName(String name)
    {
        if (name.length() >=3 && name.length() <= 12 && isStringLetter(name))
        {
            this.name = name;
            return true;
        }
        else
            return false;
    }
    
    /**
     * Method setNewName to set a new name
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
     * Method setNewMorality to set morality
     *
     */
    public void setNewMorality()
    {   
        Scanner scan = new Scanner(System.in);
        double newMorality = -1;
        while (newMorality < 0 || newMorality > 1)
        {
            System.out.println("Please enter your morality in 0 - 1.");
            newMorality = toDouble(scan.nextLine());
            if (newMorality < 0 || newMorality > 1)
                System.out.println("Invalid morality.");
            else
                System.out.println("You choose morality of: " + newMorality);
        }
        setMorality(newMorality);
    }

    /**
     * Method setNewStrength to set new strength
     *
     */
    public void setNewStrength()
    {
        Scanner scan = new Scanner(System.in);
        while (true)
        {
            System.out.println("Please enter your strength in 3 - 25 chars and the strength can only contain characters.");
            String strength = scan.nextLine().replace(" ","");
            if (strength.length() <= 25 && strength.length() >= 3 && isStringLetter(strength))
            {
                setStrength(strength);
                System.out.println("Your strength is " + getStrength() + "!");
                break;
            }
            else
                System.out.println("Invalid strength.");
        }
    }

    /**
     * Method setStrength to set strength
     *
     * @param strength A parameter
     */
    public boolean setStrength(String strength)
    {
        if (strength.length() >=3 && strength.length() <= 25 && isStringLetter(strength))
        {
            this.strength = strength;
            return true;
        }
        else 
            return false;
    }
    
    /**
     * Method setStrengthBonus to set bonus
     *
     * @param double strengthBonus A parameter
     */
    public boolean setStrengthBonus(double strengthBonus)
    {
        if (strengthBonus >= 0 && strengthBonus <= 0.1)
        {
            this.strengthBonus = strengthBonus;
            return true;
        }
        else
            return false;
    }

    /**
     * Method setType to set the racer's type
     *
     * @param type String parameter pass the racer's type
     */
    public boolean setType(String type) 
    {
        if (type == "human" || type == "computer")
        {    
            this.type = type;
            return true;
        }
        else
            return false;
    }

    /**
     * Method toDouble to make String to double type
     *
     * @param input A parameter String 
     * @return The return value to Double
     */
    public double toDouble(String input) 
    {
        double inputDouble = 0;
        try 
        {
            inputDouble = Double.parseDouble(input);
        } 
        catch (NumberFormatException e) 
        {
            inputDouble = -1.0;
        }
        return inputDouble;
    }
}