package cainiaojava.modifiers;

public class FinalModifier {
    // when use final, the variable can not change value
    final int value = 10;
    // 下面是声明常量的实例
    public static final int BOXWIDTH = 6;
    static final String TITLE = "Manager";
    
    public void changeValue(){
        //value = 12; //将输出一个错误,value can not be assigned
    }

    public final void method() {
        // can not be rewrite in child class.
        // and can not be inherited
    }
    
}
