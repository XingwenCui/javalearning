package cainiaojava.operator;

public class DuanLu {

    // When the first boolean is False, the next operation will 
    // not operate so a++ won't happen.
    public static void main(String[] args){
        int a = 5;//定义一个变量；
        boolean b = (a<4)&&(a++<10);
        System.out.println("使用短路逻辑运算符的结果为"+b);
        System.out.println("a的结果为"+a); 
    }
    
}
