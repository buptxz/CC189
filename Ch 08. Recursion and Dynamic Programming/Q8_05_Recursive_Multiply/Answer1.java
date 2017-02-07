/**
 * Created by xiong on 11/14/2016.
 */

package Q8_05_Recursive_Multiply;

public class Answer1 {
    public static int counter = 0;

    public static int minProduct(int a, int b) {
        int result = 0;
        while (b != 0) {
            counter++;
            if ((b & 1) == 1) {
                result += a;
            }
            b = b >> 1;
            a = a << 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int a = 13494;
        int b = 22323;
        int product = a * b;
        int minProduct = minProduct(a, b);
        if (product == minProduct) {
            System.out.println("Success: " + a + " * " + b + " = " + product);
        } else {
            System.out.println("Failure: " + a + " * " + b + " = " + product + " instead of " + minProduct);
        }
        System.out.println("Adds: " + counter);
    }
}
