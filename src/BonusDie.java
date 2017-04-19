//package goupproject;

import java.util.*;

public class BonusDie extends Die{
	private String rule;
	
	public BonusDie() {
		// TODO Auto-generated constructor stub
		this.rollDie();
		rule = "";
		updateRule();
		
	}
	public void updateRule(){
		switch(this.diceValue){
		case 1:
			rule = "Extra Die";
			break;
		case 2: 
			rule = "Double Score";
			break;
		case 3: 
			rule = "Double or Nothing";
			break;
		case 4:
			rule = "Extra roll";
			break;
		case 5: 
			rule = "Forced Trivia";
			break;
		case 6: 
			rule = "Triple Score";
			break;
		}
	}
	public String getRule(){
		return rule;
	}
	public int getSideUp(){
		return diceValue;
	}

}
