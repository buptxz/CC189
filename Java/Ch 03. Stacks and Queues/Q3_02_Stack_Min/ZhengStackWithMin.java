/**
 * Created by xiong on 10/18/2016.
 */

package Q3_02_Stack_Min;

import java.util.ArrayList;
import java.util.Stack;

public class ZhengStackWithMin extends Stack {
    private int topIndex = -1;
    private ArrayList<Integer> minList = new ArrayList();

    public void push(int value) {
        minList.add(Math.min(value, min()));
        topIndex++;
        super.push(value);
    }

    public Integer pop() {
        int temp = (int) super.peek();
        minList.remove(topIndex);
        topIndex--;
        super.pop();
        return temp;
    }

    public int min() {
        if (topIndex == -1) {
            return Integer.MAX_VALUE;
        }
        return minList.get(topIndex);
    }
}
