package mapping;

abstract public class Map {

	public final static int FREE = 0;  // Empty square
	final static int STONE = 1;  // Square with a stone in it
	public final static int UNBREAKABLE = 2; // Unbreakable path, a player can't stand here

	public final static int PLAYER1 = 3;   // Square where player 1 is
	public final static int PLAYER2 = 4;   // Square where player 2 is
	final static int BOMB1 = -1; // Square with player1 has placed a bomb
	final static int BOMB2 = -2; // Square with player2 has placed a bomb

	public final static int HEIGHT = 24; // Height of the board
	public final static int WIDTH = 24; // Width of the board
	
	public static int PLAYERPOSY = 1;
	public static int PLAYERPOSX = 1;
	public static int PLAYER2POSY = HEIGHT-2;
	public static int PLAYER2POSX = WIDTH-2;

	public static int[][] board = new int[HEIGHT][WIDTH]; 


	public static void startMap(){

		// Fills out the whole board with free squares

		for (int i=0; i <= HEIGHT-1 ; i++)
			for (int j=0; j <= WIDTH-1; j++)
				board[i][j] = FREE;

		// Outer border for the board with unbreakable pieces 

		for (int i=0; i <= 0; i++)
			for (int j=0; j <= WIDTH-1; j++)
				board[i][j] = UNBREAKABLE;

		for (int i=HEIGHT-1; i <= HEIGHT-1; i++)
			for (int j=0; j <= WIDTH-1; j++)
				board[i][j] = UNBREAKABLE;

		for (int i=0; i <= HEIGHT-1; i++)
			for (int j=0; j <= 0; j++)
				board[i][j] = UNBREAKABLE;

		for (int i=0; i <= HEIGHT-1; i++)
			for (int j=WIDTH-1; j <= WIDTH-1; j++)
				board[i][j] = UNBREAKABLE;

	}

		public static void drawBoard(){

			for(int i=0; i <HEIGHT; i++){
				for(int j=0; j < WIDTH; j++){
					System.out.print(board[i][j]);	             
				}
				System.out.println();
			}
		}

	}

