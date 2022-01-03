package cainiaojava.Array;



public class MultipleDimension {
    public static void main(String[] args) {
        String[][] s = new String[2][];
        s[0] = new String[2];
        s[1] = new String[3];
        s[0][0] = new String("Good");
        s[0][1] = new String("Luck");
        s[1][0] = new String("to");
        s[1][1] = new String("you");
        s[1][2] = new String("!");
        
        // traversal
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length; j++){
                System.out.println(s[i][j]);
            }
        }
    }
}
