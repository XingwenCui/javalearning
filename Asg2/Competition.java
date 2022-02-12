package Asg2;
import java.io.*;
import java.util.*;
/**
 * This class Competition is used to play race game. you can create an object and then use competitionStart() method
 *
 * @author Xingwen Cui
 * @version 2022.1.18
 */
public class Competition
{
    private RNG rng; // the random number file of Competition
    private RacerList racerList; // the racerList file of Competition

    /**
     * Competition default Constructor
     *
     */
    public Competition()
    {
        this.rng = new RNG();
        this.racerList = new RacerList();
    }

    /**
     * Competition non-default Constructor
     *
     * @param rng A parameter to pass RNG file 
     * @param racerList A parameter to pass RacerList file
     */
    public Competition(RNG rng, RacerList racerList) 
    {
        this.rng = rng;
        this.racerList = racerList;
    }
    
    /**
     * Method addPoint to add one race's point to the total point list
     * 
     * @param pointTable is the total points for racer's before this race
     * @param pointList A parameter is the points for racer's in this race
     * @return int[] The return value a pointTable for total race
     */
    private int[] addPoint(int[] pointTable, int[] pointList)
    {
        for (int i = 0; i < pointList.length; i++)
        {
            pointTable[i] += pointList[i];
        }
        return pointTable;
    }

    /**
     * Method assignPoint to add point to each racer with their original seqence
     *
     * @param scoreList A parameter which is the score racers have in one race
     * @return int[] The return value a assigned point list
     */
    private int[] assignPoint(double[] scoreList)
    {
        int[] point = new int[scoreList.length];
        double[] originalList = copyList(scoreList);
        double[] sortedList = sortList(scoreList);
        int[] pointList = generatePoint(rankRacer(sortedList));
        for (int i = 0; i < originalList.length; i++)
        {
            for (int j = 0; j < sortedList.length; j++)
            {
                if (originalList[i] == sortedList[j])
                {
                    point[i] = pointList[j];
                    break;
                }
            }
        }
        return point;
    }
    
    /**
     * Method chooseOption for human to make choice
     *
     * @return The return value a int for cheat or use strength
     */
    private int chooseOption()
    {
        Scanner scan = new Scanner(System.in);
        String option = null;
        while (true)
        {
            System.out.println("Please choose your option:\n1: cheat;\n2: strength;");
            option = scan.nextLine();
            if (option.equals("1"))                
                break;            
            else if(option.equals("2"))         
                break;
            else
                System.out.println("You can only enter 1 or 2, please try again.");
        }            
        return Integer.parseInt(option);  
    }
    
    /**
     * Method competitionStart to play race game
     *
     */
    public void competitionStart()
    {   
        Competition game = new Competition();
        ArrayList<String> gameDetails = new ArrayList<String>();
        int[] pointTable = {0, 0, 0};
        String gameOver = "";
        game.readFile();
        game.racerList.addHumanRacer(rng.generateDouble(10, 0), rng.generateDouble(20, 0));
        game.racerList.display();
        pressEnter();
        for (int i = 0; i < 3; i++)
        {
            System.out.print('\u000C');
            System.out.println("Race " + i);
            gameDetails.add(game.oneRace(pointTable));
            pressEnter();
        }
        System.out.print('\u000C');
        System.out.println("Now let's see the result!");
        gameOver = game.result(copyList(pointTable), game.rankFianl(sortList(pointTable))); // rank need sorted, point need original
        System.out.println(gameOver);
        gameDetails.add(gameOver);
        game.writeFile(gameDetails);
        System.out.println("Congratulations to all racers!");
    }
    
    /**
     * Method computerChoice for computer to make choice cheat or strength
     *
     * @param morality A parameter computer will make choice base on morality
     * @return The return value 1 for cheat 2 for strength
     */
    private int computerChoice(double morality)
    {
        double cheatRate = rng.generateDouble(100, 0);
        if (cheatRate > morality)
            return 1;
        else
            return 2;
    }
    
