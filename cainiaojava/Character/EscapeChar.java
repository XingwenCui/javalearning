package cainiaojava.Character;

public class EscapeChar {
    public static void main(String[] args) {
        // '\'avoid errors
        System.out.println("访问\"菜鸟教程!\"");
        // '\t' will insert a tab
        System.out.println("\tthis is '\\t' case.");
        // '\b' will insert a backsapce, \b will delete one char
        System.out.println("this is \\b case\b hahaha");
        // '\n' insert a nextline 
        System.out.println("this is \\n's case \nlook");
        // '\r' insert a enter case, re-input
        System.out.println("this is a \\r \rl23456");
        // '\f' change a page
        System.out.println("lalala \fsdasdas");
    }
}
