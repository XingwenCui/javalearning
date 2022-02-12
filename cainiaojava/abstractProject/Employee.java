/*
 * @Author: your name
 * @Date: 2022-02-11 11:20:02
 * @LastEditTime: 2022-02-11 11:22:29
 * @LastEditors: Please set LastEditors
 * @Description: 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 * @FilePath: \javalearning\cainiaojava\abstractProject\Employee.java
 */
/*
 * @Author: your name
 * @Date: 2022-02-11 11:20:02
 * @LastEditTime: 2022-02-11 11:21:12
 * @LastEditors: Please set LastEditors
 * @Description: 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 * @FilePath: \javalearning\cainiaojava\abstractProject\Employee.java
 */
/*
 * @Author: your name
 * @Date: 2022-02-11 11:20:02
 * @LastEditTime: 2022-02-11 11:20:03
 * @LastEditors: Please set LastEditors
 * @Description: 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 * @FilePath: \javalearning\cainiaojava\abstract\Employee.java
 */
package cainiaojava.abstractProject;

public abstract class Employee {
    private String name;
    private String address;
    private int number;

   /**
    public static void main(String [] args) {
      以下是不允许的，会引发错误 
      Employee e = new Employee("George W.", "Houston, TX", 43);

      System.out.println("\n Call mailCheck using Employee reference--");
      e.mailCheck();
      }
   */
    public Employee(String name, String address, int number) {
       System.out.println("Constructing an Employee");
       this.name = name;
       this.address = address;
       this.number = number;
    }
    public double computePay() {
      System.out.println("Inside Employee computePay");
      return 0.0;
    }
    public void mailCheck() {
       System.out.println("Mailing a check to " + this.name
        + " " + this.address);
    }
    public String toString() {
       return name + " " + address + " " + number;
    }
    public String getName() {
       return name;
    }
    public String getAddress() {
       return address;
    }
    public void setAddress(String newAddress) {
       address = newAddress;
    }
    public int getNumber() {
      return number;
    }
 }
