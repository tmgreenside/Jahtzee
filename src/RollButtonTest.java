import static org.junit.Assert.*;

import org.junit.*;

public class RollButtonTest {

	@Test
	public void testRollButton() {
		BonusDie bd = new BonusDie();
		Hand h1 = new Hand(bd);
		HandPanel hp = new HandPanel(h1);
		ScorecardScrollBox scsb = new ScorecardScrollBox();
		RollButton button = new RollButton(hp, scsb);
		assertTrue(button.getClicked() == 0);
		assertTrue(button.getTurns() == 3);
	}

	@Test
	public void testIncrementClicked() {
		BonusDie bd = new BonusDie();
		Hand h1 = new Hand(bd);
		HandPanel hp = new HandPanel(h1);
		ScorecardScrollBox scsb = new ScorecardScrollBox();
		RollButton button = new RollButton(hp, scsb);
		for (int i = 0; i < 3; i++)
		{
		   button.incrementClicked();
		}
		assertTrue(button.getClicked() == 3);
	}

	@Test
	public void testGetClicked() {
		BonusDie bd = new BonusDie();
		Hand h1 = new Hand(bd);
		HandPanel hp = new HandPanel(h1);
		ScorecardScrollBox scsb = new ScorecardScrollBox();
		RollButton button = new RollButton(hp, scsb);
		button.incrementClicked();
		assertTrue(button.getClicked() == 1);
	}

	@Test
	public void testUpdateIsKept() {
		BonusDie bd = new BonusDie();
		Hand h1 = new Hand(bd);
		HandPanel hp = new HandPanel(h1);
		ScorecardScrollBox scsb = new ScorecardScrollBox();
		RollButton button = new RollButton(hp, scsb);
		int numDice = 5;
		for (int i = 0; i < numDice; i++)
		{
			if (hp.getButtons().get(i).isSelected())
			{
				hp.getHand().getDie(i).setIsKept(true);
				assertTrue(hp.getHand().getDie(i).getIsKept() == true);
				
			}
			else
			{
				hp.getHand().getDie(i).setIsKept(false);
				assertTrue(hp.getHand().getDie(i).getIsKept() == false);
			}
			
		}
	}

	@Test
	public void testGetTurns() {
		BonusDie bd = new BonusDie();
		Hand h1 = new Hand(bd);
		HandPanel hp = new HandPanel(h1);
		ScorecardScrollBox scsb = new ScorecardScrollBox();
		RollButton button = new RollButton(hp, scsb);
		assertTrue(button.getTurns() == 3);
	
	}

	@Test
	public void testSetRule() {
		BonusDie bd = new BonusDie();
		Hand h1 = new Hand(bd);
		HandPanel hp = new HandPanel(h1);
		ScorecardScrollBox scsb = new ScorecardScrollBox();
		RollButton button = new RollButton(hp, scsb);
		button.setRule();
		assertTrue(button.getTurns() == 4);
	}

	@Test
	public void testResetRule() {
		BonusDie bd = new BonusDie();
		Hand h1 = new Hand(bd);
		HandPanel hp = new HandPanel(h1);
		ScorecardScrollBox scsb = new ScorecardScrollBox();
		RollButton button = new RollButton(hp, scsb);
		assertTrue(button.getTurns() == 3);
	}
	
	@Test
	public void testGetAllKept() {
		BonusDie bd = new BonusDie();
		Hand h1 = new Hand(bd);
		HandPanel hp = new HandPanel(h1);
		ScorecardScrollBox scsb = new ScorecardScrollBox();
		RollButton button = new RollButton(hp, scsb);
		assertTrue(button.getAllKept() == 0);
	}
	
	@Test
	public void testSetClicked() {
		BonusDie bd = new BonusDie();
		Hand h1 = new Hand(bd);
		HandPanel hp = new HandPanel(h1);
		ScorecardScrollBox scsb = new ScorecardScrollBox();
		RollButton button = new RollButton(hp, scsb);
		int i = 2;
		button.setClicked(i);
		assertTrue(button.getClicked() == 2);
	}
}