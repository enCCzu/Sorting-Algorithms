/**
 * Authors: Erin, Nathan, James Z., Oscar 
 * Description: The user can choose different sorting algorithms to sort a randomly generated array of the size they want
 * Teacher: Mr. Ho
 * Date: 22/10/21 
 */


// Importing packages 
import java.io.PrintWriter;
import java.util.Random; 
import java.util.Scanner; 


public class SortingAlgorithms {
  
  /** Written by Erin
    * Populates the array with random numbers
    * @param arr is the array to be populated 
    */
  public static void populateArray (int[] arr){
    Random randInt = new Random();
    for (int i : arr){
      arr[i] = randInt.nextInt(Integer.MAX_VALUE); 
    }
  }
  
  
  /** Written by Nathan 
    * Sorts a given integer array using insertion sort
    * @param arr is the int array to be sorted
    * @return the time it took to sort the array in the long type 
    */
  public static long insertionSort(int arr[]){
    int n = arr.length;
    long timeOne = System.currentTimeMillis();// gets the current time in miliseconds before sorting
    for (int i = 1; i < n; ++i) {
      int key = arr[i];
      int j = i - 1;
      
      /* Move elements of arr[0..i-1], that are
       greater than key, to one position ahead
       of their current position */
      while (j >= 0 && arr[j] > key) {
        arr[j + 1] = arr[j];
        j = j - 1;
      }
      arr[j + 1] = key;
    }
    long timeTwo = System.currentTimeMillis();// gets the current time in miliseconds after sorting
    long executionTime = timeTwo - timeOne; //subtracts the times to get the total execution time
    return executionTime;//prints the total execution time
  }
  
  
  /**Written by James Z.
    * Description: 
    * @param arr
    * @param low 
    * @param high
    */
  public static long quickSort(int[] arr, int low, int high){
    long time = System.currentTimeMillis();
    if (low < high) {
      
      int partitionIndex = sorter(arr, low, high);
      
      quickSort(arr, low, partitionIndex - 1);
      
      quickSort(arr, partitionIndex + 1, high);
      
    }
    return System.currentTimeMillis() - time; 
  }
  
