package Introduction;

import java.util.EmptyStackException;

public class ArrayStack<T> {
	public int capacity = 1000;
	public T[] data;
	public int index = -1;

	public ArrayStack() {
		data = (T[]) new Object[capacity];
	}

	public ArrayStack(int size) {
		capacity = size;
		data = (T[]) new Object[capacity];
	}

	public T pop() {
		if (index == -1) throw new EmptyStackException();
		index -= 1;
		return data[index+1];
	}

	public void push(T item) {
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

	public T peek(){
		if (index == -1) throw new EmptyStackException();
		return data[index];
	}
}