package card.monstercard;

import card.base.Card;
import card.base.MonsterCard;
import player.Player;

public class UndeadMonsterCard extends MonsterCard{
	public UndeadMonsterCard(int cost) {
		super("Undead","This is description.",cost,1,3,2);
	}
	@Override
	public void deathTrigger(Player player) {
		int cost = this.manaCost;
		Card newCard = new UndeadMonsterCard(cost+1);
		player.addCard(newCard);
	}
}
