package darkRealm.CTCI.BigO;

/**
 * Created by Jayam on 8/29/2016.
 */
public class MergeSort {

    private static int[] _temp;

    public static int[] mergeSort(int[] arr) {

        _temp = new int[arr.length];
        sort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            sort(arr, low, mid);
            sort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        // need var to hold/increment from low,mid,high
        int f = low;//for index of first half
        int s = mid + 1; // for index of second half
        int i = low; //for index of newly merged array

        while ((f <= mid) && (s <= high)) {
            if (arr[f] < arr[s]) {  // first halfs element is smaller, so pick it & place in new array
                _temp[i] = arr[f];
                f++;
            } else {
                _temp[i] = arr[s++];    // Second halfs element is smaller, so pick it & place in new array
            }
            i++;    //increment index for new array
        }

        //after the loop is done, we check if any half is remaining, if yes we put whatever is left of that part

        if (f > mid)// first half is completely used, so now push second half elements
        {
            while (s <= high) {
                _temp[i++] = arr[s++];
            }
        }
        if (s > high) // second half is completely used, so now push first half elements
        {
            while (f <= mid) {
                _temp[i++] = arr[f++];
            }
        }

        //now copy the temp arrays sroted content to the original array
        for (int j = low; j <= high; j++) {
            arr[j] = _temp[j];
        }
    }

}
