package cainiaojava.Inherit;

public class Mouse extends Animal{

    private int num;
    public Mouse(String myName, int myid) { 
        // 构建父类中的constructor，也可以在子类再添加
        super(myName,myid); 
        this.num = 1;
    } 

    public static void main(String[] args) {
        Mouse mice = new Mouse("sdas",12);
        mice.eat();
        
    }

    public void eat(){
        super.eat();
        System.out.println("mouses are eating");
    }

    public void eatS(){
        this.eat();
        super.eat();
        num = 2;
    }
}
