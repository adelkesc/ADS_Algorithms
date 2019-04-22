package calculator;

import java.util.Scanner;

/**
 * The calculator class that calculates postfix operations based on user input and returns
 * the result.
 * 
 * @author adelkesc
 * @version 1.0  26/02/19
 */
public class PostfixCalculator 
{
	private CircularArrayStack<Integer> cas;
	
	private final static char ADDITION = '+';
	private final static char SUBTRACTION = '-';
	private final static char MULTIPLICATION = '*';
	private final static char DIVISION = '/';
	
	/**
	 * Instantiates the CircularArrayStack implementation that contains the stack methods.
	 */
	public PostfixCalculator()
	{
		cas = new CircularArrayStack<>();
	}

	/**
	 * Takes user input from the main method and performs a comparison as long as there is
	 * input.  If an operator is detected, the two
	 * @param expression
	 */
	public void evaluateInput(String expression)
	{
		int operand1 = 0;
		int operand2 = 0;

		Scanner keyboardInput = new Scanner(expression);
		try
		{
			while(keyboardInput.hasNext())
			{
				String operator = keyboardInput.next();
				if(isOperator(operator))
				{
					operand1 = cas.pop();
					operand2 = cas.pop();
					callOperation(operator.charAt(0), operand1, operand2);
				}
				else
					cas.push(Integer.parseInt(operator));
			}
		}
		catch(Exception e)
		{
			System.out.println("Error in expression formulation, please try again.");
		}
	}

	/**
	 * Tests if the variable that isn't an integer value is one of the 4 String operators.
	 * @param operator
	 * @return
	 */
	private boolean isOperator(String operator) 
	{
		return (operator.equals("+") || operator.equals("-") || operator.equals("*") || 
				operator.equals("/"));
	}

	/**
	 * Uses the calculation variable to determine which method operation to call and passes
	 * the two operand variables to the chosen method to be operated on.
	 * @param calculation
	 * @param operand1
	 * @param operand2
	 */
	private void callOperation(char calculation, int operand1, int operand2)
	{
		switch(calculation)
		{
			case ADDITION:
				postfixAddition(operand1, operand2);
				break;

			case SUBTRACTION:
				postfixSubtraction(operand1, operand2);
				break;

			case MULTIPLICATION:
				postfixMultiplication(operand1, operand2);
				break;

			case DIVISION:
				postfixDivision(operand1, operand2);
				break;

			default:
				System.out.println("Error, try again.");
		}
	}

	/**
	 * Performs the addition calculation and pushes the result to the stack.
	 * @param operand1
	 * @param operand2
	 */
	private void postfixAddition(int operand1, int operand2)
	{
		int addResult = 0;
		addResult = operand2 + operand1;
		cas.push(addResult);
	}
	
	/**
	 * Performs the subtraction calculation and pushes the result to the stack.
	 * @param operand1
	 * @param operand2
	 */
	private void postfixSubtraction(int operand1, int operand2)
	{
		int subResult = 0;
		if(operand2 > operand1)
		{
			subResult = operand2 - operand1;
		}
		else
			subResult = operand1 - operand2;
			cas.push(subResult);
	}
	
	/**
	 * Performs the multiplication calculation and pushes the result to the stack.
	 * @param operand1
	 * @param operand2
	 */
	private void postfixMultiplication(int operand1, int operand2)
	{
		int multiResult = 0;
		multiResult = operand2 * operand1;
		cas.push(multiResult);
	}

	/**
	 * Performs the division calculation and pushes the result to the stack.
	 * @param operand1
	 * @param operand2
	 */
	private void postfixDivision(int operand1, int operand2)
	{
		int divResult = 0;
		if(operand2 > operand1 && operand1 == 0)
		{
			throw new ArithmeticException("Do not divide by zero.");
		}
		else if(operand1 > operand2 && operand1 == 0)
		{
			throw new ArithmeticException("Do not divide by zero.");
		}
		else 
			divResult = operand2 / operand1;
			cas.push(divResult);
	}
	
	/**
	 * Pops the final result from the stack and returns the result to the main method.
	 * @return
	 */
	public int expressionResult()
	{
		int result = 0;
		result = cas.pop();
		return result;
	}
}