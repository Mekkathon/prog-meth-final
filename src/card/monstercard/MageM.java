package card.monstercard;

import java.util.ArrayList;

import board.Position;
import card.base.MonsterCard;
import card.base.SecondRow;
import player.Player;

public class MageM extends MonsterCard implements SecondRow{

	public MageM() {
		super("Mage","This is description.",4,2,3,2);
	}
	
	public void secondRowAction(Player attacker, Player defender) {
		firstRowAction(attacker,defender);
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
