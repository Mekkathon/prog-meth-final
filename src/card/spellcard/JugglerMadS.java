package card.spellcard;

import board.Position;
import card.base.MonsterCard;
import card.base.SpellCard;
import player.Player;

public class JugglerMadS extends SpellCard {

	public JugglerMadS(String name, String description, int manaCost, int cardLimit) {
		super("Juggler's Madness","This is description.",1,1);
	}

	@Override
	public void equip(Player attacker, Player defender) {
		for(int i=0;i<defender.getBoard().getBoardSize();i++) {
			if(defender.getMonsterCard(new Position(i,1))!=null) {
				MonsterCard temp = defender.getMonsterCard(new Position(i,0));
				MonsterCard temp2 = defender.getMonsterCard(new Position(i,1));
				defender.setMonsterCard(temp, new Position(i,1));
				defender.setMonsterCard(temp2, new Position(i,0));
			}
		}
	}

}
