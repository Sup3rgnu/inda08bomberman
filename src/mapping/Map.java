package mapping;

abstract public class Map {

	public final static int FREE = 0;  // Empty square
	public final static int STONE = 1;  // Square with a stone in it
	public final static int UNBREAKABLE = 2; // Unbreakable path, a player can't stand here

	public final static int PLAYER1 = 3;   // Square where player 1 is
	public final static int PLAYER2 = 4;   // Square where player 2 is
	public final static int BOMB1 = 8; // Square with player1 has placed a bomb
	public final static int BOMB2 = 9; // Square with player2 has placed a bomb

	public final static int HEIGHT = 16; // Height of the board
	public final static int WIDTH = 16; // Width of the board

	public static int PLAYERPOSY = 1; // Start pos on the board, not a conflict with STONE = 1 
	public static int PLAYERPOSX = 1;
	public static int PLAYER2POSY = HEIGHT-2;
	public static int PLAYER2POSX = WIDTH-2;

	public static int BOMBPOSY = 0;
	public static int BOMBPOSX = 0;
	public static int BOMB2POSY = 0;
	public static int BOMB2POSX = 0;

	final public static int BOMBRADIUS = 2;   
	public static boolean bombOnBoard = false;
	public static boolean bomb2OnBoard = false;

	static int timer = 0;
	public static int BOMBTIMER = 0;
	public static int BOMB2TIMER = 0;

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

		/**
		 * Map 1 beta 
		 * size:16x16
		 */
		board[2][2] = UNBREAKABLE;
		board[7][3] = UNBREAKABLE;
		board[HEIGHT-4][5] = UNBREAKABLE;
		board[HEIGHT-5][9] = UNBREAKABLE;
		board[6][8] = UNBREAKABLE;
		board[8][8] = UNBREAKABLE;

		for  (int i=2; i <= 2; i++)
			for (int j = 4; j <= WIDTH-3; j++)
				board[i][j] = UNBREAKABLE;

		for  (int i=4; i <= HEIGHT-3; i++)
			for (int j = 2; j <= 2; j++)
				board[i][j] = UNBREAKABLE;

		for  (int i=3; i <= HEIGHT-3; i++)
			for (int j = WIDTH-3; j <= WIDTH-3; j++)
				board[i][j] = UNBREAKABLE;
		board[7][HEIGHT-3] = FREE;

		for  (int i=HEIGHT-3; i <= HEIGHT-3; i++)
			for (int j =4; j <= WIDTH-3; j++)
				board[i][j] = UNBREAKABLE;
		board[HEIGHT-3][7] = FREE;

		for  (int i=4; i <= 4; i++)
			for (int j = 5; j <= 12; j++)
				board[i][j] = UNBREAKABLE;
		board[4][10] = FREE;

		for  (int i=5; i <= 10; i++)
			for (int j = 5; j <= 5; j++)
				board[i][j] = UNBREAKABLE;
		board[7][5] = FREE;

		for  (int i=HEIGHT-6; i <=HEIGHT-6; i++)
			for (int j = 6; j <= 11; j++)
				board[i][j] = UNBREAKABLE;

		for  (int i=7; i <=7; i++)
			for (int j = 7; j <= 11; j++)
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
	public static void bombTick(){
		timer++;

		if(BOMBTIMER != 0 && timer == BOMBTIMER){
			BOMBTIMER = 0;
			bomb(1);
		}

		if(BOMB2TIMER != 0 & timer == BOMB2TIMER){
			BOMB2TIMER = 0;
			bomb(2);
		}

	}
	public static void bomb(int t){
		int bombposx;
		int bombposy;
		
		if(t == 2){
			bombposx = BOMB2POSX;
			bombposy = BOMB2POSY;
		}else{		// Invariant: t = 1
			bombposx = BOMBPOSX;
			bombposy = BOMBPOSY;
		}

		Map.board[bombposy][bombposx] = Map.FREE;			//NOT FREE, should be something like "bomb fire/explosion" for awhile..

		boolean bombflagA = false;
		boolean bombflagB = false;

		for(int i=bombposy+1; i<=bombposy+BOMBRADIUS; i++){
			if(i >= HEIGHT){
			}else if(Map.board[i][bombposx] == Map.STONE && (i-bombposy <= BOMBRADIUS)){
				Map.board[i][bombposx] = Map.FREE;
				bombflagA = true;
			}else if(Map.board[i+1][bombposx] == Map.STONE && (i+1 <= BOMBRADIUS) && Map.board[i][bombposx] == Map.FREE && bombflagA == false){
				Map.board[i+1][bombposx] = Map.FREE;
				bombflagA =true;
			}
		}

		for(int i=bombposy-1; i<=bombposy-BOMBRADIUS; i--){
			if(i <= 0){
			}else if(Map.board[i][bombposx] == Map.STONE && (bombposy-i <= BOMBRADIUS)){
				Map.board[i][bombposx] = Map.FREE;
				bombflagB = true;
			}else if(Map.board[i-1][bombposx] == Map.STONE && (bombposy-(i-1) <= BOMBRADIUS) && Map.board[i][bombposx] == Map.FREE && bombflagB == false){
				Map.board[i+1][bombposx] = Map.FREE;
				bombflagB = true;
			}
		}

		boolean bombflagC = false;
		boolean bombflagD = false;

		for(int i=bombposx+1; i<=bombposx+BOMBRADIUS; i++){
			if(i >= WIDTH){
			}else if(Map.board[bombposy][i] == Map.STONE && (i-bombposx <= BOMBRADIUS)){
				Map.board[bombposy][i] = Map.FREE;
				bombflagC = true;
			}else if(Map.board[bombposy][i+1] == Map.STONE && (i+1 <= BOMBRADIUS) && Map.board[bombposy][i] == Map.FREE && bombflagC == false){
				Map.board[bombposy][i+1] = Map.FREE;
				bombflagC =true;
			}
		}

		for(int i=bombposx-1; i<=bombposx-BOMBRADIUS; i--){
			if(i <= 0){
			}else if(Map.board[i][bombposx] == Map.STONE && (bombposx-i <= BOMBRADIUS)){
				Map.board[bombposy][i] = Map.FREE;
				bombflagD = true;
			}else if(Map.board[bombposy][i-1] == Map.STONE && (bombposx-(i-1) <= BOMBRADIUS) && Map.board[bombposy][i] == Map.FREE && bombflagD == false){
				Map.board[bombposy][i+1] = Map.FREE;
				bombflagD = true;
			}
		}
		
		bombOnBoard = false;
	}


}
