package card.monstercard;

import card.base.MonsterCard;
import player.Player;

public class MageMonsterCard extends MonsterCard{
	private int count; // for Counting Turn WIP
	public MageMonsterCard() {
		super("Mage","This is description.",3,2,3,2);
		count = 0;
	}

	@Override
	public void secondRowAction(Player attacker,Player defender) {
		this.action(attacker,defender);
	}
	
	/*
	 if(count == 2){
	 	opponent.changeLifePoint(attackPoint);
	 	count = 0;
	 }
	 count++;
	 */
}
