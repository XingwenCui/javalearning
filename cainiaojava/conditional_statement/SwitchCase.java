package cainiaojava.conditional_statement;

public class SwitchCase {
    public static void main(String[] args) {
        //char grade = args[0].charAt(0);
      char grade = 'C';
 
      switch(grade)
      {
        case 'A' :
        System.out.println("优秀"); 
        break;
        case 'B' :
        case 'C' :
        System.out.println("良好");
        break;
        case 'D' :
        System.out.println("及格");
        break;
        case 'F' :
        System.out.println("你需要再努力努力");
        break;
        default :
        System.out.println("未知等级");
      }
      System.out.println("你的等级是 " + grade);

      //If there are no break, when case matched, it will output
      // all the other case.
      int i = 1;
      switch(i){
         case 1:
            System.out.println("0");
         case 0:
            System.out.println("1");
         case 2:
            System.out.println("2");
         default:
            System.out.println("default");
      }
      // But if the other case has break, it will still excute
      switch(i){
        case 0:
           System.out.println("0");
        case 1:
           System.out.println("1");
        case 2:
           System.out.println("2");
        case 3:
           System.out.println("3"); break;
        default:
           System.out.println("default");
      }
   }

}
