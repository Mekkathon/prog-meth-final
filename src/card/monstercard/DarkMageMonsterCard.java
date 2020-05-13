package card.monstercard;

import card.base.MonsterCard;
import player.Player;

public class DarkMageMonsterCard extends MonsterCard {

	public DarkMageMonsterCard() {
		super("Dark Mage","This is description.",7,1,3,2);
	}
	
	@Override
	public void secondRowAction(Player attacker, Player defender) {
		firstRowAction(attacker,defender);
	}
	
	@Override
	public void firstRowAction(Player attacker, Player defender) {
		int condition = 0;
		int plSize = attacker.getBoard().getBoardSize();
		int opSize = defender.getBoard().getBoardSize();
		for(int i=0;i<attacker.getBoard().getBoardSize();i++) {
			if(attacker.getMonsterCard(i, 0) instanceof KnightMonsterCard) {
				condition = 1;
				attacker.getBoard().removeCard(i,0);
				break;
			}
		}
		if(condition==1) {
			defender.changeLifePoint(getAttackPoint());
			for(int i=0;i<opSize;i++) {
				defender.getMonsterCard(i,0).changeLifePoint(getAttackPoint());
				if(defender.getMonsterCard(i,1)!=null) {
					defender.getMonsterCard(i,1).changeLifePoint(getAttackPoint());
				}
			}
		}
		else {
			if(2*column+2+opSize < plSize || 2*(plSize-1-column)+2+opSize < plSize) {
				defender.changeLifePoint(getAttackPoint());
			}
			else if(Math.abs(plSize-opSize)%2==0) {
				int opColumn = column+(opSize-plSize)/2;
				defender.getMonsterCard(opColumn,0).changeLifePoint(getAttackPoint());
			}
			else {
				int opRightColumn = (2*column-(plSize-opSize)+1)/2;
				if(opRightColumn<opSize) defender.getMonsterCard(opRightColumn,0).changeLifePoint(getAttackPoint());
				if(opRightColumn>0) defender.getMonsterCard(opRightColumn-1,0).changeLifePoint(getAttackPoint());
			}
		}
	}

}
