package card.monstercard;

import java.util.ArrayList;

import board.Position;
import card.base.MonsterCard;
import card.base.SecondRow;
import player.Player;

public class DarkMageM extends MonsterCard implements SecondRow{

	public DarkMageM() {
		super("Dark Mage", "This is description.", 4, 1, 3, 1);
	}
	
	public void secondRowAction(Player attacker, Player defender) {
		firstRowAction(attacker, defender);
	}
	
	@Override
	public void attack(MonsterCard mCard, int dmg) {
		mCard.changeLifePoint(getAttackPoint());
		int atk = mCard.getAttackPoint();
		mCard.setAttackPoint(atk-1);
	}
	
	@Override
	public void firstRowAction(Player attacker, Player defender) {
		int atSize = attacker.getBoard().getBoardSize();
		int deSize = defender.getBoard().getBoardSize();
		
		ArrayList<Position> pos = getAttackableCard(atSize,deSize);
		
		if(!pos.isEmpty()) {
			for(Position p:pos) {
				attack(defender.getMonsterCard(p),getAttackPoint());
			}
		}
	}

}
