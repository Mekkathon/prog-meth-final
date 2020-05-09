package card.monstercard;

import java.util.Random;

import board.Position;
import card.base.Card;
import card.base.Initialize;
import card.base.MonsterCard;
import player.Player;

public class KrakenM extends MonsterCard implements Initialize{

	public KrakenM() {
		super("Kraken", "This is description.",7,1,6,2);
	}
	
	public void InitialAction(Player attacker, Player defender) {
		Random rand = new Random();
		for(int i=0;i<2;i++) {
			int a = rand.nextInt(defender.getBoard().getBoardSize());
			MonsterCard tMon = defender.getMonsterCard(new Position(a,0));
			defender.getBoard().removeCard(a, 0);
			attacker.addCard((Card)tMon.clone());
		}
		
	}

}
