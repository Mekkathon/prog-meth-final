package card.monstercard;

import java.util.ArrayList;

import board.Position;
import card.base.MonsterCard;

public class CannonShooterM extends MonsterCard{
	public CannonShooterM() {
		super("Cannon Shooter","This is description.",3,2,6,1);
	}
	
	@Override
	public ArrayList<Position> getAttackableCard(int at, int de) {
		ArrayList<Position> pos = new ArrayList<Position>();
		
		if(Math.abs(at-de)%2==0) {
			int deColumn = column+(de-at)/2;
			
			if(deColumn  >= 0 && deColumn  < de) pos.add(new Position(deColumn,0));
			if(deColumn-1>= 0 && deColumn-1< de) pos.add(new Position(deColumn-1,0));
			if(deColumn+1>= 0 && deColumn+1< de) pos.add(new Position(deColumn+1,0));
		}
		else {
			int deRightColumn = (2*column-(at-de)+1)/2;
			
			if(deRightColumn  >=0 && deRightColumn  <de) pos.add(new Position(deRightColumn,0));
			if(deRightColumn-1>=0 && deRightColumn-1<de) pos.add(new Position(deRightColumn-1,0));
		}
		
		return pos;
	}
}
