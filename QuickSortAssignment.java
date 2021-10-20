
import java.util.Scanner;

public class QuickSortAssignment {
    
    public static void main (String[] args){

        Scanner scanner = new Scanner(System.in);

        int low, high;

        System.out.print("How many numbers do you want to sort? ");

        int amount = scanner.nextInt();

        int[] sortingArray = new int[amount];

        int min = 0;

        int max = 100;

        int range = max - min + 1;

        for (int i = 0; i < amount; i++){

            sortingArray[i] = (int)(Math.random() * range);

            System.out.print(sortingArray[i] + " ");

        }

        System.out.print("\n");

        low = 0;

        high = amount-1;

        long startTime = System.nanoTime();

        quickSort(sortingArray, low, high, amount);

        long endTime = System.nanoTime();

        scanner.close();

        for (int i = 0; i < amount; i++){

            System.out.print(sortingArray[i] + " ");

        }

        System.out.print("\n");

        long duration = (endTime - startTime);

        System.out.println(duration/1000000);

    }

    public static void quickSort(int[] arr, int low, int high, int amount){

        if (low < high) {

            int partitionIndex = sorter(arr, low, high);

            quickSort(arr, low, partitionIndex - 1, amount);

            quickSort(arr, partitionIndex + 1, high, amount);

        }

    }

    public static int sorter (int[] sortingArray, int low, int high){

        /**Low is the value of the lowest index in the array (that is always 0) 
         * High is the value of the highest index in the array (size of the array - 1)
        */

        int divider = sortingArray[high];

        int i = low - 1;

        for (int j = low; j < high; j++){

            /**For this quick sort, I'm using the last element as the partitioning element
             * 
             */
            if (sortingArray[j] < divider){

                i++;

                int tempHolder = sortingArray[j];

                sortingArray[j] = sortingArray[i];

                sortingArray[i] = tempHolder;

            }

        }

        int tempHolder = sortingArray[i+1];

        sortingArray[i+1] = sortingArray[high];

        sortingArray[high] = tempHolder;

        return i+1;

    }

}