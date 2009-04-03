package fileHandling;

import dataCollecting.Player;

/**
 * Collects statistics from in-game
 * @author caj.hofberg
 *
 */
public class StatisticsCollector {
	private int hiscore = 0;

	public void setHiscore(Player[] players, int numPlayers) {
		for (int i = 0; i < numPlayers; numPlayers++)
		hiscore = players[i].getScore();
	}

	public int getHiscore() {
		return hiscore;
	}
}
