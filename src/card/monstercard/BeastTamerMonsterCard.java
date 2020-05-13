package card.monstercard;

import board.Board;
import board.CardColumn;
import card.base.Card;
import card.base.MonsterCard;
import player.Player;

public class BeastTamerMonsterCard extends MonsterCard {
	public BeastTamerMonsterCard() {
		super("Beast Tamer","This is description.",4,1,6,1);
	}
	@Override
	public void deathTrigger(Player player) {
		MonsterCard beast = new MonsterCard("Beast","This is description.",0,0,3,1);
		beast.setTurn(1);
		player.getBoard().insertCard(beast,column);
		player.getBoard().insertCard(beast,column);
	}
}
