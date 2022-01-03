package cainiaojava.Loop;

public class WhileLoop {
    public static void main(String[] args) {
        int x = 10;
        // won't print 20
        while( x < 20 ) {
           System.out.print("value of x : " + x );
           x++;
           System.out.print("\n");
        }
     }
    
}
