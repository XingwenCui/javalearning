package cainiaojava.Array;

public class ArrayLoop {
    public static void main(String[] args) {
        double[] myList = {1.9, 2.9, 3.4, 3.5};
 
        // 打印所有数组元素
        for (int i = 0; i < myList.length; i++) {
            System.out.println(myList[i] + " ");
        }
        // 计算所有元素的总和
        double total = 0;
        for (int i = 0; i < myList.length; i++) {
            total += myList[i];
        }
        System.out.println("Total is " + total);
        // 查找最大元素
        double max = myList[0];
        for (int i = 1; i < myList.length; i++) {
            if (myList[i] > max) max = myList[i];
        }
        System.out.println("Max is " + max);

        // For-Each
        double[] myList2 = {1.9, 2.9, 3.4, 3.5};
 
        // 打印所有数组元素
        for (double element: myList2) {
            System.out.println(element);
        }

        //array as a parameter
        printArray(new int[]{3,1,3,4,5,6});
        //array as return
        printArray(reverse(new int[]{1,2,3,4,5})); 
    
    }

    // array as a parameter
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }

    public static int[] reverse(int[] list) {
        int[] result = new int[list.length];

        for (int i = 0, j = result.length - 1; i < list.length; i++, j--) {
            result[j] = list[i];
        }
        return result;
    }
}
