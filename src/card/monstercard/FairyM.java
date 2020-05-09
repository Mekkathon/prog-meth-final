package card.monstercard;

import board.Position;
import card.base.MonsterCard;
import player.Player;

public class FairyM extends MonsterCard {

	public FairyM() {
		super("Fairy","This is description.",3,2,6,0);
	}
	
	@Override
	public void action(Player attacker,Player defender) {
		if(turn==0) return;
		if(column!=0) attacker.getMonsterCard(new Position(column-1, 0)).changeLifePoint(-2);
		if(column!=attacker.getBoard().getBoardSize()) attacker.getMonsterCard(new Position(column-1, 0)).changeLifePoint(-2);
	}

}
