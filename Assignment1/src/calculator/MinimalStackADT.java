package calculator;

/**
 * An interface that exposes the basic methods to be used for a StackADT.
 * 
 * @author adelkesc
 * @version
 * 
 * @param <T>
 */
public interface MinimalStackADT<T> 
{
	void push(T element);
	T pop();
	T peek();
	boolean isEmpty();
	int size();
}
