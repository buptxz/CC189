/**
 * Created by xiong on 11/22/2016.
 */
public class Answer {
    public static int search(String[] stringList, String s) {
        int left = 0;
        int right = stringList.length - 1;
        return search(stringList, s, left, right);
    }

    public static int search(String[] stringList, String s, int left, int right) {
        if (left > right) return -1;
        int mid = (left + right) / 2;
        while (stringList[mid] == "" && mid >= left) {
            mid--;
        }
        if (stringList[mid] == "" || s.compareTo(stringList[mid]) > 0) {
            return search(stringList, s, (left + right) / 2 + 1, right);
        } else if (s.compareTo(stringList[mid]) < 0) {
            return search(stringList, s, left, mid - 1);
        } else {
            return mid;
        }
    }


    public static void main(String[] args) {
        String[] stringList = {"apple", "", "", "banana", "", "", "", "carrot", "duck", "", "", "eel", "", "flower"};
        System.out.println(search(stringList, "ac"));

        for (String s : stringList) {
        	String cloned = new String(s);
        	System.out.println("<" + cloned + "> " + " appears at location " + search(stringList, cloned));
        }
    }
}
