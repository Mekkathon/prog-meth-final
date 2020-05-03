package card.monstercard;

import card.base.MonsterCard;
import player.Player;

public class MageMonsterCard extends MonsterCard{
	private int attackTurn; // for Counting Turn WIP
	public MageMonsterCard() {
		super("Mage","This is description.",3,2,3,2);
		attackTurn = 0;
	}

	@Override
	public void secondRowAction(Player attacker,Player defender) {
		this.firstRowAction(attacker,defender);
	}
	
	@Override
	public void action(Player attacker,Player defender) {
		if(this.turn==0) return;
		if(row==0) firstRowAction(attacker,defender);
		else secondRowAction(attacker,defender);
		if(attackTurn == 2) {
			attacker.changeLifePoint(getAttackPoint());
			attackTurn = -1;
		}
		attackTurn++;
	}
}
