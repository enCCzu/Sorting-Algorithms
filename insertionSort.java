    public static void insertionSort(int arr[]){
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
        System.out.println(arr[0]);//prints the smallest number in the array
        System.out.println(arr[arr.length-1]);//prints the largest number in the array
        
        System.out.println(executionTime);//prints the total execution time
    }