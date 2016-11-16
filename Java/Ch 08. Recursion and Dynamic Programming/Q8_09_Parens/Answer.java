import java.util.ArrayList;
import java.util.Set;

/**
 * Created by xiong on 11/16/2016.
 */
public class Answer {
    public static ArrayList<String> generateParens(int n) {
        if (n == 0) return null;
        return generateParens(n, n);
    }

    public static ArrayList<String> generateParens(int left, int right) {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> subResult1;
        ArrayList<String> subResult2;
        if (left == 0 && right == 1) {
            result.add(")");
            return result;
        }
        if (left == right || left >= 1) {
            subResult1 = generateParens(left - 1, right);
            for (String s : subResult1) {
                result.add("(" + s);
            }
        }
        if (left == right) {
            return result;
        } else {
            subResult2 = generateParens(left, right - 1);
            for (String s : subResult2) {
                result.add(")" + s);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        ArrayList<String> list = generateParens(4);
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println(list.size());
    }
}
