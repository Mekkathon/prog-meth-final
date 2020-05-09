package card.monstercard;

import card.base.Card;
import card.base.DeathTrigger;
import card.base.MonsterCard;
import player.Player;

public class UndeadM extends MonsterCard implements DeathTrigger{
	public UndeadM() {
		super("Undead","This is description.",3,1,3,2);
	}

	public void deathTrigger(Player player) {
		Card newCard = new UndeadM();
		player.addCard(newCard);
	}
}
