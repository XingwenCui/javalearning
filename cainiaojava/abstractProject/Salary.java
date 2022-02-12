/*
 * @Author: your name
 * @Date: 2022-02-11 16:55:46
 * @LastEditTime: 2022-02-11 16:57:52
 * @LastEditors: Please set LastEditors
 * @Description: 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 * @FilePath: \javalearning\cainiaojava\abstractProject\Salary.java
 */
package cainiaojava.abstractProject;

public class Salary extends Employee {

    public static void main(String [] args) {
        Salary s = new Salary("Mohd Mohtashim", "Ambehta, UP", 3, 3600.00);
        Employee e = new Salary("John Adams", "Boston, MA", 2, 2400.00);
   
        System.out.println("Call mailCheck using Salary reference --");
        s.mailCheck();
   
        System.out.println("\n Call mailCheck using Employee reference--");
        e.mailCheck();
      }

    private double salary; //Annual salary
    public Salary(String name, String address, int number, double salary) {
        super(name, address, number);
        setSalary(salary);
    }
    public void mailCheck() {
        System.out.println("Within mailCheck of Salary class ");
        System.out.println("Mailing check to " + getName()
        + " with salary " + salary);
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double newSalary) {
        if(newSalary >= 0.0) {
           salary = newSalary;
        }
    }
    public double computePay() {
       System.out.println("Computing salary pay for " + getName());
       return salary/52;
    }
 }