    /**
     * Method copyList to copy a list 
     *
     * @param list A parameter which will be copied 
     * @return The return value a new list the same as param
     */
    private double[] copyList(double[] list)
    {
        double[] copyList = new double[list.length];
        for (int i =0; i < list.length; i++)
        {
            copyList[i] = list[i];
        }
        return copyList;
    }

    /**
     * Method copyList to copy a list 
     *
     * @param list A parameter which will be copied 
     * @return The return value a new list the same as param
     */
    private int[] copyList(int[] list)
    {
        int[] copyList = new int[list.length];
        for (int i =0; i < list.length; i++)
        {
            copyList[i] = list[i];
        }
        return copyList;
    }
    
    /**
     * Method generateFactor to generate the factor in one race 
     *
     * @param choice A parameter the choice basement
     * @return The return value factor in this race
     */
    private int generateFactor(int choice)
    {
        if (choice == 1)
            return rng.generateInt(15, 1);
        else
            return rng.generateInt(30, 15);
    }

    /**
     * Method generateChoice to build a choice array for all racer in one race
     *
     * @return The return value the choice array
     */
    private int[] generateChoice()
    {
        int[] choiceList = new int[racerList.getRacerList().size()];
        int humanRacer = chooseOption();
        choiceList[0] = computerChoice(racerList.getIndexRacer(0).getMorality());
        choiceList[1] = computerChoice(racerList.getIndexRacer(1).getMorality());
        choiceList[2] = humanRacer;
        for (int i = 0; i < choiceList.length; i++)
        {
            if (choiceList[i] == 1)
                System.out.println(racerList.getIndexRacer(i).getName() + " is starting and choose to cheat!" );
            else
                System.out.println(racerList.getIndexRacer(i).getName() + " is starting and choose to " + 
                racerList.getIndexRacer(i).getStrength() + "!" );
        }
        return choiceList;
    }

    /**
     * Method generateFactor to build a factor array for all racer in one race
     *
     * @param choiceList A parameter that return value base on it
     * @return The return value factor array
     */
    private int[] generateFactor(int[] choiceList)
    {
        int[] factorList = {0, 0, 0};
        for (int i = 0; i < choiceList.length; i++)
        {
            factorList[i] = generateFactor(choiceList[i]);
        }
        return factorList;
    }

    /**
     * Method generatePoint to build a point array by their rank
     *
     * @param rankList A parameter
     * @return The return value
     */
    private int[] generatePoint(int[] rankList)
    {
        int[] pointBorad = {10, 5, 0};
        int[] pointList = {0, 0, 0};
        for (int i = 0; i < 3; i++)
        {
            pointList[i] = pointBorad[rankList[i]];
        }
        return pointList;
    }

    /**
     * Method generatePosition build a position array for all racer
     *
     * @return The return value is position array
     */
    private int[] generatePosition()
    {
        int[] position = {0, 0, 0};
        for (int i = 0; i < 3; i++ )
        {
            position[i] = rng.generateInt(100, 1);
        }
        return position;
    }

    /**
     * Method generateScore to generate the score array in one race
     *
     * @param choiceList A parameter choice list for all racer
     * @param position A parameter position list for all racer
     * @param factor A parameter factor list for all racer
     * @return The return value
     */
    private double[] generateScore(int[] choiceList, int[] position, int[] factor)
    {
        double[] scoreList = {0, 0, 0};
        double finalScore = 0;
        for (int i = 0; i < scoreList.length; i++)
        {
            if (racerList.getIndexRacer(i).getCheatPenalty() == 0)
                finalScore = position[i] * racerList.getIndexRacer(i).getStrengthBonus();
            else
                finalScore = (position[i] * racerList.getIndexRacer(i).getStrengthBonus()) / 
                racerList.getIndexRacer(i).getCheatPenalty();
            if (choiceList[i] == 1)
                scoreList[i] = finalScore - racerList.getIndexRacer(i).getCheatPenalty() * factor[i];
            else
                scoreList[i] = finalScore + racerList.getIndexRacer(i).getStrengthBonus() * factor[i];
        }
        return scoreList;
    }

