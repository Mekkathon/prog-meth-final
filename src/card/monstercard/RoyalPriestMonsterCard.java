package card.monstercard;

import card.base.MonsterCard;
import player.Player;

public class RoyalPriestMonsterCard extends MonsterCard {

	public RoyalPriestMonsterCard() {
		super("Royal Priest","This is description.",3,1,6,0);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void action(Player attacker,Player defender) {
		attacker.changeLifePoint(-1);
	}

}
