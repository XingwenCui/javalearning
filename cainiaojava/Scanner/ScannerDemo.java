package cainiaojava.Scanner;
import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        // construct scan object
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);

        // receive characters in next method, and jude if there has?
        if (scan.hasNext()) {
            String str1 = scan.next();
            System.out.println("输入的数据为：" + str1);
        }

        // receive characters in next Line method
        if (scan2.hasNextLine()) {
            String str2 = scan2.nextLine();
            System.out.println("输入的数据为：" + str2);
        }
        scan.close();
    }
}
