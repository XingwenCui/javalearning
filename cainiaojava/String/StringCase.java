/*
 * @Author: your name
 * @Date: 2021-12-24 17:38:33
 * @LastEditTime: 2022-02-12 11:10:20
 * @LastEditors: your name
 * @Description: 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 * @FilePath: \javalearning\cainiaojava\String\StringCase.java
 */
package cainiaojava.String;

public class StringCase {
    public static void main(String[] args) {
        // String 创建的字符串存储在公共池中，而 new 创建的字符串对象在堆上
        String s1 = "Runoob";              // String 直接创建
        String s2 = "Runoob";              // String 直接创建
        String s3 = s1;                    // 相同引用
        String s4 = new String("Runoob");   // String 对象创建
        String s5 = new String("Runoob");   // String 对象创建
        System.out.println(s1 == s2);
        System.out.println(s3 == s2);
        System.out.println(s4 == s5); // they are two objects if use that method to create
        System.out.println(s4.equals(s5));
        
        // other ways to create String
        char[] helloArray = { 'r', 'u', 'n', 'o', 'o', 'b'};
        String helloString = new String(helloArray);  
        System.out.println( helloString );

        // length of String
        String site = "www.runoob.com";
        int len = site.length();
        System.out.println( "菜鸟教程网址长度 : " + len );

        // concatenate String
        String string1 = "菜鸟教程网址：";     
        System.out.println("1、" + string1 + "www.runoob.com");  

        // format String output
        float floatVar = .22f;
        int intVar = 1;
        String stringVar = "sadas";

        System.out.printf("浮点型变量的值为 " +
                  "%f, 整型变量的值为 " +
                  " %d, 字符串变量的值为 " +
                  "is %s", floatVar, intVar, stringVar);

    }
}
