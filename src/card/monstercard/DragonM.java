package card.monstercard;

import board.Position;
import card.base.MonsterCard;
import card.base.SecondRow;
import player.Player;

public class DragonM extends MonsterCard implements SecondRow{

	public DragonM() {
		super("Dragon","This is description.",7,1,3,2);
	}
	
	public void secondRowAction(Player attacker, Player defender) {
		firstRowAction(attacker,defender);
	}
	
	@Override
	public void action(Player attacker, Player defender) {
		int condition = 0;
		int opSize = defender.getBoard().getBoardSize();
		for(int i=0;i<attacker.getBoard().getBoardSize();i++) {
			if(attacker.getMonsterCard(new Position(i,0)) instanceof KnightM) {
				condition = 1;
				attacker.getBoard().removeCard(i,0);
				break;
			}
		}
		if(condition==1) {
			defender.changeLifePoint(getAttackPoint());
			for(int i=0;i<opSize;i++) {
				defender.getMonsterCard(new Position(i,0)).changeLifePoint(getAttackPoint());
				if(defender.getMonsterCard(new Position(i,1))!=null) {
					defender.getMonsterCard(new Position(i,1)).changeLifePoint(getAttackPoint());
				}
			}
		}
		else {
			super.action(attacker, defender);
		}
	}
	

}
