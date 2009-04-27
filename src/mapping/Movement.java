package mapping;

public class Movement {

	static public void goLeft(){
		if(Map.board[Map.PLAYERPOSY][Map.PLAYERPOSX-1] == Map.FREE){
			if(Map.board[Map.PLAYERPOSY][Map.PLAYERPOSX] == Map.PLAYERANDBOMB){		
				Map.board[Map.PLAYERPOSY][--Map.PLAYERPOSX] = Map.PLAYER1;	
				Map.board[Map.PLAYERPOSY][Map.PLAYERPOSX] = Map.BOMB1;
			}else if(Map.board[Map.PLAYERPOSY][Map.PLAYERPOSX-1] == Map.EXPLOSION){
				drawing.Popup.youLost();
			}else{
				Map.board[Map.PLAYERPOSY][Map.PLAYERPOSX] = Map.FREE;
				Map.board[Map.PLAYERPOSY][--Map.PLAYERPOSX] = Map.PLAYER1;}
		}else{
			}
		}

	static public void goUp(){
		if(Map.board[Map.PLAYERPOSY-1][Map.PLAYERPOSX] == Map.FREE){
			if(Map.board[Map.PLAYERPOSY][Map.PLAYERPOSX] == Map.PLAYERANDBOMB){
				Map.board[--Map.PLAYERPOSY][Map.PLAYERPOSX] = Map.PLAYER1;
				Map.board[Map.PLAYERPOSY][Map.PLAYERPOSX] = Map.BOMB1;
			}else if(Map.board[Map.PLAYERPOSY-1][Map.PLAYERPOSX] == Map.EXPLOSION){
				drawing.Popup.youLost();
			}else{
				Map.board[Map.PLAYERPOSY][Map.PLAYERPOSX] = Map.FREE;
				Map.board[--Map.PLAYERPOSY][Map.PLAYERPOSX] = Map.PLAYER1;}
		}else{}
	}

	static public void goDown(){
		if(Map.board[Map.PLAYERPOSY+1][Map.PLAYERPOSX] == Map.FREE){
			if(Map.board[Map.PLAYERPOSY][Map.PLAYERPOSX] == Map.PLAYERANDBOMB){
				Map.board[++Map.PLAYERPOSY][Map.PLAYERPOSX] = Map.PLAYER1;
				Map.board[Map.PLAYERPOSY][Map.PLAYERPOSX] = Map.BOMB1;
			}else if(Map.board[Map.PLAYERPOSY+1][Map.PLAYERPOSX] == Map.EXPLOSION){
				drawing.Popup.youLost();
			}else{
				Map.board[Map.PLAYERPOSY][Map.PLAYERPOSX] = Map.FREE;
				Map.board[++Map.PLAYERPOSY][Map.PLAYERPOSX] = Map.PLAYER1;
				}
		}else{}
	}

	static public void goRight(){
		if(Map.board[Map.PLAYERPOSY][Map.PLAYERPOSX+1] == Map.FREE){
			if(Map.board[Map.PLAYERPOSY][Map.PLAYERPOSX] == Map.PLAYERANDBOMB){
				Map.board[Map.PLAYERPOSY][++Map.PLAYERPOSX] = Map.PLAYER1; 
				Map.board[Map.PLAYERPOSY][Map.PLAYERPOSX] = Map.BOMB1;
			}else if(Map.board[Map.PLAYERPOSY][Map.PLAYERPOSX+1] == Map.EXPLOSION){
				drawing.Popup.youLost();
			}else{
				Map.board[Map.PLAYERPOSY][Map.PLAYERPOSX] = Map.FREE;
				Map.board[Map.PLAYERPOSY][++Map.PLAYERPOSX] = Map.PLAYER1;}
		}else{}
	}

	static public void dropBomb(){
		if(Map.bombOnBoard == false){
			Map.board[Map.PLAYERPOSY][Map.PLAYERPOSX] = Map.PLAYERANDBOMB;
			Map.BOMBPOSY = Map.PLAYERPOSY;
			Map.BOMBPOSX = Map.PLAYERPOSX;
			Map.BOMBTIMER = Map.timer + Map.BOMBTIME;
			Map.EXPTIMER = Map.timer + Map.EXPTIME;
			Map.bombOnBoard = true;
		}else{}
	}

