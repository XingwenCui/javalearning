/*
 * @Author: your name
 * @Date: 2021-12-23 20:48:21
 * @LastEditTime: 2022-02-04 21:48:09
 * @LastEditors: Please set LastEditors
 * @Description: 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 * @FilePath: \javalearning\cainiaojava\class_and_objects\EmployeeTest.java
 */
package cainiaojava.class_and_objects;
// import java.io.*;
public class EmployeeTest {
    public static void main(String[] args){
        /* 使用构造器创建两个对象 */
        Employee empOne = new Employee("RUNOOB1");
        Employee empTwo = new Employee("RUNOOB2");
   
        // 调用这两个对象的成员方法
        empOne.empAge(26);
        empOne.empDesignation("高级程序员");
        empOne.empSalary(1000);
        empOne.printEmployee();
   
        empTwo.empAge(21);
        empTwo.empDesignation("菜鸟程序员");
        empTwo.empSalary(500);
        empTwo.printEmployee();
     }
    
}
