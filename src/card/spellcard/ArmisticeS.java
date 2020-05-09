package card.spellcard;

import application.GameSimulation;
import card.base.SpellCard;
import player.Player;

public class ArmisticeS extends SpellCard {

	public ArmisticeS() {
		super("Armistice", "This is description.", 1, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void equip(Player attacker, Player defender) {
		GameSimulation.setTurnStatus(2);

	}

}
