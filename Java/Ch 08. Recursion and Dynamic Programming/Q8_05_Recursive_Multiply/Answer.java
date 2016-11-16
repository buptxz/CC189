/**
 * Created by xiong on 11/14/2016.
 */
public class Answer {
    public static int counter = 0;

    public static int minProduct(int a, int b) {
        if (a == 0) return 0;
        counter++;
        return b + minProduct(a - 1, b);

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
