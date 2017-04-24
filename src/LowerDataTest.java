import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class LowerDataTest {
	@Test
	public void testClearPossibleScores() {
		BonusDie bd = new BonusDie();
		Hand hnd = new Hand(bd);
		LowerData test = new LowerData(hnd, bd);
		hnd.getDie(0).diceValue = 1;
		hnd.getDie(1).diceValue = 1;
		hnd.getDie(2).diceValue = 1;
		hnd.getDie(3).diceValue = 1;
		hnd.getDie(4).diceValue = 1;
		if(bd.getSideUp() == 1){
			hnd.getDie(5).diceValue = 1;
		}
		ArrayList<Integer> tmp = new ArrayList();
		tmp = test.getPossibleScores();
		hnd.getDie(0).diceValue = 1;
		hnd.getDie(1).diceValue = 3;
		hnd.getDie(2).diceValue = 1;
		hnd.getDie(3).diceValue = 4;
		hnd.getDie(4).diceValue = 5;
		if(bd.getSideUp() == 1){
			hnd.getDie(5).diceValue = 2;
		}
		assertNotEquals(tmp.get(5), test.getPossibleScores().get(5));
		
	}

	@Test
	public void testGetPossibleScores() {
		BonusDie bd = new BonusDie();
		Hand hnd = new Hand(bd);
		LowerData test = new LowerData(hnd, bd);
		hnd.getDie(0).diceValue = 1;
		hnd.getDie(1).diceValue = 1;
		hnd.getDie(2).diceValue = 1;
		hnd.getDie(3).diceValue = 1;
		hnd.getDie(4).diceValue = 1;
		
		ArrayList<Integer> tmp = new ArrayList();
		if(bd.getSideUp() == 1){
			hnd.getDie(5).diceValue = 1;
			tmp.add(6);
			tmp.add(6);
			tmp.add(25);
			tmp.add(0);
			tmp.add(0);
			tmp.add(50);
			tmp.add(6);
		}
		else if(bd.getSideUp() == 2){
			tmp.add(10);
			tmp.add(10);
			tmp.add(50);
			tmp.add(0);
			tmp.add(0);
			tmp.add(100);
			tmp.add(10);
		}
		else if (bd.getSideUp() == 6){
			tmp.add(15);
			tmp.add(15);
			tmp.add(75);
			tmp.add(0);
			tmp.add(0);
			tmp.add(150);
			tmp.add(15);
		}
		else{
			tmp.add(5);
			tmp.add(5);
			tmp.add(25);
			tmp.add(0);
			tmp.add(0);
			tmp.add(50);
			tmp.add(5);
		}
			
		ArrayList actual = new ArrayList();
		actual = test.getPossibleScores();
		for(int i = 0; i < 7; i++)
			assertEquals(tmp.get(i), actual.get(i));
				
	}

	@Test
	public void testGetPossibleScorePrime() {
		BonusDie bd = new BonusDie();
		Hand hnd = new Hand(bd);
		LowerData test = new LowerData(hnd, bd);
		hnd.getDie(0).diceValue = 1;
		hnd.getDie(1).diceValue = 2;
		hnd.getDie(2).diceValue = 3;
		hnd.getDie(3).diceValue = 4;
		hnd.getDie(4).diceValue = 5;
		if(bd.getSideUp() == 2){
			assertEquals(80, test.getPossibleScorePrime(4));
			assertEquals(60, test.getPossibleScorePrime(3));
		}
		else if (bd.getSideUp() == 6){
			assertEquals(120, test.getPossibleScorePrime(4));
			assertEquals(90, test.getPossibleScorePrime(3));
		}else{
			assertEquals(40, test.getPossibleScorePrime(4));
			assertEquals(30, test.getPossibleScorePrime(3));
		}
		
		
	}

	
}
