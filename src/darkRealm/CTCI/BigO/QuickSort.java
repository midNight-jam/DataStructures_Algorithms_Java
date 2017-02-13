package darkRealm.CTCI.BigO;

/**
 * Created by Jayam on 8/29/2016.
 */
public class QuickSort {

    public static int[] doQuickSort(int[] arr) {
        return quickSort(arr, 0, arr.length - 1);
    }

    private static int[] quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
        return arr;
    }

    private static int partition(int[] arr, int low, int high) {
        while (low < high) {
            int pivot = arr[high];
            while (arr[low] < pivot) { // skip all that are low than the pivot
                low++;
            }
            while (arr[high] > pivot) {// skip all that are bigger than the pivot
                high--;
            }
            if (arr[low] == arr[high]) {    // if low equals high, increment low
                low++;
            } else if (low < high) {  // means we have to swap to get the highest no to its correct position
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
            }
        }
        return high;
    }

    /*================GENERIC ATTEMPT=================*/

    public static Comparable[] doQuickSort(Comparable[] arr) {
        return quickSort(arr, 0, arr.length - 1);
    }

    private static Comparable[] quickSort(Comparable[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
        return arr;
    }

    private static int partition(Comparable[] arr, int low, int high) {
        while (low < high) {
            Comparable pivot = arr[high];
            while (arr[low].compareTo(pivot) < 0) { // skip all that are low than the pivot
                low++;
            }
            while (arr[high].compareTo(pivot) > 0) {// skip all that are bigger than the pivot
                high--;
            }
            if (arr[low].compareTo(arr[high]) == 0) {    // if low equals high, increment low
                low++;
            } else if (low < high) {  // means we have to swap to get the highest no to its correct position
                Comparable temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
            }
        }
        return high;
    }
}