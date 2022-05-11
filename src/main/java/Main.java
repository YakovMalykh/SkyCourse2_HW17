import java.util.Arrays;

import static java.util.Arrays.*;

public class Main {


    public static void main(String[] args) {

        int[] numbers1 = new int[100_000];
        for (int i = 0; i < numbers1.length; i++) {
            numbers1[i] = (int) (Math.random() * 100_000);
        }
        int[] numbers2 = copyOf(numbers1, numbers1.length);
        int[] numbers3 = copyOf(numbers1, numbers1.length);
        int[] numbers4 = copyOf(numbers1, numbers1.length);


        long start1 = System.currentTimeMillis();
        SortMethods.sortBubble(numbers1);
        System.out.println("Bubbles - " + (System.currentTimeMillis() - start1));

        long start2 = System.currentTimeMillis();
        SortMethods.sortSelection(numbers2);
        System.out.println("Selection - " + (System.currentTimeMillis() - start2));

        long start3 = System.currentTimeMillis();
        SortMethods.sortInsertion(numbers3);
        System.out.println("Insertion - " + (System.currentTimeMillis() - start3));

        long start4 = System.currentTimeMillis();
        SortMethods.quickSort(numbers4,0,numbers4.length-1);
        System.out.println("quickSort - " + (System.currentTimeMillis() - start4));







    }
}
