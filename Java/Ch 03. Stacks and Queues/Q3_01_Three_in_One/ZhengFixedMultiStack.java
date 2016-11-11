/**
 * Created by xiong on 10/17/2016.
 */
package Q3_01_Three_in_One;

import java.util.EmptyStackException;

public class ZhengFixedMultiStack<T> {
    private int CAPACITY = 100;
    private int[] size;
    private T[] data;
    private int numOfStacks = 3;

    public ZhengFixedMultiStack(int stackSize) {
        CAPACITY = stackSize;
        size = new int[numOfStacks];
        data = (T[]) new Object[numOfStacks * CAPACITY];
    }

    public void push(int stackNum, T item) throws FullStackException {
        if (size[stackNum] == CAPACITY) throw new FullStackException();
        size[stackNum]++;
        data[indexOfTop(stackNum)] = item;
    }

    public T pop(int stackNum) {
        if (size[stackNum] == 0) throw new EmptyStackException();
        T temp = data[indexOfTop(stackNum)];
//        data[indexOfTop(stackNum)] = null;
        size[stackNum]--;
        return temp;
    }

    public int indexOfTop(int stackNum) {
        return stackNum * CAPACITY + size[stackNum] - 1;
    }

    public T[] getValues() {
        return data;
    }
}
