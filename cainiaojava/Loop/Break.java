package cainiaojava.Loop;

public class Break {
    public static void main(String[] args) {
        int [] numbers = {10, 20, 30, 40, 50};
   
        for(int x : numbers ) {
           // x 等于 30 时跳出循环
           if( x == 30 ) {
              break;
           }
           // the below code will not be excuted if break
           System.out.print( x );
           System.out.print("\n");
        }
        System.out.println("This is 'continue' case.");
        continueS();
    }
    

     // continue to immediately skip to next loop.
    public static void continueS() {
        int [] numbers = {10, 20, 30, 40, 50};

        for(int x : numbers ) {
            // x 等于 30 时跳过此循环
            if( x == 30 ) {
                continue;
            }
            // the below code will not be excuted if break
            System.out.print( x );
            System.out.print("\n");
        }
    }
}
