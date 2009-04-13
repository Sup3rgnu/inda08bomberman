package mapping;

public class Movement {

	static public void goLeft(){
		if(Map.board[Map.PLAYERPOSY][Map.PLAYERPOSX-1] == Map.FREE){
			Map.board[Map.PLAYERPOSY][Map.PLAYERPOSX] = Map.FREE;
			Map.board[Map.PLAYERPOSY][Map.PLAYERPOSX-1] = Map.PLAYER1; 
		}else{}
	}

	static public void goUp(){
		if(Map.board[Map.PLAYERPOSY-1][Map.PLAYERPOSX] == Map.FREE){
			Map.board[Map.PLAYERPOSY][Map.PLAYERPOSX] = Map.FREE;
			Map.board[Map.PLAYERPOSY-1][Map.PLAYERPOSX] = Map.PLAYER1; 
		}else{}
	}

	static public void goDown(){
		if(Map.board[Map.PLAYERPOSY+1][Map.PLAYERPOSX] == Map.FREE){
			Map.board[Map.PLAYERPOSY][Map.PLAYERPOSX] = Map.FREE;
			Map.board[Map.PLAYERPOSY+1][Map.PLAYERPOSX] = Map.PLAYER1; 
		}else{}
	}

	static public void goRight(){
		if(Map.board[Map.PLAYERPOSY][Map.PLAYERPOSX+1] == Map.FREE){
			Map.board[Map.PLAYERPOSY][Map.PLAYERPOSX] = Map.FREE;
			Map.board[Map.PLAYERPOSY][Map.PLAYERPOSX+1] = Map.PLAYER1; 
		}else{}
	}

}
