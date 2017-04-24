import static org.junit.Assert.*;

import org.junit.Test;

public class HandTest {

	@Test
	public void testRollHand() {
		BonusDie bd = new BonusDie();
		Hand test = new Hand(bd);
		for(int i = 0; i < 10; i ++){
			test.rollHand();
			for(int j = 0; j < 5; j++)
				assert(test.getDie(j).getSideUp() <= 6 && test.getDie(j).getSideUp() >= 1);
		}
	}

	@Test
	public void testRollBonusDie() {
		BonusDie bd = new BonusDie();
		Hand test = new Hand(bd);
		test.rollBonusDie();
		assertEquals(bd.getSideUp(), test.getBonusDie().getSideUp());
	}

	@Test
	public void testGetHand() {
		BonusDie bd = new BonusDie();
		Hand test = new Hand(bd);
		assertEquals(test, test.getHand());
	}

	@Test
	public void testGetBonusDie() {
		BonusDie bd = new BonusDie();
		Hand test = new Hand(bd);
		assertEquals(bd, test.getBonusDie());
	}

	@Test
	public void testGetHandSize() {
		BonusDie bd = new BonusDie();
		Hand test = new Hand(bd);
		for(int i = 0; i < 30; i++){
			test.rollBonusDie();
			if(test.getBonusDie().getSideUp() == 1){
				test.setRule();
				assertEquals(6, test.getHandSize());
				test.resetRule();
				assertEquals(5, test.getHandSize());
			}
		}
	}

	@Test
	public void testGetTurns() {
		BonusDie bd = new BonusDie();
		Hand test = new Hand(bd);
		for(int i = 0; i < 30; i++){
			test.rollBonusDie();
			if(test.getBonusDie().getSideUp() == 4){
				test.setRule();
				assertEquals(4, test.getTurns());
				test.resetRule();
				assertEquals(3, test.getTurns());
			}
		}
		
	}

	@Test
	public void testSetRule() {
		BonusDie bd = new BonusDie();
		Hand test = new Hand(bd);
		for(int i = 0; i < 30; i++){
			test.rollBonusDie();
			if(test.getBonusDie().getSideUp() == 4){
				test.setRule();
				assertEquals(4, test.getTurns());
				test.resetRule();
				assertEquals(3, test.getTurns());
			}
		}
		for(int i = 0; i < 30; i++){
			test.rollBonusDie();
			if(test.getBonusDie().getSideUp() == 1){
				test.setRule();
				assertEquals(6, test.getHandSize());
				test.resetRule();
				assertEquals(5, test.getHandSize());
			}
		}
	}

	@Test
	public void testResetRule() {
		BonusDie bd = new BonusDie();
		Hand test = new Hand(bd);
		for(int i = 0; i < 30; i++){
			test.rollBonusDie();
			if(test.getBonusDie().getSideUp() == 4){
				test.setRule();
				assertEquals(4, test.getTurns());
				test.resetRule();
				assertEquals(3, test.getTurns());
			}
		}
		for(int i = 0; i < 30; i++){
			test.rollBonusDie();
			if(test.getBonusDie().getSideUp() == 1){
				test.setRule();
				assertEquals(6, test.getHandSize());
				test.resetRule();
				assertEquals(5, test.getHandSize());
			}
		}
	}

	@Test
	public void testMaxOfAKind() {
		BonusDie bd = new BonusDie();
		Hand test = new Hand(bd);
		test.getDie(0).diceValue = 1;
		test.getDie(1).diceValue = 1;
		test.getDie(2).diceValue = 1;
		test.getDie(3).diceValue = 1;
		test.getDie(4).diceValue = 1;
		if(bd.getSideUp() == 1){
			test.getDie(5).diceValue = 1;
			assertEquals(6, test.maxOfAKind());
		}else{
			assertEquals(5, test.maxOfAKind());
		}
	}

	@Test
	public void testMaxStraight() {
		BonusDie bd = new BonusDie();
		Hand test = new Hand(bd);
		test.getDie(0).diceValue = 1;
		test.getDie(1).diceValue = 2;
		test.getDie(2).diceValue = 3;
		test.getDie(3).diceValue = 4;
		test.getDie(4).diceValue = 5;
		if(bd.getSideUp() == 1){
			test.getDie(5).diceValue = 6;
			assertEquals(6, test.maxStraight());
		}else{
			assertEquals(5, test.maxStraight());
		}
	}

	@Test
	public void testFullHouse() {
		BonusDie bd = new BonusDie();
		Hand test = new Hand(bd);
		test.getDie(0).diceValue = 2;
		test.getDie(1).diceValue = 2;
		test.getDie(2).diceValue = 3;
		test.getDie(3).diceValue = 3;
		test.getDie(4).diceValue = 3;
		if(bd.getSideUp() == 1){
			test.getDie(5).diceValue = 3;
			assertEquals(true, test.fullHouse());
		}else{
			assertEquals(true, test.fullHouse());
		}
	}

	@Test
	public void testSumOfValue() {
		BonusDie bd = new BonusDie();
		Hand test = new Hand(bd);
		test.getDie(0).diceValue = 2;
		test.getDie(1).diceValue = 2;
		test.getDie(2).diceValue = 3;
		test.getDie(3).diceValue = 3;
		test.getDie(4).diceValue = 3;
		if(bd.getSideUp() == 1){
			test.getDie(5).diceValue = 3;
			assertEquals(12, test.sumOfValue(3));
		}else{
			assertEquals(9, test.sumOfValue(3));
		}
	}

	@Test
	public void testTotalAllDie() {
		BonusDie bd = new BonusDie();
		Hand test = new Hand(bd);
		test.getDie(0).diceValue = 2;
		test.getDie(1).diceValue = 2;
		test.getDie(2).diceValue = 3;
		test.getDie(3).diceValue = 3;
		test.getDie(4).diceValue = 3;
		if(bd.getSideUp() == 1){
			test.getDie(5).diceValue = 3;
			assertEquals(16, test.totalAllDie());
		}else{
			assertEquals(13, test.totalAllDie());
		}
	}
	
}
