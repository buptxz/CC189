/**
 * Created by xiong on 11/21/2016.
 */
package Q10_01_Sorted_Merge;

import CtCILibrary.AssortedMethods;

public class Answer {
    public static void merge(int[] a, int[] b, int sizeA, int sizeB) {
        int indexA = sizeA - 1;
        int indexB = sizeB - 1;
        int index = sizeA + sizeB - 1;
        while ( indexB >= 0) {
            if (indexA >= 0 && a[indexA] >= b[indexB]) {
                a[index] = a[indexA];
                indexA--;
            } else {
                a[index] = b[indexB];
                indexB--;
            }
            index--;
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 4, 5, 6, 8, 10, 100, 0, 0, 0, 0, 0, 0};
        int[] b = {1, 4, 7, 6, 7, 7};
        merge(a, b, 8, 6);
        System.out.println(AssortedMethods.arrayToString(a));
    }
}
