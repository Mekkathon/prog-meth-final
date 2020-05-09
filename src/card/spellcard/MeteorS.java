package card.spellcard;

import java.util.Random;

import board.Position;
import card.base.SpellCard;
import player.Player;

public class MeteorS extends SpellCard {

	public MeteorS() {
		super("Meteor", "This is description.", 5, 1);
	}

	@Override
	public void equip(Player attacker, Player defender) {
		Random rand = new Random();
		int cnt=0;
		while(cnt<4) {
			int a = rand.nextInt(defender.getBoard().getBoardSize()+1);
			if(a==defender.getBoard().getBoardSize()) {
				defender.changeLifePoint(1);
				cnt++;
			}
			else {
				if(defender.getMonsterCard(new Position(a,1))!=null) {
					defender.getMonsterCard(new Position(a,1)).changeLifePoint(1);
					cnt++;
				}
			}
			defender.getBoard().updateBoard(defender);
		}
		

	}

}
