package SortingLab;
import java.util.Random;
import java.util.Scanner;
  
public class SortingLab {

    public static void main(String[] args) {
        boolean validSelection = false;
        boolean intValidSelection = false;
        int selection = 0;
        int intSelection = 0;
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();


        while(validSelection == false){
            System.out.println("Which sorting algorith would you like to use? Enter a number from 1-4 (1 = Insertion Sort, 2 = Quick Sort, 3 = Merge Sort, 4 = Selection sort");
            selection = sc.nextInt();
            if(selection > 0 && selection < 5){
                validSelection = true;
            }
            else{
                validSelection = false;
            }
        }
        System.out.println("You have selected: " + selection);

        

        
        do{
            System.out.println("How many random integers would you like to sort?");
            intSelection = sc.nextInt();
            System.out.println();
            if(intSelection <= 0){
                intValidSelection = false;
                System.out.println("You have selected an invalid number. Please select a number greater than -1");
            }
            else{
                intValidSelection = true;
            }
        }while(intValidSelection == false);

        System.out.println("You have selected " + intSelection + " random integers to be generated");
        int[] intArray = new int[intSelection];

        for(int i = 0; i < intSelection; i++){
            intArray[i] = rand.nextInt(Integer.MAX_VALUE);
            //System.out.println(intArray[i]);
        }
    }
}
