package Q8_04_Power_Set;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by xiong on 11/13/2016.
 */
public class Answer {

    public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> list) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int mask = 0;
        for (int i = 0; i < Math.pow(2, list.size()); i++){
            ArrayList<Integer> subset = new ArrayList<>();
            for (int j = 0; j < list.size(); j++) {
                int temp = mask;
                if (temp != 0 && (((temp >> j) & 1) == 1)) {
                    subset.add(list.get(j));
                }
            }
            result.add(subset);
            mask++;
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++) {
            list.add(i);
        }
        ArrayList<ArrayList<Integer>> subsets = getSubsets(list);
        System.out.println(subsets.toString());
    }
}
