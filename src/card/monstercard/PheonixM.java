package card.monstercard;

import java.util.ArrayList;

import board.Position;
import card.base.DeathTrigger;
import card.base.MonsterCard;
import player.Player;

public class PheonixM extends MonsterCard implements DeathTrigger{

	public PheonixM() {
		super("Pheonix", "This is description.", 7, 1, 6, 1);
	}
	
	@Override
	public void firstRowAction(Player attacker, Player defender) {
		changeLifePoint(-2);
		int atSize = attacker.getBoard().getBoardSize();
		int deSize = defender.getBoard().getBoardSize();
		
		ArrayList<Position> pos = getAttackableCard(atSize,deSize);
		
		if(pos.isEmpty()) {
			defender.changeLifePoint(getAttackPoint());
		}
		else for(Position p:pos) {
			attack(defender.getMonsterCard(p),getAttackPoint());
		}
	}
	
	public void deathTrigger(Player player) {
		for(int i=0;i<player.getBoard().getBoardSize();i++) {
			player.getBoard().getGameBoard()[i].getFirstRowCard().changeLifePoint(-1);
			if(player.getBoard().getGameBoard()[i].getSecondRowCard()!=null) {
				player.getBoard().getGameBoard()[i].getSecondRowCard().changeLifePoint(-1);
			}
		}
	}

}
