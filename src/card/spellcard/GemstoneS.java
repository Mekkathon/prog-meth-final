package card.spellcard;

import card.base.SpellCard;
import player.Player;

public class GemstoneS extends SpellCard {

	public GemstoneS() {
		super("Gemstone", "This is description.", 1, 2);
	}

	@Override
	public void equip(Player attacker, Player defender) {
		attacker.addMaxMana();
	}

}
