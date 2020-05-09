package card.spellcard;

import card.base.SpellCard;
import player.Player;

public class GoldMineS extends SpellCard {

	public GoldMineS() {
		super("Gold Mine", "This is description.", 3, 1);
	}

	@Override
	public void equip(Player attacker, Player defender) {
		attacker.drawCard(2);

	}

}
