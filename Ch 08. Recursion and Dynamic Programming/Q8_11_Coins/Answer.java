/**
 * Created by xiong on 11/16/2016.
 */
package Q8_11_Coins;

public class Answer {
    public static int makeChange(int i, int[] denoms) {
        int[][] map = new int[i + 1][denoms.length];
        return makeChange(i, denoms, 0, map);
    }

    public static int makeChange(int i, int[] denoms, int index, int[][] map) {
        int result = 0;
        if (i == 0) {
            return 1;
        }
        if (index >= denoms.length) {
            return 0;
        }

        if (map[i][index] > 0) {
            return map[i][index];
        }
        // This part is redundant. Because it is included in the condition which times equals to 0

//        while (i < denoms[index]){
//            index++;
//            if (index >= denoms.length){
//                return 0;
//            }
//        }
        int times = 0;
        while (i >= denoms[index] * times) {
            result += makeChange(i - denoms[index] * times, denoms, index + 1, map);
            times++;
        }
        map[i][index] = result;
        return result;
    }
}
