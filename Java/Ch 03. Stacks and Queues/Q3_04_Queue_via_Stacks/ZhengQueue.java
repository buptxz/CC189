/**
 * Created by xiong on 10/20/2016.
 * It's not the best solution. Duplicate work each time of calling function add
 */

package Q3_04_Queue_via_Stacks;

import java.util.Stack;

public class ZhengQueue<E> {
    Stack<E> stack1;
    Stack<E> stack2;

    public ZhengQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void add(E item) {
        if (stack1.isEmpty()) switchData();
        stack1.add(item);
    }

    public E remove() {
        if (stack2.isEmpty()) switchData();
        return stack2.pop();
    }

    public int size() {
        return Math.max(stack1.size(), stack2.size());
    }

    public E peek() {
        if (stack2.isEmpty()) switchData();
        return stack2.peek();
    }

    private void switchData() {
        if (stack1.isEmpty()) {
            while (!stack2.isEmpty()) {
                stack1.add(stack2.pop());
            }
        } else {
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());
            }
        }
    }
}
