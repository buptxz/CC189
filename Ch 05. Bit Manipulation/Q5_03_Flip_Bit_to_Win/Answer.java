/**
 * Created by xiong on 11/8/2016.
 */
package Q5_03_Flip_Bit_to_Win;

public class Answer {
    // My logic is a little bit trick. It is similar to the optimal algorithm in the book. But my logic is more complex.
    // And more likely to make mistakes.
    public static int longestSequence(int value) {
        int index = 1;
        int first = 0; // This is current length.
        int second = 0; // This is previous length.
        int max = 1; // We can always have a sequence with length of 1.
        while (index != 0) {
            int cur = (value & index) != 0 ? 1 : 0;
            if (cur == 1) {
                // Current bit is 1.
                first++;
                if (second != 0) {
                    second++;
                }
            } else {
                // Current bit is 0.
                if (first != 0) {
                    max = second > max ? second : max;
                    second = first + 1;
                    first = 0;
                } else {
                    max = second > max ? second : max;
                    second = 1;
                }
            }
            index = index << 1;
        }
        max = Math.max(first, second) > max ? Math.max(first, second) : max;
        return max;
    }
//    public static int longestSequence(int value) {
//        if (value == 0) return 1;
//        return Math.max(longestSequence1(value), longestSequence2(value));
//    }
//    public static int longestSequence1(int value) {
//        int index = 1;
//        int first = 0;
//        int second = 0;
//        int max = 0;
//        while (index != 0) {
//            int cur = (value & index) != 0 ? 1 : 0;
//            if (cur == 1) {
//                first++;
//                if (second != 0) {
//                    second++;
//                }
//            } else {
//                if (first != 0) {
//                    max = second > max ? second : max;
//                    second = first + 1;
//                    first = 0;
//                } else {
//                    max = second > max ? second : max;
//                    second = 0;
//                }
//            }
//            index = index << 1;
//        }
//        max = Math.max(first, second) > max ? Math.max(first, second) : max;
////        System.out.println(max);
//        return max;
//    }
//    public static int longestSequence2(int value) {
//        int index = 1 << 31;
//        int first = 0;
//        int second = 0;
//        int max = 0;
//        while (index != 0) {
//            int cur = (value & index) != 0 ? 1 : 0;
//            if (cur == 1) {
//                first++;
//                if (second != 0) {
//                    second++;
//                }
//            } else {
//                if (first != 0) {
//                    max = second > max ? second : max;
//                    second = first + 1;
//                    first = 0;
//                } else {
//                    max = second > max ? second : max;
//                    second = 0;
//                }
//            }
//            index = index >>> 1;
//        }
//        max = Math.max(first, second) > max ? Math.max(first, second) : max;
////        System.out.println(max);
//        return max;
//    }

}
