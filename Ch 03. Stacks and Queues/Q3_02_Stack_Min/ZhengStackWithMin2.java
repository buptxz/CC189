/**
 * Created by xiong on 10/18/2016.
 * Rewrite after looking at solution. Will implement with minimum space.
 */

package Q3_02_Stack_Min;

import java.util.Stack;

public class ZhengStackWithMin2 extends Stack<Integer> {
    Stack<Integer> minStack = new Stack<>();

    public void push(int value) {
        if (value <= min()) minStack.push(value);
        super.push(value);
    }

    public Integer pop() {
        int value = super.pop();
        if (value == minStack.peek()) {
            minStack.pop();
        }
        return value;
    }

    public int min() {
        if (minStack.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return minStack.peek();
        }
    }
}
