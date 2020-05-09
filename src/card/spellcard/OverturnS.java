package card.spellcard;

import board.Position;
import card.base.SpellCard;
import player.Player;

public class OverturnS extends SpellCard {

	public OverturnS(String name, String description, int manaCost, int cardLimit) {
		super("Firestorm", "This is description.", 3, 1);
	}

	@Override
	public void equip(Player attacker, Player defender) {
		for(int i=0;i<attacker.getBoard().getBoardSize();i++) {
			if(attacker.getBoard().getGameBoard()[i].getSecondRowCard()!=null) {
				int atk = attacker.getMonsterCard(new Position(i,1)).getAttackPoint();
				int hp = attacker.getMonsterCard(new Position(i,1)).getLifePoint();
				attacker.getMonsterCard(new Position(i,1)).setAttackPoint(hp);
				attacker.getMonsterCard(new Position(i,1)).setLifePoint(atk);
			}
		}

	}

}
