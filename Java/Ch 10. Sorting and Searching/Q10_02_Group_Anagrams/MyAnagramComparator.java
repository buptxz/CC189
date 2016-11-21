/**
 * Created by xiong on 11/21/2016.
 */
package Q10_02_Group_Anagrams;

import java.util.Comparator;
import java.util.Arrays;

public class MyAnagramComparator implements Comparator<String> {
    private String stringInOrder(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return String.valueOf(c);
    }


    public int compare(String s1, String s2) {
        return stringInOrder(s1).compareTo(stringInOrder(s2));
    }

}
