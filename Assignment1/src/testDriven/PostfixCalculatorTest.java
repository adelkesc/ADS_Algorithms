package testDriven;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import calculator.CircularArrayStack;
import calculator.PostfixCalculator;

/**
 * JUnit 5(Jupiter) test class for the PostfixCalculator class.
 * 
 * @author adelkesc
 * @version 1.0 26/02/19
 */
class PostfixCalculatorTest 
{
	private PostfixCalculator calculator;
	
	@BeforeEach
	void setUp() throws Exception 
	{
		calculator = new PostfixCalculator();
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		calculator = null;
	}

	@Test
	void evaluateInputAdditionEqualsZero() 
	{
		calculator.evaluateInput("0 0 +");
		assertEquals(0, calculator.expressionResult());
	}
	
	@Test
	void evaluateInputSubtractionEqualsZero()
	{
		calculator.evaluateInput("0 0 -");
		assertEquals(0, calculator.expressionResult());
	}
	
	@Test
	void evaluateInputMultiplicationEqualsZero()
	{
		calculator.evaluateInput("0 0 *");
		assertEquals(0, calculator.expressionResult());
	}
	
	@Test
	void evaluateInputDivideByZeroError()
	{
		assertThrows(ArithmeticException.class, () -> calculator.evaluateInput("0 0 /"));
	}
	
	@Test
	void evaluateInputDivisionEqualsOne()
	{
		calculator.evaluateInput("0 1 /");
		assertEquals(1, calculator.expressionResult());
		calculator.evaluateInput("1 0 /");
		assertEquals(1, calculator.expressionResult());
	}
	
//	Do not need to test on a try-catch block because it is code that will never be exposed
//  to the user.
//	@Test
//	void evaluateInputTryCatchWrongInput()
//	{
//		calculator.evaluateInput("1 2 !");
//		assertThrows(Exception.class, () -> calculator.evaluateInput("1 2 !"));
//	}
}
