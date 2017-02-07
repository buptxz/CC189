/**
 * Created by xiong on 10/18/2016.
 * Rewrite after looking at the solution
 */

package Q3_02_Stack_Min;

import java.util.Stack;

public class ZhengStackWithMin1 extends Stack<NodeWithMin> {
    public void push(int value) {
        // use min() instead of Math.min inside the Math.min
        NodeWithMin newNode = new NodeWithMin(value, Math.min(value, min()));
        super.push(newNode);
    }

    public int min() {
        if (isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return peek().min;
        }
    }
}
