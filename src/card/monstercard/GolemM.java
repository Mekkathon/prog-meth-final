package card.monstercard;

import card.base.DeathTrigger;
import card.base.MonsterCard;
import player.Player;

public class GolemM extends MonsterCard implements DeathTrigger{
	public GolemM() {
		super("Golem","This is description.",4,1,6,1);
	}

	public void deathTrigger(Player player) {
		MonsterCard minion = new GolemMinionM();
		player.getBoard().insertCard(minion,column);
		player.getBoard().insertCard(minion,column);
	}
}
