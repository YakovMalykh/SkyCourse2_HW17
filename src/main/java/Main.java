import java.util.Arrays;

public class Main {


    public static void main(String[] args) {

        int[] numbers1 = new int[100_000];
        for (int i = 0; i < numbers1.length; i++) {
            numbers1[i] = (int) (Math.random() * 100_000);
        }
        int[] numbers2 = new int[100_000];
        for (int i = 0; i < numbers2.length; i++) {
            numbers2[i] = (int) (Math.random() * 100_000);
        }
        int[] numbers3 = new int[100_000];
        for (int i = 0; i < numbers3.length; i++) {
            numbers3[i] = (int) (Math.random() * 100_000);
        }


        long start1 = System.currentTimeMillis();
        SortMethods.sortBubble(numbers1);
        System.out.println("Bubbles - "+ (System.currentTimeMillis()-start1));

        long start2 = System.currentTimeMillis();
        SortMethods.sortSelection(numbers2);
        System.out.println("Selection - "+(System.currentTimeMillis()-start2));

        long start3 = System.currentTimeMillis();
        SortMethods.sortInsertion(numbers3);
        System.out.println("Insertion - "+(System.currentTimeMillis()-start3));

    }
}
