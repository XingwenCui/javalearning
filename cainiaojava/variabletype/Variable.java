package cainiaojava.variabletype;

public class Variable {
    static int allClicks = 0;   //class variable
    String str = "hello world"; //instance variable
    
    public void method(){
        int i = 0;              // local variable. When stop executed, the i will be destoried
        str = str + i;
        System.out.println(str);

    }

    public static void main(String[] args) {
        // construct new object.
        Variable test = new Variable();
        test.method();
        
    }
    
}
