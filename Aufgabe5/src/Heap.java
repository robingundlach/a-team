import java.util.Arrays;

class Heap {
    // Builds a heap from an array a
    public static void buildHeap(int[] a) {
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            heapify(a, a.length, i);
        }
    }

    // Heapifies a subtree rooted at index i
    public static void heapify(int[] a, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // If the left child is larger than the root
        if (left < n && a[left] > a[largest]) {
            largest = left;
        }

        // If the right child is larger than the largest so far
        if (right < n && a[right] > a[largest]) {
            largest = right;
        }

        // If the largest is not the root
        if (largest != i) {
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;

            // Recursively heapify the affected subtree
            heapify(a, n, largest);
        }
    }

    // Sorts an array a using heap sort
    public static void heapSort(int[] a) {
        // Builds a heap from the array
        buildHeap(a);

        // Extracts elements one by one from the heap
        for (int i = a.length - 1; i > 0; i--) {
            // Moves the current root to the end
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;

            // Calls heapify on the reduced heap
            heapify(a, i, 0);
        }
    }
}
