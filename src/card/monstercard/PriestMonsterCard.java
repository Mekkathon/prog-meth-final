package card.monstercard;

import card.base.MonsterCard;
import player.Player;

public class PriestMonsterCard extends MonsterCard {

	public PriestMonsterCard() {
		super("Priest","This is description.",3,2,6,0);
	}
	
	@Override
	public void action(Player attacker,Player defender) {
		if(column!=0) attacker.getMonsterCard(column-1, 0).changeLifePoint(-2);
		if(column!=attacker.getBoard().getBoardSize()) attacker.getMonsterCard(column+1, 0).changeLifePoint(-2);
	}

}
