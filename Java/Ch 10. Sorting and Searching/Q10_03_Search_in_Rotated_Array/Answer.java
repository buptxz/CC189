/**
 * Created by xiong on 11/21/2016.
 */
public class Answer {
    public static int search(int[] arr, int a) {
        int right = arr.length - 1;
        int left = 0;
        return search(arr, a, left, right);
    }

    public static int search(int[] arr, int a, int left, int right) {
        if (left > right) return -1;
        int mid = (left + right) / 2;
        if (a == arr[mid]){
            return mid;
        }
        if (arr[left] < arr[mid] || (arr[left] == arr[mid] && arr[mid] > arr[right])) {
            if (a >= arr[left] && a < arr[mid]) {
                return search(arr, a, left, mid - 1);
            } else {
                return search(arr, a, mid + 1, right);
            }
        } else if (arr[left] > arr[mid] || (arr[left] == arr[mid] && arr[mid] < arr[right])) {
            if (a < arr[left] && a > arr[mid]) {
                return search(arr, a, mid + 1, right);
            } else {
                return search(arr, a, left, mid - 1);
            }
        } else {
            return search(arr, a, left + 1, right - 1);
        }
    }

    public static void main(String[] args) {
        int[] a = { 2, 3, 1, 2, 2, 2, 2, 2 , 2 , 2 };

        System.out.println(search(a, 2));
        System.out.println(search(a, 3));
        System.out.println(search(a, 4));
        System.out.println(search(a, 1));
        System.out.println(search(a, 8));
    }
}
