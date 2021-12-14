/**
 * This class RNG is used to generate random int number between the minimum and maxmun limits
 *
 * @author Xingwen Cui
 * @version 2021.11.20
 */
public class RNG
{
    private int maximumValue; // Maximum value of the random number
    private int minimumValue; // minimum value of the random number
    
    /**
     * Default RNG Constructor for objects of class RNG
     */
    public RNG()
    {
        maximumValue = 0;
        minimumValue = 0;
    }
    
    /**
     * Non-default RNG Constructor for objects of class RNG
     *
     * @param maximumValue      an integer input to pass the maximum value of the RNG
     * @param minimumValue       an integer input to pass the minimum value of the RNG
     */
    public RNG(int maximumValue, int minimumValue)
    {
        this.maximumValue = maximumValue;
        this.minimumValue = minimumValue;
    }
    
    /**
     * Method display to display the state of the RNG objects
     *
     */
    public void display()
    {
        System.out.println("MaximumValue is " + getMaximumValue());
        System.out.println("minimumValue is " + getMinimumValue());
    }
    
    /**
     * Method generateRN to generate a random number in [minimumValue, maximumValue]
     *
     * @return          the generated random number 
     */
    public int generateRandomNumber()
    {
        int randomRange = maximumValue - minimumValue + 1;
        int randomNumber = (int)((Math.random()* randomRange) + minimumValue);
        return randomNumber;
    }
    
    /**
     * Method generateRandomNumber to generate a random number by passing parameter
     *
     * @param max       an integer input to pass the maximum value of the random range
     * @param min       an integer input to pass the minimum value of the random range
     * @return          the generated random number
     */
    public int generateRandomNumber(int max, int min)
    {
        int randomRange = max - min + 1;
        int randomNumber = (int)((Math.random()* randomRange) + min);
        return randomNumber;
    }
    
    /**
     * Method getMaximumValue to get the object's maximumValue
     *
     * @return          the object's maximumValue
     */
    public int getMaximumValue()
    {
        return maximumValue;
    }
    
    /**
     * Method getminimumValue to get the object's minimumValue
     *
     * @return          the object's minimumValue
     */
    public int getMinimumValue()
    {
        return minimumValue;
    }
    
    /**
     * Method setMaximumValue to modify the object's maximumValue
     *
     * @param newMax    an integer input to pass the new maximum value of the random range
     */
    public void setMaximumValue(int newMax)
    {
        maximumValue = newMax;
    }
    
    /**
     * Method setminimumValue to modify the object's minimumValue
     *
     * @param newMin    an integer input to pass the new minimum value of the random range
     */
    public void setMinimumValue(int newMin)
    {
        minimumValue = newMin;
    }
}