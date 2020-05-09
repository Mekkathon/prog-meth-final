package card.monstercard;

import card.base.MonsterCard;
import card.base.SecondRow;
import player.Player;

public class ArcherM extends MonsterCard implements SecondRow{
	private int attackTurn; // for Counting Turn WIP
	public ArcherM() {
		super("Archer","This is description.",3,2,3,2);
		attackTurn = 0;
	}

	public void secondRowAction(Player attacker,Player defender) {
		this.firstRowAction(attacker,defender);
	}
	
	@Override
	public void action(Player attacker,Player defender) {
		super.action(attacker, defender);
		
		if(attackTurn == 2) {
			attacker.changeLifePoint(getAttackPoint());
			attackTurn = -1;
		}
		attackTurn++;
	}
}
