public class OptimizedInsertionSort {

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            // Shift elements greater than key
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;  // Insert key
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, 3, 5, 1, 4};

        insertionSort(arr);

        System.out.println("Optimized Insertion Sort Result:");
        for (int n : arr) System.out.print(n + " ");
    }
}
