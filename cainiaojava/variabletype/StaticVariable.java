package cainiaojava.variabletype;

// import java.io.*;
 
public class StaticVariable {
    //salary是静态的私有变量
    private static double salary;
    // DEPARTMENT是一个常量
    public static final String DEPARTMENT = "开发人员";
    public static void main(String[] args){
    //这个salary可以不construct object就使用
        salary = 10000;
        System.out.println(DEPARTMENT+"平均工资:"+salary);
    }
}