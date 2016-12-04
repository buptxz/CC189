/**
 * Created by xiong on 12/3/2016.
 */
package Q10_08_Find_Duplicates;

import CtCILibrary.AssortedMethods;
import java.util.BitSet;

public class Answer {
    public static void checkDuplicates(int[] array) {
        MyBitSet map = new MyBitSet(32001);
        int length = array.length;
        for(int i = 0; i < length; i++) {
            if (map.get(array[i])) {
                System.out.println(array[i]);
            } else {
                map.set(array[i]);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = AssortedMethods.randomArray(30, 1, 30);
        System.out.println(AssortedMethods.arrayToString(array));
        checkDuplicates(array);
    }
}
