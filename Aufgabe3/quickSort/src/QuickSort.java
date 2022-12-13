import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {6, 7, 1, 3, 9, 2, -3};
        System.out.printf("Array before quickSort: %s%n", Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.printf("Array after quickSort:  %s%n", Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = arr[(left + right) / 2];                //Choose middle Element as pivot
        int index = partition(arr, left, right, pivot);     //Assign index of left
        quickSort(arr, left, index - 1);              //Recursive call going left
        quickSort(arr, index, right);                      //Recursive call going right
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
