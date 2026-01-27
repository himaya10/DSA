public class OptimizedQuickSort {

    // Optimized Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        while (low < high) {
            int pivotIndex = partition(arr, low, high);

            // Tail call elimination: recurse on smaller half
            if (pivotIndex - low < high - pivotIndex) {
                quickSort(arr, low, pivotIndex - 1);
                low = pivotIndex + 1;
            } else {
                quickSort(arr, pivotIndex + 1, high);
                high = pivotIndex - 1;
            }
        }
    }

    // Median-of-three pivot for optimization
    private static int medianOfThree(int[] arr, int low, int high) {
        int mid = (low + high) / 2;

        if (arr[low] > arr[mid]) 
            swap(arr, low, mid);
        if (arr[mid] > arr[high]) 
            swap(arr, mid, high);
        if (arr[low] > arr[mid]) 
            swap(arr, low, mid);

        return mid;
    }

    // Partitioning logic
    private static int partition(int[] arr, int low, int high) {
        int medianIndex = medianOfThree(arr, low, high);
        swap(arr, medianIndex, high);
        int pivot = arr[high];

        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    // Swap function
    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    // Main Class
    public static void main(String[] args) {
        int[] arr = {45, 10, 7, 90, 2, 50, 1};

        System.out.println("Before Sorting:");
        for (int n : arr) System.out.print(n + " ");

        quickSort(arr, 0, arr.length - 1);

        System.out.println("\nAfter Sorting:");
        for (int n : arr) System.out.print(n + " ");
    }
}
