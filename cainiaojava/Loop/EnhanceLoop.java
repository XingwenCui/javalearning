/*
 * @Author: your name
 * @Date: 2021-12-24 10:50:24
 * @LastEditTime: 2022-02-13 13:59:26
 * @LastEditors: Please set LastEditors
 * @Description: 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 * @FilePath: \javalearning\cainiaojava\Loop\EnhanceLoop.java
 */
package cainiaojava.Loop;

import javax.xml.bind.ValidationEvent;
import java.util.*;
public class EnhanceLoop {
    public static void main(String[] args){
        int [] numbers = {10, 20, 30, 40, 50};
        
        // the int type must match int[]
        for(int x : numbers ){
           System.out.print( x );
           System.out.print(",");
        }
        System.out.print("\n");
        String [] names ={"James", "Larry", "Tom", "Lacy"};
        for( String name : names ) {
           System.out.print( name );
           System.out.print(",");
        }
        System.out.println("\n" + validatePostcode("3212"));
        dispenseItem(1);

     }

     public static boolean validatePostcode(String postcode)
     {
               boolean str = true;
               if(postcode.length()!=4)
                         str = false;
               else
               {
                         if(postcode.charAt(0) != '3' )
                                   str = false;
                         for(int i=1; i<postcode.length()-1; i++)
                         { 
                                   if(postcode.charAt(i)<'0' && postcode.charAt(i)>'9')
                                             str = false;
                         }
               }
               return str;
     }

     public static void dispenseItem(double price)
     {
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
                  System.out.println(amount);
                  console.nextLine();
               }
         } while (choice != 'Z' || amount < price);

         if (choice == 'Z')
            System.out.println("Item ready!");
         else
            System.out.println("Item cancelled!");
         if ((choice == 'Z' && amount > 0) || (choice != 'Z' && amount > price))
         {
            if (choice != 'Z')
               amount -= amount;
            System.out.println("Your change is $" + price);
         }
     }
    
}
