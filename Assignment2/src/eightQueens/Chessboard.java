package eightQueens;

import java.util.Arrays;

/**
 * The Chessboard class evaluates the N Queen Problem using a board where the size is
 * controlled by user input.
 * 
 * @author Amahdya Delkescamp
 *
 */
public class Chessboard 
{
	private int[][] chessboard;
	int numberOfQueens = 0;
	
	/**
	 * Instantiates the chessboard based on values from user input, generates, and calls
	 * to print a chessboard of zeros to console.
	 *
	 * @param xValue
	 * @param yValue
	 */
	public Chessboard(int xValue, int yValue) 
	{
		chessboard = new int[xValue][yValue];
		for(int i = 0; i < xValue; i++)
			for(int j = 0; j < yValue; j++)
			chessboard[i][j] = 0;
		
		printBoard();
		checkForQueen(chessboard, 0, 0);
	}	
	
	/**
	 * Uses the chessboard, row, and column values to check the generated chessboard
	 * for a queen, represented by a 1 value.  The method is recursive, if a queen is 
	 * found, then the method increments and calls itself.  Otherwise all the for loops
	 * will run and a method is called to place a queen indicating that there is no queen
	 * at the current positions.  This method continues running until the number of queens
	 * is equal to the length of the chessboard array.
	 * 
	 * @param chessboard
	 * @param row
	 * @param column
	 */
	private boolean checkForQueen(int chessboard[][], int row, int column)
	{
		if(numberOfQueens == chessboard.length)
		{
			System.out.println("Problem Completed!");
			printBoard();
			return true;
		}
		else
		{
			// check row
			for (int i = 0; i < chessboard.length; i++) {
				if (isLegalPosition(chessboard, i, column))
				{
				placeQueen(chessboard, i, column);
					checkForQueen(chessboard, i, column + 1);
				removeQueen(chessboard, i, column);
				}
			}
		}	
		return false;
	}
	
	private final boolean isLegalPosition(int chessboard[][], int row, int col) {
		//System.out.println("row:col; " + row + ":" + col);
		for (int i = 0; i < chessboard.length; i++) 
		{
			if(chessboard[row][i] == 1)
			{
				return false;
			}
		}
		
		// check column
		for (int j = 0; j < chessboard.length; j++) 
		{
			if(chessboard[j][col] == 1)
			{
				return false;
			}

		}
		//check diagonal, upward left
		for(int i = row, j = col; i >= 0 && j >= 0; i--, j--)
		{
			//System.out.println("upleft diag; " + i + ":" + j);
			if(chessboard[i][j] == 1)
			{
				return false;
			}
			
		}
		
		//check diagonal, upward right
		for(int i = row, j = col; i < chessboard.length && j >= 0; i++, j--)
		{
			//System.out.println("upright diag; " + i + ":" + j);
			if(chessboard[i][j] == 1)
			{
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * This method places a queen, increments the number of queens on the board, and
	 * calls the checkForQueen() method with its positional variables.
	 * 
	 * @param chessboard
	 * @param row
	 * @param column
	 */
	private void placeQueen(int chessboard[][], int row, int column)
	{
		chessboard[row][column] = 1;
		numberOfQueens++;
//		checkForQueen(chessboard, row, column);
	}
	
	/**
	 * This method removes a queen in the even that the board's current solution is not
	 * viable. 
	 * 
	 * @param chessboard
	 * @param row
	 * @param column
	 */
	private void removeQueen(int chessboard[][], int row, int column)
	{
		chessboard[row][column] = 0;
		numberOfQueens--;
//		checkForQueen(chessboard, row, column);
	}
	
	/**
	 * This method uses a loop to print the chessboards.
	 */
	private void printBoard()
	{
		for(int[] row : chessboard)
		{
			System.out.println(Arrays.toString(row));
		}
	}

}
