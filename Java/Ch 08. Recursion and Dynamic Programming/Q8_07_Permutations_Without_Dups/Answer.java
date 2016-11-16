import java.util.ArrayList;

/**
 * Created by xiong on 11/15/2016.
 */
public class Answer {
    public static ArrayList<String> getPerms(String s) {
        ArrayList<String> result = new ArrayList<String>();
        if (s.length() == 1) {
            result.add(s);
            return result;
        }
        for (int index = 0; index < s.length(); index++) {
            String subS = s.substring(0, index) + s.substring(index + 1);
            ArrayList<String> subResult = getPerms(subS);
            for (String sR : subResult) {
                result.add(s.charAt(index) + sR);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<String> list = getPerms("abc");
        System.out.println("There are " + list.size() + " permutations.");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
