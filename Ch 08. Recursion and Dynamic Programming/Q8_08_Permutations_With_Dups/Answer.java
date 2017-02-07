import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by xiong on 11/15/2016.
 */
public class Answer {
    public static HashMap<Character, Integer> cal(String s) {
        HashMap<Character, Integer> statistic = new HashMap<>();
        for (int index = 0; index < s.length(); index++) {
            if(!statistic.containsKey(s.charAt(index))) {
                statistic.put(s.charAt(index), 1);
            } else {
                statistic.put(s.charAt(index), statistic.get(s.charAt(index)) + 1);
            }
        }
        return statistic;
    }

    public static ArrayList<String> printPerms(String s) {
//
        HashMap<Character, Integer> statistic = cal(s);
        return printPerms(statistic);
    }

    public static ArrayList<String> printPerms(HashMap<Character, Integer> statistic) {
        ArrayList<String> result = new ArrayList<>();
        int count = 0;
        for (Character c : statistic.keySet()) {
            if (statistic.get(c) > 0) {
                count++;
            }
        }
//        if (count == 1) {
//            String onlyResult = null;
//            onlyResult = new String(new char[statistic.get(temp.toCharArray())]).replace("\0", temp);
//            result.add(onlyResult);
//            return result;
//        }
        if (count <= 1) {
            String onlyKey = null;
            int count2 = 0;
            for ( Character key : statistic.keySet() ) {
                if (statistic.get(key) > 0) {
                    onlyKey = key.toString();
                    count2 = statistic.get(key);
                }
            }
            String onlyResult = null;
            onlyResult = new String(new char[count2]).replace("\0", onlyKey);
            result.add(onlyResult);
            return result;
        }
        for (Character c : statistic.keySet()) {
            if (statistic.get(c) == 0) {
                continue;
            }
            statistic.put(c, statistic.get(c) - 1);
            ArrayList<String> subResult = printPerms(statistic);
            for (String subS : subResult) {
                result.add(c.toString() + subResult);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "abbbbb";
        ArrayList<String> result = printPerms(s);
        System.out.println("Count: " + result.size());
        for (String r : result) {
            System.out.println(r);
        }
    }

}
