package Q10_04_Sorted_Search_No_Size.Arrayish;

/**
 * Created by xiong on 11/22/2016.
 */
public class Answer {
    public static int search(Listy list, int a) {
        if (a == list.elementAt(0)) return 0;
        int index = 1;
        while (list.elementAt(index) != -1) {
            if (list.elementAt(index) == a) {
                return index;
            } else if (list.elementAt(index) > a){
                return binarySearch(list, a, index / 2, index);
            } else {
                index *= 2;
            }
        }
        return binarySearch(list, a, index / 2, index);
    }

    public static int binarySearch(Listy list, int a, int left, int right) {
        if (left > right) return -1;
        int mid = (left + right) / 2;
        if (list.elementAt(mid) == a) {
            return mid;
        } else if (list.elementAt(mid) == -1 || a < list.elementAt(mid)) {
            return binarySearch(list, a, left, mid - 1);
        } else {
            return binarySearch(list, a, mid + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 16, 18};
        Listy list = new Listy(array);
        for (int a : array) {
            System.out.println(search(list, a));
        }
        System.out.println(search(list, 15));
    }
}
