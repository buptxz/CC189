package Q8_03_Magic_Index;

import CtCILibrary.AssortedMethods;

import java.util.Arrays;

/**
 * Created by xiong on 11/13/2016.
 */
public class AnswerB {
    public static int magicSlow(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == i) {
                return i;
            }
        }
        return -1;
    }

    public static int magicFast(int[] array) {
        return magicFast(array, 0, array.length - 1);
    }

    public static int magicFast(int[] array, int left, int right){
        if (left > right) return -1;
        int midIndex = (int) Math.ceil((left + right) / 2);
        if (array[midIndex] == midIndex) {
            return midIndex;
        }
        int newRight = Math.min(midIndex - 1, array[midIndex]);
        if (magicFast(array, left, newRight) != -1) {
            return magicFast(array, left, newRight);
        }
        int newLeft = Math.max(midIndex + 1, array[midIndex]);
        if (magicFast(array, newLeft, right) != -1) {
            return magicFast(array, newLeft, right);
        }
        return -1;
    }

    /* Creates an array that is sorted */
    public static int[] getSortedArray(int size) {
        int[] array = AssortedMethods.randomArray(size, -1 * size, size);
        Arrays.sort(array);
        return array;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            int size = AssortedMethods.randomIntInRange(5, 20);
            int[] array = getSortedArray(size);
            int v2 = magicFast(array);
            if (v2 == -1 && magicSlow(array) != -1) {
                int v1 = magicSlow(array);
                System.out.println("Incorrect value: index = -1, actual = " + v1 + " " + i);
                System.out.println(AssortedMethods.arrayToString(array));
                break;
            } else if (v2 > -1 && array[v2] != v2) {
                System.out.println("Incorrect values: index= " + v2 + ", value " + array[v2]);
                System.out.println(AssortedMethods.arrayToString(array));
                break;
            }
        }
    }
}
