package eightQueens;

import java.util.Scanner;

/**
 * The main method accepts user input for x and y values that will be used to generate
 * a chessboard.
 * 
 * @author adelkesc
 *
 */
public class ChessMain 
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("The 8 Queen Problem");
		System.out.println("Enter equal values for both X and Y coordinates: ");
		System.out.print("X: ");
		int xValue = input.nextInt();
		System.out.print("Y: ");
		int yValue = input.nextInt();

		Chessboard board = new Chessboard(xValue, yValue);
		
		input.close();
	}

}
