import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-5, 7, 1, 3, 9, 2};
        System.out.printf("Array before quickSort: %s%n", Arrays.toString(arr));
        quicksort(arr, 0, arr.length - 1);
        System.out.printf("Array after quickSort:  %s%n", Arrays.toString(arr));
    }

    public static void quicksort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = arr[(left + right) / 2];                //Choose middle Element as pivot
        int index = partition(arr, left, right, pivot);
        quicksort(arr, left, index - 1);
        quicksort(arr, index, right);
    }

    public static int partition(int[] arr, int left, int right, int pivot) {
        while (left <= right) {
            while (arr[left] < pivot) {
                left++;
            }
            while (arr[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = arr[left];               // temporary storing element in temp variable to insert on at
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }
}
