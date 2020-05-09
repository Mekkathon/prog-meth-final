package card.base;

import java.util.ArrayList;

import board.Position;
import card.monstercard.*;
import player.Player;

public class MonsterCard extends Card{
	protected int lifePoint, maxLifePoint, attackPoint, column, row, turn, poison;
	
	public MonsterCard(String name, String description, int manaCost, int cardLimit, int lifePoint, int attackPoint) {
		super(name,"Monster",description,manaCost,cardLimit);
		this.maxLifePoint = lifePoint;
		this.lifePoint = lifePoint;
		this.attackPoint = attackPoint;
		this.column = -1;
		this.row = -1;
		this.turn = -1;
		this.poison = 0;
	}
	
	public void changeLifePoint(int damage) {
		this.lifePoint -= damage;
		if(this.lifePoint < 0) this.lifePoint = 0;
		if(this.lifePoint > this.maxLifePoint) this.lifePoint = this.maxLifePoint;
	}
	
	public void action(Player attacker, Player defender) {
		if(this.turn==0) return;
		if(row==0) firstRowAction(attacker,defender);
		else if(this instanceof SecondRow) {
			SecondRow d = (SecondRow) this;
			d.secondRowAction(attacker,defender);
		}
	}
	
	public void firstRowAction(Player attacker, Player defender) {
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
	
	public void attack(MonsterCard mCard, int dmg) {
		mCard.changeLifePoint(dmg);
	}
	
	public ArrayList<Position> getAttackableCard(int at, int de) {
		ArrayList<Position> pos = new ArrayList<Position>();
		
		if(Math.abs(at-de)%2==0) {
			int deColumn = column+(de-at)/2;
			
			if(deColumn >= 0 && deColumn < de) pos.add(new Position(deColumn,0));
		}
		else {
			int deRightColumn = (2*column-(at-de)+1)/2;
			
			if(deRightColumn  >= 0 && deRightColumn  < de) pos.add(new Position(deRightColumn,0));
			if(deRightColumn-1>= 0 && deRightColumn-1< de) pos.add(new Position(deRightColumn-1,0));
		}
		
		return pos;
	}
	
	public MonsterCard clone() {
		MonsterCard temp = new MonsterCard("", "", 0, 0, 0, 0);
		
		if(this instanceof ArcherM) temp = new ArcherM();
		if(this instanceof CannonShooterM) temp = new CannonShooterM();
		if(this instanceof DarkMageM) temp = new DarkMageM();
		if(this instanceof DragonM) temp = new DragonM();
		if(this instanceof FairyM) temp = new FairyM();
		if(this instanceof FenrirM) temp = new FenrirM();
		if(this instanceof FireMageM) temp = new FireMageM();
		if(this instanceof GamblerM) temp = new GamblerM();
		if(this instanceof GolemM) temp = new GolemM();
		if(this instanceof KnightM) temp = new KnightM();
		if(this instanceof KrakenM) temp = new KrakenM();
		if(this instanceof MageM) temp = new MageM();
		if(this instanceof MinotaurM) temp = new MinotaurM();
		if(this instanceof OrcM) temp = new OrcM();
		if(this instanceof PheonixM) temp = new PheonixM();
		if(this instanceof PriestM) temp = new PriestM();
		if(this instanceof RoyalKnightM) temp = new RoyalKnightM();
		if(this instanceof UndeadM) temp = new UndeadM();
		
		return temp;
	}
	
	public void updateLifePoint() {
		if(poison!=0) {
			poison--;
			changeLifePoint(1);
		}
	}
	
	//getter-setter
	public void setPoison(int value) {
		poison=value;
	}
	public int getPoison() {
		return poison;
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
		if(attackPoint<1) attackPoint = 1;
		this.attackPoint = attackPoint;
	}
	public int getMaxLifePoint() {
		return maxLifePoint;
	}
	public void setMaxLifePoint(int maxLifePoint) {
		this.maxLifePoint = maxLifePoint;
	}
	public int getTurn() {
		return turn;
	}
	public void setTurn(int turn) {
		this.turn = turn;
	}
	
}
