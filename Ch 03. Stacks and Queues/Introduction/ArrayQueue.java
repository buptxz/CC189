/**
 * Created by xiong on 10/19/2016.
 */

package Introduction;

import java.util.NoSuchElementException;

public class ArrayQueue<E> {
    private final int CAPACITY = 100;
    private E[] data;
    private int f = 0;
    private int sz = 0;

    public ArrayQueue() {
        data = (E[]) new Object[CAPACITY];
    }

    public ArrayQueue(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public void add(E item) {
        if (sz==data.length) throw new IllegalStateException("Queue is full");
        int index = (f + sz) % data.length;
        data[index] = item;
        sz++;
    }

    public E remove() {
        if (sz==0) throw new NoSuchElementException();
        E temp = data[f];
        data[f] = null;
        f = (f + 1) % data.length;
        sz--;
        return temp;
    }

    public boolean isEmpty() {
        return (sz==0);
    }

}