package testCases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import eightQueens.Chessboard;

class nQueenTestCases 
{
	private Chessboard board;

	@BeforeEach
	void setUp() throws Exception 
	{
		board = new Chessboard(0, 0);
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		board = null;
	}

	@Test
	void FourByFourBoard()
	{
		board = new Chessboard(4, 4);
		//can't test on void and private methods
	}
	
	@Test
	void FiveByFiveBoard()
	{

	}

}
