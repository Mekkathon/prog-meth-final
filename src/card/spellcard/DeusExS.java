package card.spellcard;

import board.Position;
import card.base.SpellCard;
import player.Player;

public class DeusExS extends SpellCard {

	public DeusExS() {
		super("Deus Ex Machina", "This is description.", 5, 1);
	}

	@Override
	public void equip(Player attacker, Player defender) {
		for(int i=0;i<attacker.getBoard().getBoardSize();i++) {
			attacker.getMonsterCard(new Position(i,0)).changeLifePoint(-2);
			if(attacker.getMonsterCard(new Position(i,1))!=null) {
				attacker.getMonsterCard(new Position(i,1)).changeLifePoint(-2);
			}
		}

	}

}
