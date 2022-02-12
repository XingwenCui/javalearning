package Asg2;
import java.util.*;
import java.io.*;
/**
 * This class RacerList is used to generate the ArrayList with Racer items and methods to opreate the Racer and list
 *
 * @author Xingwen Cui
 * @version 2022.1.18
 */
public class RacerList
{
    private ArrayList<Racer> racerList; // the ArrayList<> cotain Racer item.

    /**
     * RacerList Constructor to default construct object
     *
     */
    public RacerList()
    {
        racerList = new ArrayList<Racer>();
    }

    /**
     * RacerList Constructor to construct non-default object
     *
     * @param racerList A parameter to pass ArratList<Racer>
     */
    public RacerList(ArrayList<Racer> racerList) 
    {
        this.racerList = racerList;
    }
    
    /**
     * Method addComputerRacer to add compuer racer from file
     *
     * @param String name A parameter racer's name
     * @param String strength A parameter racer's strength
     * @param double morality A parameter racer's morality
     * @param double strengthBonus A parameter racer's strengthBonus
     * @param double cheatPenalty A parameter racer's cheatPenalty
     */
    public void addComputerRacer(String name, String strength, double morality, double strengthBonus, double cheatPenalty)
    {
        Racer racer = new Racer(name, strength, morality, strengthBonus, cheatPenalty, "computer");
        racerList.add(racer);
    }
    
    /**
     * Method addRacer to add new racer
     *
     */
    public void addHumanRacer(double bonus, double penalty)
    {
        Racer newRacer = new Racer();
        newRacer.setNewName();
        newRacer.setNewStrength();
        newRacer.setNewMorality();
        newRacer.setStrengthBonus(bonus);
        newRacer.setCheatPenalty(penalty);
        racerList.add(newRacer);
    }

    /**
     * Method display to show the basic information of the racers
     *
     */
    public void display()
    {
        System.out.println("Name\t\t\tStrength \t\tMorality\tStrength Bonus\tCheat Penalty\tType");
        for (Racer racer: racerList)
        {
            if (racer.getType() == "computer")
            {
                System.out.println(racer.getName() + "\t" + racer.getStrength() + "\t\t" + racer.getMorality() + "\t\t" + 
                    racer.getStrengthBonus() + "\t\t" + racer.getCheatPenalty() + "\t\t" + racer.getType());
            }
            else
            {
                System.out.println(racer.getName() + " \t\t\t" + racer.getStrength() + " \t\t" + racer.getMorality() + "\t\t" + 
                    racer.getStrengthBonus() + "\t\t" + racer.getCheatPenalty() + "\t\t" + racer.getType());
            }

        }
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public Racer getIndexRacer(int index)
    {
        return getRacerList().get(index);
    }
    
    /**
     * Method getRacerList to access the object's racerList
     *
     * @return ArratList<Racer> the object's file
     */
    public ArrayList<Racer> getRacerList() 
    {
        return racerList;
    }
    
    /**
     * Method setRacerList
     *
     * @param racerList A ArrayList<Racer> parameter to pass racerList to object
     */
    public void setRacerList(ArrayList<Racer> racerList) 
    {
        this.racerList = racerList;
    }
}