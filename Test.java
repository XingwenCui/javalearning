import java.lang.reflect.Array;
import java.util.*;

/*
 * @Author: your name
 * @Date: 2022-02-13 14:08:41
 * @LastEditTime: 2022-02-14 22:09:02
 * @LastEditors: Please set LastEditors
 * @Description: 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 * @FilePath: \javalearning\Test.java
 */
public class Test {
    public static void main(String[] args) {
        // String[] array = {"tome","nddasdasass","bo","a"};
        // System.out.println(longestString(array));
        // temperature();
        name1();
    }
    
    public static void temperature()

    {

        Scanner scan = new Scanner(System.in);

        ArrayList<Double> tempList = new ArrayList<>();

        int count = 0;

        double sum = 0;

        while (true)

        {

            //double temp = Double.parseDouble(scan.nextLine());
            double temp = scan.nextDouble();
            if (temp == -99)

                break;

            else

            {

                tempList.add(temp);

                if (temp > 40)

                    count++;

            }

        }

        for (double i: tempList)

        {

            sum += i;

        }

        System.out.println("The number of temperatures over 40 degrees is : " + count);

        System.out.println("The average is"  + sum / tempList.size());

    }

    public static String longestString(String[] array)

    {   
        

        for (int i = 0; i < array.length - 1; i++)

        {

            if (array[i].length() > array[i + 1].length())

            {
                array[i + 1] = array[i];
            }
        }
        return array[array.length - 1];
    }

    public static void name(double price) {
        double amount = 0;
        char choice = ' ';
        Scanner console = new Scanner(System.in);
        do
        {
            System.out.println("A. $1.00");
            System.out.println("B. $0.50");
            System.out.println("C. $0.20");
            System.out.println("D. $0.10");
            System.out.println("Z. Cancel");
            System.out.print("Please select: ");
            choice = console.nextLine().charAt(0);
            switch(choice)
            {
                case 'A': amount += 1.00; break;
                case 'B': amount += 0.50; break;
                case 'C': amount += 0.20; break;
                case 'D': amount += 0.10; break;
                case 'Z': break;
                default: System.out.print("Invalid - Press enter to continue");
                console.nextLine();
            }
          } while (choice != 'Z' && amount < price);
        if (choice != 'Z')
            System.out.println("Item ready!");
        else
            System.out.println("Item cancelled!");
        if ((choice == 'Z' && amount > 0) || (choice != 'Z' && amount > price))
        {
            if (choice != 'Z')
                amount -= price;
            System.out.println("Your change is $" + amount);
        }
    }

    public static void name1() {
        for (int count = 0; count < 15; count++)
        {
            System.out.println(count);
        }
    }

     
}
