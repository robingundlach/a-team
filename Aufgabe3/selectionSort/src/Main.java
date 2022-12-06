import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] unsortedArray = {8, 7, 5, 3, 1, 9, 6, 4, 2};
        System.out.printf("UnsortedArray: %s%n",Arrays.toString(unsortedArray));
        System.out.printf("SortedArray:   %s%n",Arrays.toString(selectionSort(unsortedArray)));
    }
    public static int[] selectionSort(int[] unsortedArray){
        for (int i = 0; i< unsortedArray.length -1; i++){

            for (int j = i+1; j < unsortedArray.length; j++) {

                if (unsortedArray[j] < unsortedArray[i]) {  //Switch Elements of Array
                    int key = unsortedArray[i];
                    unsortedArray[i] = unsortedArray[j];
                    unsortedArray[j] = key;
                }
            }
        }
        return unsortedArray;
    }
}