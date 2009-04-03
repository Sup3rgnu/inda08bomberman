package dataCollecting;

/**
 * Stores data about each player. Players may be accessed as Player[n].
 * @author caj.hofberg
 *
 */
public class Player {
	private String name = "Noname";
	private int score = 0;
	
	public void setName() {
		//TODO: fix input popup asking for name
	}
	/**
	 * For use with networking
	 * Example: Fetch a name from a peer and run setName(name)
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void addScore() {
		score++;
	}
	public void addScore(int change) {
		score += change;
	}
	public int getScore() {
		return score;
	}
}