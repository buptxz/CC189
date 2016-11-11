/**
 * Created by xiong on 10/20/2016.
 */
package Q3_04_Queue_via_Stacks;

import java.util.Stack;

public class ZhengQueue2<E> {
    private Stack<E> stackOldest, stackNewest;

    public ZhengQueue2() {
        stackOldest = new Stack<E>();
        stackNewest = new Stack<E>();
    }

    public void add(E item) {
        stackNewest.push(item);
    }

    public E remove() {
        if (stackOldest.isEmpty()) {
            shiftStacks();
        }
        return stackOldest.pop();
    }

    private void shiftStacks() {
        while(!stackNewest.isEmpty()) stackOldest.push(stackNewest.pop());
    }

    public int size() {
        return stackNewest.size() + stackOldest.size();
    }

    public E peek() {
        if (stackOldest.isEmpty()) {
            shiftStacks();
        }
        return stackOldest.peek();
    }
}
