import CtCILibrary.AssortedMethods;

/**
 * Created by xiong on 11/7/2016.
 */
public class Answer {
    public static int updateBits(int a, int b, int i, int j) {
        int mask =  ~(((1 << (j - i + 1)) - 1) << i);
        return (a & mask) | (b << i);
    }

    public static void main(String[] args) {
        int a = 103217;
        System.out.println(AssortedMethods.toFullBinaryString(a));
        int b = 13;
        System.out.println(AssortedMethods.toFullBinaryString(b));
        int c = updateBits(a, b, 4, 12);
        System.out.println(AssortedMethods.toFullBinaryString(c));
    }
}
