package by.sel;

/** 704. 二分查找 */
public class Q704BinarySearch {

    public static int search(int[] arr, int val) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        do {
            if (left > right) {
                return -1;
            }
            if (left == right) {
                return arr[left] == val ? left : -1;
            }
            mid = left + (right - left) / 2;
            if (arr[mid] == val) {
                return mid;
            } else if (arr[mid] < val) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        } while (true);
    }

    // public static int search(int[] arr, int val) {
    //     return recursionSearch(arr, val, 0, arr.length - 1);
    // }

    public static int recursionSearch(int[] arr, int val, int left, int right) {
        if (left > right) {
            return -1;
        }
        if (left == right) {
            return arr[left] == val ? left : -1;
        }
        int mid = left + (right - left) / 2;
        if (arr[mid] == val) {
            return mid;
        } else if (arr[mid] < val) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
        return recursionSearch(arr, val, left, right);
    }
}
