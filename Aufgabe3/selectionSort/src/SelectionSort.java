import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {

        int[] arr = {14, 2, -133, 100, 1, 19};
        System.out.printf("Array before selectionSort: %s%n", Arrays.toString(arr));
        selectionSort(arr);
        System.out.printf("Array before selectionSort: %s%n", Arrays.toString(arr));
    }

    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            // kleinstes Element im Array suchen
            int positionMin = i;
            int min = array[positionMin];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) { //vergleich Array Element
                    positionMin = j;
                    min = array[positionMin];
                }
            }
            // Elemente tauschen
            array[positionMin] = array[i];
            array[i] = min;
        }
        return array;
    }
}
