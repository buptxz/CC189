/**
 * Created by xiong on 11/17/2016.
 */
package Q8_14_Boolean_Evaluation;

import java.util.HashMap;

public class Answer {
    public static int count = 0;

    public static boolean stringToBool(String c) {
        return c.equals("1") ? true : false;
    }

    public static int countEval(String expression, boolean result) {
        HashMap<String, Integer> map = new HashMap<>();
        return countEval(expression, result, map);
    }

    public static int countEval(String expression, boolean result, HashMap<String, Integer> map) {
        if (map.containsKey(expression + result)) {
            return map.get(expression + result);
        }
        int ways = 0;
        if (expression.length() % 2 == 0) {
            return -1;
        }
        if (expression.length() == 1) {
            return stringToBool(expression) == result ? 1 : 0;
        }
        for (int index = 1; index <= expression.length() - 2; index += 2) {
            String left = expression.substring(0, index);
            String right = expression.substring(index + 1);
            if (result == true) {
                if (expression.charAt(index) == '&') {
                    ways += countEval(left, true) * countEval(right, true);
                } else if (expression.charAt(index) == '|') {
                    ways += (countEval(left, true) + countEval(left, false)) *
                            (countEval(right, true) + countEval(right, false)) -
                            countEval(left, false) * countEval(right, false);
                } else {
                    ways += countEval(left, true) * countEval(right, false) +
                            countEval(left, false) * countEval(right, true);
                }
            } else {
                if (expression.charAt(index) == '&') {
                    ways += (countEval(left, true) + countEval(left, false)) *
                            (countEval(right, true) + countEval(right, false)) -
                            countEval(left, true) * countEval(right, true);
                } else if (expression.charAt(index) == '|') {
                    ways += countEval(left, false) * countEval(right, false);
                } else {
                    ways += countEval(left, true) * countEval(right, true) +
                            countEval(left, false) * countEval(right, false);
                }
            }
        }
        map.put(expression + result, ways);
        return ways;
    }

    public static void main(String[] args) {
        String expression = "0^0^0&1|1";
        boolean result = true;

        System.out.println(countEval(expression, result));
        System.out.println(count);
    }
}

