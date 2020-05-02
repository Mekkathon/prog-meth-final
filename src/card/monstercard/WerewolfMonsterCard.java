package card.monstercard;

import card.base.MonsterCard;
import player.Player;

public class WerewolfMonsterCard extends MonsterCard {

	public WerewolfMonsterCard() {
		super("Werewolf", "This is description.", 4, 1, 3, 4);
		setTurn(1);
	}
	
	@Override
	public void firstRowAction(Player attacker, Player defender) {
		int plSize = attacker.getBoard().getBoardSize();
		int opSize = defender.getBoard().getBoardSize();
		if(2*column+2+opSize < plSize || 2*(plSize-1-column)+2+opSize < plSize) {
			//do nothing
		}
		else if(Math.abs(plSize-opSize)%2==0) {
			int opColumn = column+(opSize-plSize)/2;
			defender.getMonsterCard(opColumn,0).changeLifePoint(getAttackPoint());
		}
		else {
			int opRightColumn = (2*column-(plSize-opSize)+1)/2;
			if(opRightColumn<opSize) {
				defender.getMonsterCard(opRightColumn,0).changeLifePoint(getAttackPoint());
			}
			if(opRightColumn>0) {
				defender.getMonsterCard(opRightColumn-1,0).changeLifePoint(getAttackPoint());
			}
		}
	}

}
