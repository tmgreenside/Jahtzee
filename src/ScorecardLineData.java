

/**
 * The file creates the implementation for a score card line
 * used in a full game of one-player Jahtzee! that is 
 * responsible for getting and setting the score of each
 * score card line in Jahtzee!
 *
 * @author Carlos Villagomez (cvillagomez)
 * @version Last Changed: 17 April 2017
 * CPSC 224 Group Project
 */

public class ScorecardLineData {
	private int score; // score of line
	private BonusDie bonus; // bonus die
	
	public ScorecardLineData(BonusDie bonus) {
		score = 0;
		this.bonus = bonus;
	}

	/**
	 * Sets the score at specified line.
	 * 
	 * @param userScore
	 *            the score of line based on user's hand
	 */
	public void setScore(int userScore) {
		if (bonus.getSideUp() == 2) {
			int doubleScore = 2 * userScore;
			this.score = doubleScore;
		}
		if (bonus.getSideUp() == 6) {
			int tripleScore = 3 * userScore;
			this.score = tripleScore;
		}	
		this.score = userScore;
	}

	/**
	 * Gets the score at specified line.
	 * 
	 * @return score the score at the corresponding line
	 */
	public int getScore() {
		return score;
	}	
	
	/**
	 * Gets the bonus score 
	 * 
	 * @return
	 */
	public int getBonusSide() {
		if (bonus.getSideUp() == 2) {
			int doubleScore = 2 * getScore();
			return getScore();
		}
		if (bonus.getSideUp() == 6) {
			int tripleScore = 3 * getScore();
			return tripleScore;
		}
		return getScore();
	}
}
