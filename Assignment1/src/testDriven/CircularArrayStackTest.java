package testDriven;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import calculator.CircularArrayStack;

/**
 * JUnit 5(Jupiter) test class for the CircularArrayStack<T> generic class.
 * 
 * @author adelkesc
 * @version 1.0  26/02/19
 */
class CircularArrayStackTest 
{
	private CircularArrayStack<Integer> arrayStack;
	
	@BeforeEach
	void setUp() throws Exception 
	{
		arrayStack = new CircularArrayStack<>();
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		arrayStack = null;
	}
	
	@Test
	void SizeMethodWithNoElements()
	{
		assertEquals(0, arrayStack.size());
	}

	@Test
	void isEmptyBooleanisTrue()
	{
		assertTrue(arrayStack.isEmpty());
	}
	
	@Test
	void popWhenStackIsEmptyException() 
	{
		assertThrows(IllegalStateException.class, () -> arrayStack.pop());
	}
	
	@Test
	void peekAtArrayStackWithNoElementsException()
	{
		assertThrows(IllegalStateException.class, () -> arrayStack.peek());
	}
	
	@Test
	void isEmptyFalseWithOneElement()
	{
		arrayStack.push(4);
		assertFalse(arrayStack.isEmpty());
	}

	@Test
	void pushOneElementToStack() 
	{
		arrayStack.push(12);
		assertEquals(1, arrayStack.size());
	}
	
	@Test
	void popStackWithOneElement()
	{
		arrayStack.push(12);
		assertEquals(1, arrayStack.size());
		arrayStack.pop();
		assertEquals(0, arrayStack.size());
		
	}
	
	@Test
	void peekWhenOneElementIsInStack()
	{
		arrayStack.push(12);
		assertEquals(12, (int)arrayStack.peek());
	}
	
	@Test
	void peekWhenManyElementsAreInStack()
	{
		arrayStack.push(12);
		arrayStack.push(3);
		arrayStack.push(7);
		arrayStack.push(10);
		arrayStack.push(9);
		assertEquals(9, (int)arrayStack.peek());
	}
	
	@Test
	void sizeMethodWithManyElements()
	{
		arrayStack.push(2);
		arrayStack.push(2);
		arrayStack.push(2);
		assertEquals(3, arrayStack.size());
	}
	
	@Test
	void isEmptyBooleanIsFalseManyElementsExist()
	{
		arrayStack.push(2);
		arrayStack.push(2);
		arrayStack.push(2);
		assertFalse(arrayStack.isEmpty());
	}

	@Test
	void expandCapacityWhenStackIsFull() 
	{
		arrayStack.push(12);
		arrayStack.push(3);
		arrayStack.push(7);
		arrayStack.push(10);
		arrayStack.push(9);
		assertEquals(5, arrayStack.size());
		arrayStack.push(9);
		arrayStack.push(9);
		assertEquals(7, arrayStack.size());
	}
}
