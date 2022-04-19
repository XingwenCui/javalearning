/*
 * @Author: your name
 * @Date: 2022-02-13 10:29:13
 * @LastEditTime: 2022-02-13 10:32:34
 * @LastEditors: Please set LastEditors
 * @Description: 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 * @FilePath: \javalearning\cainiaojava\Exception\ExcepTest.java
 */
package cainiaojava.Exception;

// 文件名 : ExcepTest.java
import java.io.*;
public class ExcepTest{

   public static void main(String args[]){
    int a[] = new int[2];
    try{
        
        System.out.println("Access element three :" + a[3]);
    }catch(ArrayIndexOutOfBoundsException e){
        System.out.println("Exception thrown  :" + e);
    }
    //try catch finally 之间不能加入其它code
    //System.out.println("Out of the block"); 
    finally{
        a[0] = 6;
        System.out.println("First element value: " +a[0]);
        System.out.println("The finally statement is executed");
    }
    System.out.println("Out of the block");      
   }
}
