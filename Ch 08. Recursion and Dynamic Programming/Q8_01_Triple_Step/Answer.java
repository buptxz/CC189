/**
 * Created by xiong on 11/10/2016.
 */
package Q8_01_Triple_Step;

public class Answer {
    // Recursive method
//    public static int countWays(int f) {
//        if (f == 0) return 0;
//        if (f == 1) return 1;
//        if (f == 2) return 2;
//        if (f == 3) return 4;
//        return countWays(f - 1) + countWays(f - 2) + countWays(f - 3);
//    }

    public static int countWays(int f) {
        if (f == 0) return 0;
        if (f == 1) return 1;
        if (f == 2) return 2;
        if (f == 3) return 4;
        int a = 1, b = 2, c = 4;
        int d = 0;
        for (int i = 4; i <= f; i++) {
            d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        return d;
    }
}
