package card.spellcard;

import card.base.*;
import card.monstercard.SpiritM;
import player.Player;

public class SpiritBeastS extends SpellCard {

	public SpiritBeastS() {
		super("Spirit of the Beast","This is description",1,3);
	}

	@Override
	public void equip(Player attacker, Player defender) {
		MonsterCard spirit = new SpiritM();
		defender.getBoard().insertCard(spirit,0);
	}

}
