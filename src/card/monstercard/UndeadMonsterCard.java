package card.monstercard;

import card.base.Card;
import card.base.MonsterCard;
import player.Player;

public class UndeadMonsterCard extends MonsterCard{
	public UndeadMonsterCard() {
		super("Undead","This is description.", 3,1,3,2);
	}
	@Override
	public void deathTrigger(Player player) {
		Card newCard = new UndeadMonsterCard();
		player.addCard(newCard);
	}
}
