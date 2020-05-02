package card.monstercard;

import card.base.MonsterCard;
import player.Player;

public class BloodLusterMonsterCard extends MonsterCard {

	public BloodLusterMonsterCard() {
		super("Blood Luster", "This is description.", 3, 2, 6, 1);
	}
	
	@Override
	public void action(Player attacker, Player defender) {
		int plSize = attacker.getBoard().getBoardSize();
		int opSize = defender.getBoard().getBoardSize();
		if(2*column+2+opSize < plSize || 2*(plSize-1-column)+2+opSize < plSize) {
			defender.changeLifePoint(opSize);
		}
		else if(Math.abs(plSize-opSize)%2==0) {
			int opColumn = column+(opSize-plSize)/2;
			if(defender.getMonsterCard(opColumn,0).getLifePoint()<=2) {
				defender.getMonsterCard(opColumn,0).setLifePoint(0);
			}else{
				defender.getMonsterCard(opColumn,0).changeLifePoint(attackPoint);
			}
		}
		else {
			int opRightColumn = (2*column-(plSize-opSize)+1)/2;
			if(opRightColumn<opSize) {
				if(defender.getMonsterCard(opRightColumn,0).getLifePoint()<=2) {
					defender.getMonsterCard(opRightColumn,0).setLifePoint(0);
				}else{
					defender.getMonsterCard(opRightColumn,0).changeLifePoint(attackPoint);
				}
			}
			if(opRightColumn>0) {
				if(defender.getMonsterCard(opRightColumn-1,0).getLifePoint()<=2) {
					defender.getMonsterCard(opRightColumn-1,0).setLifePoint(0);
				}else{
					defender.getMonsterCard(opRightColumn-1,0).changeLifePoint(attackPoint);
				}
			}
		}
	}

}