    /**
     * Method getRng the accessor method to get the object's rng
     *
     * @return The return value
     */
    private RNG getRng() 
    {
        return rng;
    }

    /**
     * Method getRacerList the accessor method to get the object's racerlist
     *
     * @return The return value
     */
    private RacerList getRacerList() 
    {
        return racerList;
    }
    
    /**
     * Method oneRace to emulate one race 
     *
     * @param pointTable A parameter this race's piont will add to point table
     * @return The return value is the detail of one race
     */
    private String oneRace(int[] pointTable)
    {
        String detail = "";
        int[] choiceList = generateChoice();
        int[] positionList = generatePosition();
        int[] factorList = generateFactor(choiceList);
        double[] scoreList = generateScore(choiceList, positionList, factorList);
        double[] originalList = copyList(scoreList);
        int[] pointList = assignPoint(scoreList);
        addPoint(pointTable, pointList); 
        int[] rankRacer = rankRacer(scoreList);
        for (int i = 0; i < choiceList.length; i++)
        {
            if (choiceList[i] == 1)
                detail += racerList.getIndexRacer(i).getName() + " choose to cheat and his score is: positon" + 
                positionList[i] + " * bonus" + racerList.getIndexRacer(i).getStrengthBonus() + 
                " / penalty" + racerList.getIndexRacer(i).getCheatPenalty() + " - (factor" + factorList[i] + 
                " * " + racerList.getIndexRacer(i).getCheatPenalty() + ") = final score" + originalList[i] + 
                " the point is " + pointList[i] + "\n"; 
            else
                detail += racerList.getIndexRacer(i).getName() + " choose to " + racerList.getIndexRacer(i).getStrength() +
                 " and his score is: positon" + positionList[i] + " * bonus" + racerList.getIndexRacer(i).getStrengthBonus() + 
                " / penalty" + racerList.getIndexRacer(i).getCheatPenalty() + " + (factor" + factorList[i] + 
                " * " + racerList.getIndexRacer(i).getStrengthBonus() + ") = final score" + originalList[i] + 
                " the point is " + pointList[i] + "\n";
        }
        System.out.println(result(pointList, rankRacer));
        return detail;
    }

    /**
     * Method pressEnter to be continue by stroke enter
     *
     */
    private void pressEnter()
    {
        Scanner enter = new Scanner(System.in);
        System.out.println("Press enter to continue.");
        enter.nextLine();
    }
    
    /**
     * Method rankFianl to rank the total point
     *
     * @param pointTable A parameter
     * @return The return value
     */
    private int[] rankFianl(int[] pointTable)
    {
        int[] rank = {0, 0, 0};
        int index = 0;
        for (int i = 0; i < rank.length - 1; i ++)
        {
            if (pointTable[i] > pointTable[i+1])
            {
                index++;
                rank[i + 1] = index;
            }
            else
                rank[i + 1] = index;
        }
        return rank;
    }

    /**
     * Method rankRacer to rank one race's score
     *
     * @param sortList A parameter which has been sorted score array
     * @return The return value a rank array for all racer in one race
     */
    private int[] rankRacer(double[] sortList)
    {
        int[] rank = {0, 0, 0};
        int index = 0;
        for (int i = 0; i < rank.length - 1; i ++)
        {
            if (sortList[i] > sortList[i+1])
            {
                index++;
                rank[i + 1] = index;
            }
            else
                rank[i + 1] = index;
        }
        return rank;
    }

