public class Main {
    public static void main(String[] args) {
        int[] unsortedArray = {8, 7, 5, 3, 1, 9, 6, 4, 2};
        System.out.printf("UnsortedArray: %s%n",Arrays.toString(unsortedArray));
        System.out.printf("SortedArray:   %s%n",Arrays.toString(selectionSort(unsortedArray)));
    }
}