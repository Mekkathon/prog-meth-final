package card.spellcard;

import card.base.SpellCard;
import player.Player;

public class ElixirS extends SpellCard {

	public ElixirS() {
		super("Elixir", "This is description.", 5, 1);
	}

	@Override
	public void equip(Player attacker, Player defender) {
		attacker.changeLifePoint(-5);
	}

}
