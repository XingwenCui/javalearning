/*
 * @Author: your name
 * @Date: 2022-01-24 10:39:35
 * @LastEditTime: 2022-01-24 10:41:13
 * @LastEditors: Please set LastEditors
 * @Description: 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 * @FilePath: \javalearning\cainiaojava\datatype\BasicObject.java
 */
package cainiaojava.datatype;

public class BasicObject {
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        System.out.println(a == b);
        Integer aObject = new Integer(1);
        Integer bObject = new Integer(1);
        System.out.println(aObject == bObject);
    }
    
}
