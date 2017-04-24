import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

public class UpperDataTest {

	@Test
	public void testUpperData() {
		BonusDie bonus = new BonusDie();
		Hand hand_1 = new Hand(bonus);
		UpperData upper = new UpperData(hand_1, bonus);
		ArrayList<Integer> upperScores = new ArrayList<Integer>();
		ArrayList<Integer> nsTotal = new ArrayList<Integer>();
		ArrayList<Integer> possibleScores = new ArrayList<Integer>();
		int onesLine = 0;
		int possibleScore = 0;
		upperScores.add(onesLine);
		nsTotal.add(onesLine);
		possibleScores.add(possibleScore);
		
		assertTrue(upperScores.get(0) == onesLine);
		assertTrue(nsTotal.get(0) == onesLine);
		assertTrue(possibleScores.get(0) == possibleScore);
	}

	@Test
	public void testGetPossibleScores() {
		BonusDie bonus = new BonusDie();
		Hand hand_1 = new Hand(bonus);
		UpperData upper = new UpperData(hand_1, bonus);
		ArrayList<Integer> upperScores = new ArrayList<Integer>();
		ArrayList<Integer> nsTotal = new ArrayList<Integer>();
		ArrayList<Integer> possibleScores = new ArrayList<Integer>();
		int possibleScore = 30;
		possibleScores.add(possibleScore);
		assertTrue(possibleScores.get(0) == 30);
	}
	
	@Test
	public void testClearPossibleScores() {
		BonusDie bonus = new BonusDie();
		Hand hand_1 = new Hand(bonus);
		UpperData upper = new UpperData(hand_1, bonus);
		ArrayList<Integer> upperScores = new ArrayList<Integer>();
		ArrayList<Integer> nsTotal = new ArrayList<Integer>();
		ArrayList<Integer> possibleScores = new ArrayList<Integer>();
		int possibleScore = 20;
		possibleScores.add(possibleScore);
		upper.clearPossibleScores();
		assertTrue(upper.getPossibleScores().get(0) == 0);
	}
	
	@Test
	public void testGetPossibleScoresPrime() {
		BonusDie bonus = new BonusDie();
		Hand hand_1 = new Hand(bonus);
		UpperData upper = new UpperData(hand_1, bonus);
		ArrayList<Integer> upperScores = new ArrayList<Integer>();
		ArrayList<Integer> nsTotal = new ArrayList<Integer>();
		ArrayList<Integer> possibleScores = new ArrayList<Integer>();
		int score = 30;
		if (hand_1.getBonusDie().getSideUp() == 2){
			score = score * 2;
		}
		if (hand_1.getBonusDie().getSideUp() == 6){
			score = score * 3;
		}
		else {
			score = score * 1;
		}
		possibleScores.add(score);
		assertTrue(possibleScores.get(0) == score);
	}

	@Test
	public void testNsTotal() {
		BonusDie bonus = new BonusDie();
		Hand hand_1 = new Hand(bonus);
		UpperData upper = new UpperData(hand_1, bonus);
		ArrayList<Integer> nsTotal = new ArrayList<Integer>();
		int currentCount = 3;
		int i = 1;
		int score = i * currentCount;
		nsTotal.add(score);
		assertTrue(nsTotal.get(0) == 3);
	}

	@Test
	public void testGetNsTotal() {
		BonusDie bonus = new BonusDie();
		Hand hand_1 = new Hand(bonus);
		UpperData upper = new UpperData(hand_1, bonus);
		ArrayList<Integer> nsTotal = new ArrayList<Integer>();
		int currentCount1 = 3;
		int line1 = 1;
		int score1 = line1 * currentCount1;
		int currentCount2 = 2;
		int line2 = 2;
		int score2 = line2 * currentCount2;
		nsTotal.add(score1);
		nsTotal.add(score2);
		assertTrue(nsTotal.get(0) == score1);
		assertTrue(nsTotal.get(1) == score2);
	}

	@Test
	public void testAddScoreToLineN() {
		BonusDie bonus = new BonusDie();
		Hand hand_1 = new Hand(bonus);
		UpperData upper = new UpperData(hand_1, bonus);
		ArrayList<Integer> nsTotal = new ArrayList<Integer>();
		int score1 = 20;
		int score2 = 10;
		nsTotal.add(score1);
		nsTotal.add(score2);
		assertTrue(nsTotal.get(0) == score1);
		assertTrue(nsTotal.get(1) == score2);
	}

	@Test
	public void testGetUpperScores() {
		BonusDie bonus = new BonusDie();
		Hand hand_1 = new Hand(bonus);
		UpperData upper = new UpperData(hand_1, bonus);
		ArrayList<Integer> upperScores = new ArrayList<Integer>();
		int score1 = 20;
		int score2 = 10;
		upperScores.add(score1);
		upperScores.add(score2);
		assertTrue(upperScores.get(0) == score1);
		assertTrue(upperScores.get(1) == score2);
	}
}
