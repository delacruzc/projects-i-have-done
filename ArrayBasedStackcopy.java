package cmsc256;

/**
 * CMSC 256 Lab 8
 * Colin Coon
 * Caitlin Dela Cruz
 */
import java.util.Arrays;
import java.util.EmptyStackException;


// In this lab, we practiced and learned the concept of stacks in Java.

public class ArrayBasedStack<T> implements StackInterface<T> {
	
	private T[] data;
	private int topOfStack;
	private static final int INITIAL_CAPACITY = 5;
	
	public static void main(String[] args) {
		ArrayBasedStack<String> stack = new ArrayBasedStack<String>(2);
		stack.push("Hello");
		stack.push("Chocolate");
		
		
		
		//System.out.print("" + stack.getData().length + " " + stack.getString());
		stack.push("Yellow");
		
		stack.push("Yellow");
		
		stack.push("Hello");
		stack.push("Chocolate");
		stack.push("Yellow");
		
		stack.push("Yellow");
		
		stack.push("Hello");
		stack.push("Chocolate");
		stack.pop();
		//System.out.print(stack.getData().length);
		//stack.expandArray();
		//System.out.println(stack.length);
	}
	
	public T[] getData() {
		return data;
	}
	
	public int getString() {
		return topOfStack;
	}
	
	public ArrayBasedStack(int capacity) {
		if (capacity <= 0) {
			throw new IllegalArgumentException("Array initial size error.");
		}
		
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[]) new Object[capacity];
		data = tempStack;
		topOfStack = -1;
	}
	
	public ArrayBasedStack() {
		clear();
	}
	
	public void expandArray() {
		T[] newStack = Arrays.copyOf(data, data.length*2);
		data = newStack;
	}
	
	public boolean isArrayFull() {
		if(topOfStack >= data.length - 1)
			return true;
			
		return false;
	}
	
	/**
	 * Adds a new entry to the top of this stack.
	 * 
	 * @param newEntry An object to be added to the stack.
	 */
	public void push(T newEntry) {
		if(isArrayFull() == true) {
			expandArray();
		}
		
		topOfStack += 1;
		data[topOfStack] = newEntry;
	}

	/**
	 * Removes and returns this stack's top entry.
	 * 
	 * @return The object at the top of the stack.
	 * @throws EmptyStackException if the stack is empty before the operation.
	 */
	public T pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		
		T temp = data[topOfStack];
		System.out.println(temp.toString());
		
		data[topOfStack] = null;
		topOfStack -= 1;
		
		return temp;
	}

	/**
	 * Retrieves this stack's top entry.
	 * 
	 * @return The object at the top of the stack.
	 * @throws EmptyStackException if the stack is empty.
	 */
	public T peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		
		return data[topOfStack];
	}

	/**
	 * Detects whether this stack is empty.
	 * 
	 * @return True if the stack is empty.
	 */
	public boolean isEmpty() {
		if(topOfStack < 0)
			return true;
		
		return false;
	}

	public void clear() {
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[]) new Object[INITIAL_CAPACITY];
		data = tempStack;
		topOfStack = -1;
	}

}
