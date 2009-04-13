package mapping;

public class Movement {

	static public void goLeft(){
		if(Map.board[Map.PLAYERPOSY][Map.PLAYERPOSX-1] == Map.FREE){
			Map.board[Map.PLAYERPOSY][Map.PLAYERPOSX] = Map.FREE;
			Map.board[Map.PLAYERPOSY][--Map.PLAYERPOSX] = Map.PLAYER1; 
		}else{}
	}

	static public void goUp(){
		if(Map.board[Map.PLAYERPOSY-1][Map.PLAYERPOSX] == Map.FREE){
			Map.board[Map.PLAYERPOSY][Map.PLAYERPOSX] = Map.FREE;
			Map.board[--Map.PLAYERPOSY][Map.PLAYERPOSX] = Map.PLAYER1;
			mapping.Map.drawBoard();
		}else{}
	}

	static public void goDown(){
		if(Map.board[Map.PLAYERPOSY+1][Map.PLAYERPOSX] == Map.FREE){
			Map.board[Map.PLAYERPOSY][Map.PLAYERPOSX] = Map.FREE;
			Map.board[++Map.PLAYERPOSY][Map.PLAYERPOSX] = Map.PLAYER1;
			mapping.Map.drawBoard();
		}else{}
	}

	static public void goRight(){
		if(Map.board[Map.PLAYERPOSY][Map.PLAYERPOSX+1] == Map.FREE){
			Map.board[Map.PLAYERPOSY][Map.PLAYERPOSX] = Map.FREE;
			Map.board[Map.PLAYERPOSY][++Map.PLAYERPOSX] = Map.PLAYER1; 
		}else{}
	}

	static public void goLeft2(){
		if(Map.board[Map.PLAYER2POSY][Map.PLAYER2POSX-1] == Map.FREE){
			Map.board[Map.PLAYER2POSY][Map.PLAYER2POSX] = Map.FREE;
			Map.board[Map.PLAYER2POSY][--Map.PLAYER2POSX] = Map.PLAYER2; 
		}else{}
	}

	static public void goUp2(){
		if(Map.board[Map.PLAYER2POSY-1][Map.PLAYER2POSX] == Map.FREE){
			Map.board[Map.PLAYER2POSY][Map.PLAYER2POSX] = Map.FREE;
			Map.board[--Map.PLAYER2POSY][Map.PLAYER2POSX] = Map.PLAYER2;
			mapping.Map.drawBoard();
		}else{}
	}

	static public void goDown2(){
		if(Map.board[Map.PLAYER2POSY+1][Map.PLAYER2POSX] == Map.FREE){
			Map.board[Map.PLAYER2POSY][Map.PLAYER2POSX] = Map.FREE;
			Map.board[++Map.PLAYER2POSY][Map.PLAYER2POSX] = Map.PLAYER2;
			mapping.Map.drawBoard();
		}else{}
	}

	static public void goRight2(){
		if(Map.board[Map.PLAYER2POSY][Map.PLAYER2POSX+1] == Map.FREE){
			Map.board[Map.PLAYER2POSY][Map.PLAYER2POSX] = Map.FREE;
			Map.board[Map.PLAYER2POSY][++Map.PLAYER2POSX] = Map.PLAYER2; 
		}else{}
	}

	
}
