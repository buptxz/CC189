/**
 * Created by xiong on 11/8/2016.
 */
package Q5_04_Next_Number;

public class Answer {

    public static int getPrev(int value) {
        // Looking for first "10" from right to left. Then switch them. If not found, return the number itself.
        int mask = 1;
        int index = 0;
        int numOfOne = 0;
        int numOfZero = 0;
        while (index < Integer.BYTES * 8 - 2) {
            int rightMask = mask << index;
            int leftMask = mask << (index + 1);
            if ((value & rightMask) == 0 && (value & leftMask) != 0) {
                // Watch out. At first I use left == 1. Under the mask, the left won't be 1.
                // Watch out #2. At first I didn't define rightMask, but right = value & (mask << index),
                // Then later I use right to change value. This is because I didn't name the variable right.
                // If I named them right, I won't use them incorrectly.
                value = value | rightMask;
                value = value & ~leftMask;
                int newMask = ~(rightMask - 1);
                value = value & newMask;
                int tail = 0;
                for (int i = 0; i < numOfOne; i++) {
                    tail += Math.pow(2, i + numOfZero);
                }
                value += tail;
                return value;
            } else {
                if ((value & rightMask) == 0) {
                    numOfZero++;
                } else {
                    numOfOne++;
                }
            }
            index++;
        }
        return -1;
    }

    public static int getNext(int value) {
        // Looking for first "01" from right to left. Then switch them. If not found, return the number itself.
        int mask = 1;
        int index = 0;
        int numOfOne = 0;
        int numOfZero = 0;
        while (index < Integer.BYTES * 8 - 2) {
            int rightMask = mask << index;
            int leftMask = mask << (index + 1);
            if ((value & rightMask) != 0 && (value & leftMask) == 0) {
//                value = value & ~rightMask;
//                value = value | leftMask;
                // Implement Arithmetic method instead
                value += (1 << index);
                int newMask = ~(rightMask - 1);
                value = value & newMask;
                int tail = 0;
                for (int i = 0; i < numOfOne; i++) {
                    tail += Math.pow(2, i);
                }
                value += tail;
                return value;
            } else {
                if ((value & rightMask) == 0) {
                    numOfZero++;
                } else {
                    numOfOne++;
                }
            }
            index++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int i = 6;
        int p1 = getPrev(i);
        int n1 = getNext(i);
        Tester.binPrint(p1);
        Tester.binPrint(n1);
    }
}
