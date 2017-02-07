/**
 * Created by xiong on 10/19/2016.
 */

package Q3_03_Stack_of_Plates;

import java.util.EmptyStackException;

public class ZhengStack {
    public int capacity = 10;
    public int[] data;
    public int index = -1;

    public ZhengStack() {
    }

    public ZhengStack(int size) {
        this.capacity = size;
        data = new int[size];
    }

    public int pop() {
        if (index == -1) throw new EmptyStackException();
        index -= 1;
        return data[index+1];
    }

    public void push(int item) {
        if (index == capacity - 1) throw new ArrayIndexOutOfBoundsException();
        index += 1;
        data[index] = item;
    }

    public boolean isEmpty(){
        return index == -1;
    }

    public boolean isFull() {
        return index == capacity - 1;
    }

    public int peek(){
        if (index == -1) throw new EmptyStackException();
        return data[index];
    }
}