    /**
     * Method readFile to input the computer racer in file
     */
    private void readFile()
    {
        try 
        {
            FileReader input = new FileReader("racers.txt");
            try    
            {
                Scanner message = new Scanner(input);
                while (message.hasNextLine())
                {
                    String line = message.nextLine();
                    String[] info = line.split(",");
                    double strengthBonus = rng.generateDouble(10, 0);
                    double cheatPenalty = rng.generateDouble(20, 0);                
                    racerList.addComputerRacer(info[0], info[1], Double.parseDouble(info[2]), strengthBonus, cheatPenalty);
                }
            }
            finally
            {    
                input.close();
            }
        }
        catch (IOException e)
        {
            System.out.println("error.");
        }
    }

    /**
     * Method result to generate the result of the race or game
     *
     * @param pointList A parameter 
     * @param rankRacer A parameter
     * @return The return value the result of the game
     */
    private String result(int[] pointList, int[] rankRacer)
    {
        String[] racerName = new String[racerList.getRacerList().size()];
        for (int i = 0; i < racerList.getRacerList().size(); i++)
        {
            racerName[i] = racerList.getIndexRacer(i).getName();
        } 
        for (int i = 0; i < pointList.length; i++)
        {
            for (int j = 0; j < pointList.length - 1 - i; j++)
            if (pointList[j] > pointList[j + 1])
            {
                int temp = pointList[j];
                String tempName = racerName[j];
                pointList[j] = pointList[j + 1];
                racerName[j] = racerName[j + 1];
                pointList[j + 1] = temp;
                racerName[j + 1] = tempName;
            }
        }
        return resultdisplay(pointList, racerName, rankRacer);
    }
    
    /**
     * Method resultdisplay to generate the String of result
     * @param pointList A parameter the race point array
     * @param racerName A parameter the game's racers
     * @param rankList A parameter the rank of the racers
     * @return The return value
     */
    private String resultdisplay(int[] pointList, String[] racerName, int[] rankList)
    {
        String detail = "";
        for (int i = 0; i < pointList.length; i++)
        {
            detail += "In " + (rankList[2 - i] + 1) + " place is " + racerName[i] + " and his point is " + pointList[i] + "\n";
        }
        return detail;
    }

    /**
     * Method setRacerList mutator to set racerList
     *
     * @param racerList A parameter
     */
    private void setRacerList(RacerList racerList) 
    {
        this.racerList = racerList;
    }

    /**
     * Method setRng mutator to set rng
     *
     * @param rng A parameter
     */
    private void setRng(RNG rng) 
    {
        this.rng = rng;
    }
    
    /**
     * Method sortList to sort score list
     *
     * @param list A parameter
     * @return The return value generate a rank list
     */
    private double[] sortList(double[] list)
    {
        if (list.length == 0)
            return list;
        else
        {
            for (int i = 0; i < list.length; i++)
            {
                for (int j =0; j < list.length - 1 - i; j++)
                if (list[j] < list[j + 1])
                {
                    double temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
            return list;
        }
    }
    
    /**
     * Method sortList to sort score list
     *
     * @param list A parameter
     * @return The return value generate a rank list
     */
    private int[] sortList(int[] list)
    {
        if (list.length == 0)
            return list;
        else
        {
            for (int i = 0; i < list.length; i++)
            {
                for (int j =0; j < list.length - 1 - i; j++)
                if (list[j] < list[j + 1])
                {
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
            return list;
        }
    }
    
    /**
     * Method writeFile to write game's getail
     *
     * @param gameDetail A parameter which will be write to the file 
     */
    private void writeFile(ArrayList<String> gameDetail)
    {
        try
        {
            PrintWriter outputFile = new PrintWriter("winners.txt");
            try
            {
                for (int i = 0; i < gameDetail.size() - 1; i++)
                {
                    outputFile.println("Race" + (i + 1) + "\n" + gameDetail.get(i));
                }
                outputFile.println(gameDetail.get(gameDetail.size() - 1));
            }
            finally
            {    
                outputFile.close();
            }
        }
        catch(IOException exception)
        {
            System.out.println("Unexpected I/O error occured");
        }
    }
}