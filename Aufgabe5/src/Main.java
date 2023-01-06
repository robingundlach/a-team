import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};

        Heap.buildHeap(a);
        System.out.println(Arrays.toString(a));

        Heap.heapSort(a);
        System.out.println(Arrays.toString(a));
    }
}