  /** Written by James Z.
    * Description: 
    * @param sortingArray
    * @param low 
    * @param high
    */
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
  
  
  /** Written by Oscar 
   * Description: Merges two subarrays of arr[].
   * @param a Array that is to be sorted
   * @param beg Beginning index of array
   * @param mid Middle index of array
   * @param end End index of array
   */  
    public static void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
  
        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];
  
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
  
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }    
  
  /** Written by Oscar
   * Description: Main function that sorts arr[l..r] using merge()
       * @param a Array that is to be sorted
   * @param beg Beginning index of array
   * @param end End index of array
   */
    public static long mergeSort(int arr[], int l, int r)
    {
        long time = System.currentTimeMillis();
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;
  
            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
  
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
        return System.currentTimeMillis() - time; 
    }  
  
  
  /** Written by Erin
    * Sorts an int array using selection sort (brings the smallest value to the front) 
    * @param arr is the array to be sorted 
    * @return a long type which is the time it took for the array to be sorted 
    */
  public static long selectionSort(int[] arr){
    int smallestInt, temp; 
    long startTime = System.currentTimeMillis(); // taking the starting time 
    
    // Each iteration, there is less unsorted part of the array
    for (int i = 0; i < arr.length - 1; i++){
      
      // Find the smallest element in unsorted part of the array
      smallestInt = i; 
      for (int j = i + 1; j < arr.length; j++){
        if (arr[j] < arr[smallestInt]){
          smallestInt = j; 
          // swap the smallest element in the unsorted part of the array with the first element in the unsorted part of the array
          temp = arr[smallestInt]; 
          arr[smallestInt] = arr[i]; 
          arr[i] = temp; 
        }
      }
    }
    return (System.currentTimeMillis() - startTime); // ending time - starting time = how long it took to sort 
  }
  
  /** Written by Erin 
    * Is used when the user wants a csv file that contains predefined sizes of arrays and how much time it took to complete each
    * @param algorithmChoice is what sorting method the user chose 
    */
  public static void sortAllSizes(int algorithmChoice){
    // Catches any file errors 
    try{
      // Creating csv file 
      PrintWriter csvWriter = new PrintWriter("sizeTime.csv");
      csvWriter.println("Size,Time");
      // Declaring long type to store the time 
      long time; 
      
      // Looping through the predefined sizes (10000, 20000, 40000, 80000, 160000)
      for (int i = 10000; i <= 160000; i = i*2){
        // Creating a new array for each size 
        int[] arr = new int[i];
        // populating the newly generated array 
        populateArray(arr);
        
        // Checking to see what sorting method that the user chose 
        if (algorithmChoice == 1){
          time = insertionSort(arr);
        }
        else if (algorithmChoice == 2){
          time = quickSort(arr, 0, arr.length-1); 
        }
        else if (algorithmChoice == 3){
          time = mergeSort(arr, 0, arr.length-1); 
        }
        
        else{
          time = selectionSort(arr);
        }
        
        // Writing to the file 
        System.out.println(i + "," + time);
        csvWriter.println(i + "," + time);
      }
      // Closing the print writer 
      csvWriter.close(); 
    }
    // Catching any exceptions 
    catch (Exception e){
      e.printStackTrace(); // prints where the exception occured 
    }
    // Tells user that the file was created and ready to be opened 
    System.out.println("Data was written to file.");
  }
  
  /** Written by Nathan (with some edits & comments from Erin)
    * The main method - asks for user input 
    */
  public static void main(String args[]){
    // Declaring and initializing variables for user input 
    boolean validSelection = false;
    boolean intValidSelection = false;
    int selection = 0;
    int intSelection = 0;
    Scanner sc = new Scanner(System.in);
    
    // Declaring Long type variable to store how long it took each sorting method to sort the array 
    long time = -1; 
    
    // Asking user for which sorting algorithm they want to use 
    do{
      // Instructions 
      System.out.println("Which sorting algorithm would you like to use?\nEnter a number from 1-4 (1 = Insertion Sort, 2 = Quick Sort, 3 = Merge Sort, 4 = Selection sort");
      
      // To make sure that the user input a number 
      while(!sc.hasNextInt()) {
        System.out.println("Enter a number!");
        sc.next();
      }
      // Getting user input 
      selection = sc.nextInt();
      
      // Making sure the user input a proper number 
      if(selection > 0 && selection < 5){
        validSelection = true;
      }
    } while(validSelection == false);
    // Telling user what they input 
    System.out.println("You have selected: " + selection);
    
    // do while loop to ask how many integers the user wants to sort 
    do{
      System.out.println("How many random integers would you like to sort?\nEnter -1 if you want a csv file with predetermined sizes and corresponding execution times.");
      
      // Making sure they eneter a number 
      while(!sc.hasNextInt()) {
        System.out.println("Enter a number!");
        sc.next();
      }
      // Getting number 
      intSelection = sc.nextInt();
      
      // Checking what they input
      // If -1, call the method that sorts all predetermined sizes and produces a csv file 
      if (intSelection == -1){
        sortAllSizes(selection);
        intValidSelection = true;
      }
      // If they input a positive value or 0, then sort normally 
      else if(intSelection >= 0){
        // Telling user the size of the array 
        System.out.println("You have selected " + intSelection + " random integers to be generated");
        // To stop the while loop 
        intValidSelection = true;
        
        // Creating array
        int[] intArray = new int[intSelection];
        // Populating array with random integers 
        populateArray(intArray);
        
        // checking what sorting method they chose and getting the sorting time 
        if (selection == 1){
          time = insertionSort(intArray);
          intValidSelection = true;
        }
        else if (selection == 2){
          time = quickSort(intArray, 0, intArray.length-1); 
          intValidSelection = true;
        }
        else if (selection == 3){
          time = mergeSort(intArray, 0, intArray.length-1); 
          intValidSelection = true;
        }
        else if (selection == 4){
          time = selectionSort(intArray);
          intValidSelection = true;
        }
        // Outputting results 
        System.out.println("The smallest value is: " + intArray[0]);
        System.out.println("The largest value is: " + intArray[intArray.length-1]);
        System.out.println("Total time to sort the data was: " + time + " ms.");
      }
      else {
        System.out.println("You have entered an invalid number."); 
        continue;
      }
      // If they enter a negative number under -1, then they must input another number 
    }while(intValidSelection == false);
    
  }
}
