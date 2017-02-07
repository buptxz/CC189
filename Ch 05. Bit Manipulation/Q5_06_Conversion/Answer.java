package Q5_06_Conversion;

import CtCILibrary.AssortedMethods;

/**
 * Created by xiong on 11/8/2016.
 */
public class Answer {
    public static int bitSwapRequired(int a, int b) {
        int c = a ^ b;
        int result = 0;
        while (c != 0) {
            if ((c & 1) == 1) {
                result++;
            }
            c >>>= 1;
        }
        return result;
    }
    public static void main(String[] args) {
        int a = -23432;
        int b = 512132;
        System.out.println(a + ": " + AssortedMethods.toFullBinaryString(a));
        System.out.println(b + ": " + AssortedMethods.toFullBinaryString(b));
        System.out.println("Required number of bits: " + bitSwapRequired(a, b));
    }
}
