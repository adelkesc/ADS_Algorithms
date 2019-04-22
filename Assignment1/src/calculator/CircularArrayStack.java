package calculator;


/**
 * This class is the implementation of the MinimalStackADT.
 * 
 * @author adelkesc
 * @version 1.0  26/02/19
 *
 * @param <T>
 */
public class CircularArrayStack<T> implements MinimalStackADT<T>
{
	public static final int DEFAULT_CAPACITY = 5; 

	private int top; 
	private int count = 0;
	private T[] stack;
	
	/**
	 * No-argument constructor.  Intializes a generic array of type Object at a default 
	 * capacity.
	 * 
	 */
	public CircularArrayStack() 
	{
		this.stack = (T[]) new Object[DEFAULT_CAPACITY];
	}
	
	/**
	 * Single argument constructor.  Type casts (T[]) new Object[] array into an integer 
	 * array.
	 * @param initialCapacity
	 */
	public CircularArrayStack(int initialCapacity) 
	{
		top = 0;
		this.stack = (T[]) new Object[initialCapacity];
	}
	
	/**
	 * A method that is only called by the push() method, it doubles the length of the stack 
	 * if the stack becomes full.
	 */
	private void expandCapacity()
	{
		T[] largerStack = (T[]) new Object[stack.length * 2];
		for(int index = 0; index < stack.length; index++)
		{
			largerStack[index] = stack[index];
		}
		stack = largerStack;
	}
	
	/**
	 * Pushes an element to the circular array stack, increments the top pointer, 
	 * and increments the count.  If the size of the array stack is the same as its length
	 * then the expandCapacity method is called.
	 */
	@Override
	public void push(T element) 
	{
		if(size() == stack.length)
		{
			expandCapacity();
		}
		stack[top] = element;
		top++;
		count++;
	}
	
	/**
	 * The top and count variables are decremented.  The element being popped off the stack
	 * is stored in a temporary variable and returned while the top position is set to null.
	 * The pop method throws and IllegalStateException if the isEmpty boolean returns true.
	 */
	@Override
	public T pop() 
	{
		if(isEmpty())
		{
			throw new IllegalStateException("The stack is empty.");
		}
		top--;
		count--;
		T element = stack[top];
		stack[top] = null;
		
		return element;
	}

	/**
	 * Peeks at the top element in the stack and returns the reference.  The method throws 
	 * an IllegalStateException if the stack contains no elements.
	 */
	@Override
	public T peek() 
	{
		if(isEmpty())
		{
			throw new IllegalStateException("The stack is empty.");
		}
		return stack[top-1];
	}

	/**
	 * Checks the count by comparing the size() method to zero and returns depending on
	 * if the size method itself returns zero or not.
	 */
	@Override
	public boolean isEmpty() 
	{
		if(size() == 0)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * Size method of type int that returns the size of the array stack, the number of 
	 * cells in the array that are occupied by elements, through the count variable.
	 */
	@Override
	public int size()
	{
		return count;
	}
}
