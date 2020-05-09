package card.base;

import player.Player;

public abstract class SpellCard extends Card{
	public SpellCard(String name,String description, int manaCost, int cardLimit) {
		super(name,"Spell",description,manaCost,cardLimit);
	}
	
	public abstract void equip(Player attacker,Player defender);
}
