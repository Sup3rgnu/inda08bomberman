package mapping;

public class Map {

	final static int FREE = 0;  // Empty square
	final static int STONE = 1;  // Square with a stone in it
	final static int UNBREAKABLE = 2; // Unbreakable path, a player can't stand here
	final static int PLAYER1 = 3;   // Square where player 1 is
	final static int PLAYER2 = 4;   // Square where player 2 is
	final static int BOMB1 = -1; // Square with player1 has placed a bomb
	final static int BOMB2 = -2; // Square with player2 has placed a bomb
	
	final static int HEIGHT = 24; // Height of the board
	final static int WIDTH = 24; // Width of the board

	int[][] board = new int[HEIGHT][WIDTH]; {
		
		// Fills out the whole board with free squares
		
		for (int i=0; i < HEIGHT ; i++)
			   for (int j=0; j < WIDTH; j++)
			      board[i][j] = FREE;

		// Outer border for the board with unbreakable pieces 
		
		for (int i=0; i <= 0; i++)
			for (int j=0; j < WIDTH; j++)
				board[i][j] = UNBREAKABLE;

		for (int i=HEIGHT; i <= HEIGHT; i++)
			for (int j=0; j < WIDTH; j++)
				board[i][j] = UNBREAKABLE;

		for (int i=0; i < HEIGHT; i++)
			for (int j=0; j <= 0; j++)
				board[i][j] = UNBREAKABLE;

		for (int i=0; i < HEIGHT; i++)
			for (int j=WIDTH; j <= WIDTH; j++)
				board[i][j] = UNBREAKABLE;
		
		// Players starting positions, diagonally across from each other
		
		board[1][1] = PLAYER1;
		board[HEIGHT-1][WIDTH-1] = PLAYER2;
	}
}
