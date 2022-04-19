/*
 * @Author: your name
 * @Date: 2022-02-15 13:43:37
 * @LastEditTime: 2022-02-15 20:11:59
 * @LastEditors: Please set LastEditors
 * @Description: 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 * @FilePath: \javalearning\Test2.java
 */
public class Test2 {
    public static void main(String[] args) {
        // System.out.println(name("abcdefg"));
        int a = 1, b =2;
        boolean f = a < b || ++a < b++;
        System.out.println(f);
        System.out.println(a);
        f = a<b && ++a < b++;
        System.out.println(f);
        System.out.println(a);
    }

     public static String name(String input){
        String oddString = "";
        for (int i = 0; i < input.length(); i++)
        {
            if ((i+1)%2 != 0)
            {
                oddString += input.charAt(i);
                // System.out.println(oddString);
            }
        }

        
        return oddString;
     }
}
