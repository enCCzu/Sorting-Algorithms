public static long selectionSort(int[] arr){
  int smallestInt, temp; 
  
  // One by one move boundary of unsorted part of the array
  for (int i = 0; i < arr.length - 1; i++){
    
    // Find the minimum element in unsorted part of the array
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
  return (System.currentTimeMillis()); 
}