	static public void goLeft2(){
		if(Map.board[Map.PLAYER2POSY][Map.PLAYER2POSX-1] == Map.FREE){
			if(Map.board[Map.PLAYER2POSY][Map.PLAYER2POSX] == Map.PLAYERANDBOMB2){
				Map.board[Map.PLAYER2POSY][--Map.PLAYER2POSX] = Map.PLAYER2;
				Map.board[Map.PLAYERPOSY][Map.PLAYERPOSX] = Map.BOMB2;
			}else if(Map.board[Map.PLAYER2POSY][Map.PLAYER2POSX] == Map.EXPLOSION){
				drawing.Popup.youWon();
			}else{
				Map.board[Map.PLAYER2POSY][Map.PLAYER2POSX] = Map.FREE;
				Map.board[Map.PLAYER2POSY][--Map.PLAYER2POSX] = Map.PLAYER2;}
		}else{}
	}

	static public void goUp2(){
		if(Map.board[Map.PLAYER2POSY-1][Map.PLAYER2POSX] == Map.FREE){
			if(Map.board[Map.PLAYER2POSY][Map.PLAYER2POSX] == Map.PLAYERANDBOMB2){
				Map.board[--Map.PLAYER2POSY][Map.PLAYER2POSX] = Map.PLAYER2;
				Map.board[Map.PLAYERPOSY][Map.PLAYERPOSX] = Map.BOMB2;
			}else if(Map.board[Map.PLAYER2POSY][Map.PLAYER2POSX] == Map.EXPLOSION){
				drawing.Popup.youWon();
			}else{
				Map.board[Map.PLAYER2POSY][Map.PLAYER2POSX] = Map.FREE;
				Map.board[--Map.PLAYER2POSY][Map.PLAYER2POSX] = Map.PLAYER2;}
		}else{}
	}

	static public void goDown2(){
		if(Map.board[Map.PLAYER2POSY+1][Map.PLAYER2POSX] == Map.FREE){
			if(Map.board[Map.PLAYER2POSY][Map.PLAYER2POSX] == Map.PLAYERANDBOMB2){
				Map.board[++Map.PLAYER2POSY][Map.PLAYER2POSX] = Map.PLAYER2;
				Map.board[Map.PLAYERPOSY][Map.PLAYERPOSX] = Map.BOMB2;
			}else if(Map.board[Map.PLAYER2POSY][Map.PLAYER2POSX] == Map.EXPLOSION){
				drawing.Popup.youWon();
			}else{
				Map.board[Map.PLAYER2POSY][Map.PLAYER2POSX] = Map.FREE;
				Map.board[++Map.PLAYER2POSY][Map.PLAYER2POSX] = Map.PLAYER2;}
		}else{}
	}

	static public void goRight2(){
		if(Map.board[Map.PLAYER2POSY][Map.PLAYER2POSX+1] == Map.FREE){
			if(Map.board[Map.PLAYER2POSY][Map.PLAYER2POSX] == Map.PLAYERANDBOMB2){
				Map.board[Map.PLAYER2POSY][++Map.PLAYER2POSX] = Map.PLAYER2;
				Map.board[Map.PLAYERPOSY][Map.PLAYERPOSX] = Map.BOMB2;
			}else if(Map.board[Map.PLAYER2POSY][Map.PLAYER2POSX] == Map.EXPLOSION){
				drawing.Popup.youWon();
			}else{	
				Map.board[Map.PLAYER2POSY][Map.PLAYER2POSX] = Map.FREE;
				Map.board[Map.PLAYER2POSY][++Map.PLAYER2POSX] = Map.PLAYER2;}
		}else{}
	} 

	static public void dropBomb2(){
		if(Map.bomb2OnBoard == false){
			Map.board[Map.PLAYER2POSY][Map.PLAYER2POSX] = Map.PLAYERANDBOMB2;
			Map.BOMB2POSY = Map.PLAYER2POSY;
			Map.BOMB2POSX = Map.PLAYER2POSX;
			Map.BOMB2TIMER = Map.timer + Map.BOMBTIME;
			Map.EXPTIMER = Map.timer + Map.EXPTIME;
			Map.bomb2OnBoard = true;
		}else{}
	}
}


