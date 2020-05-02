package card.base;

import player.Player;

public class MonsterCard extends Card{
	protected int lifePoint, maxLifePoint, attackPoint, column, row, turn;
	
	public MonsterCard(String name, String description, int manaCost, int cardLimit, int lifePoint, int attackPoint) {
		super(name,description,manaCost,cardLimit);
		this.maxLifePoint = lifePoint;
		this.lifePoint = lifePoint;
		this.attackPoint = attackPoint;
		this.column = -1;
		this.row = -1;
		this.turn = -1;
	}
	
	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getLifePoint() {
		return lifePoint;
	}

	public void setLifePoint(int lifePoint) {
		this.lifePoint = lifePoint;
	}

	public int getAttackPoint() {
		return attackPoint;
	}

	public void setAttackPoint(int attackPoint) {
		this.attackPoint = attackPoint;
	}
	
	public void changeLifePoint(int damage) {
		this.lifePoint -= damage;
		if(this.lifePoint < 0) {
			this.lifePoint = 0;
		}
		if(this.lifePoint > this.maxLifePoint) {
			this.lifePoint = this.maxLifePoint;
		}
	}
	
	public void action(Player attacker, Player defender) {
		int plSize = attacker.getBoard().getBoardSize();
		int opSize = defender.getBoard().getBoardSize();
		if(2*column+2+opSize < plSize || 2*(plSize-1-column)+2+opSize < plSize) {
			defender.changeLifePoint(opSize);
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
	
	public void secondRowAction(Player attacker, Player defender) {
		
	}
	
	public void deathTrigger(Player player) {
		
	}
	
	//public abstract void attack();
	
}