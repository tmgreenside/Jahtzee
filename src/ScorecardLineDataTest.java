import static org.junit.Assert.*;
import org.junit.*;

public class ScorecardLineDataTest {

	@Test
	public void testScorecardLineData() {
		BonusDie bonus = new BonusDie();
		ScorecardLineData card = new ScorecardLineData(bonus);
		assertTrue(card.getScore() == 0);
		
	}

	@Test
	public void testSetScore() {
		BonusDie bonus = new BonusDie();
		ScorecardLineData card = new ScorecardLineData(bonus);
		int userScore = 10;
		int doubleScore = 2 * userScore;
		card.setScore(doubleScore);
		assertTrue(card.getScore() == doubleScore);
	}

	@Test
	public void testGetScore() {
		BonusDie bonus = new BonusDie();
		ScorecardLineData card = new ScorecardLineData(bonus);
		assertTrue(card.getScore() == 0);
	}

	@Test
	public void testGetBonusSide() {
		BonusDie bonus = new BonusDie();
		ScorecardLineData card = new ScorecardLineData(bonus);
		card.getBonusSide();
		int userScore = 10;
		if (bonus.getSideUp() == 2) {
			int doubleScore = 2 * userScore;
			card.setScore(doubleScore);
			assert(card.getScore() == doubleScore);
		}
		if (bonus.getSideUp() == 6) {
			int tripleScore = 3 * userScore;
			card.setScore(tripleScore);
			assert(card.getScore() == tripleScore);
		}
	}
}