package card.monstercard;

import card.base.MonsterCard;
import player.Player;

public class PriestM extends MonsterCard {
	private int healTurn;

	public PriestM() {
		super("Priest","This is description.",3,1,6,0);
		healTurn = 0;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void firstRowAction(Player attacker,Player defender) {
		if(healTurn == 1) {
			attacker.changeLifePoint(-1);
			healTurn = -1;
		}
		healTurn++;
	}

}
