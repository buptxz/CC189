/**
 * Created by xiong on 10/19/2016.
 */
package Q3_03_Stack_of_Plates;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class ZhengSetOfStacks {
    private int capacityOfSubstack;
    private int currentStackIndex;
    private ArrayList<ZhengStack> stacks = new ArrayList<ZhengStack> ();

    public ZhengSetOfStacks() {
        capacityOfSubstack = 10;
        stacks.add(new ZhengStack(capacityOfSubstack));
    }

    public ZhengSetOfStacks(int capacity) {
        capacityOfSubstack = capacity;
        stacks.add(new ZhengStack(capacityOfSubstack));
    }

    public void push(int item) {
        if (stacks.get(currentStackIndex).isFull()) {
            stacks.add(new ZhengStack(capacityOfSubstack));
            currentStackIndex++;
        }
        stacks.get(currentStackIndex).push(item);
    }

    public int pop() {
        if(stacks.get(currentStackIndex).isEmpty()) {
            stacks.remove(currentStackIndex);
            currentStackIndex--;
        }
        if (currentStackIndex == -1) throw new EmptyStackException();
        return stacks.get(currentStackIndex).pop();
    }

}
