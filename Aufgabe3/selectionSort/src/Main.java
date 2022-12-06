import java.util.Arrays;


public class Main {
    public static void main(String[] args) {

        int[] unsortiert = {14, 2, -133, 100, 1, 19};
        System.out.printf("Unsortiertes Array: %s,%n", Arrays.toString(unsortiert));

        int[] sortiert = selectionSort(unsortiert);
        System.out.printf("Sortiertes Array:   %s,%n", Arrays.toString(sortiert));

    }

    public static int[] selectionSort(int[] sortieren) {
        for (int i = 0; i < sortieren.length - 1; i++) {

            // kleinstes Element im Array suchen
            int positionMin = i;
            int min = sortieren[positionMin];
            for (int j = i + 1; j < sortieren.length; j++) {
                if (sortieren[j] < min) {
                    positionMin = j;
                    min = sortieren[positionMin];
                }
            }

            // Elemente tauschen
            sortieren[positionMin] = sortieren[i];
            sortieren[i] = min;
        }

        return sortieren;
    }
}