package calculator;

import java.util.Scanner;

/**
 * The main method class where and the entry point to the postfix calculator program.
 * 
 * @author adelkesc
 * @version 1.0  26/02/19
 *
 */
public class PostfixCalculatorMain 
{

	public static void main(String[] args) 
	{
		PostfixCalculator calculator = new PostfixCalculator();
		Scanner input = new Scanner(System.in);
		int result;
		
		
		System.out.println("Postfix Calculator");
		System.out.println("Please enter at least three characters to form a postfix expression.");
		System.out.println("Please include a space after each character.");
		System.out.println();
		System.out.print("Enter Postfix Expression: ");
		String expression = input.nextLine();
		
		result = calculator.expressionResult();
		
		System.out.println("The result is: " + result);
		input.close();
	}

}
