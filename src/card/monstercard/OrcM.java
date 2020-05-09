package card.monstercard;

import java.util.ArrayList;

import board.Position;
import card.base.MonsterCard;

public class OrcM extends MonsterCard {

	public OrcM() {
		super("Orc","This is description.",7,1,6,4);
	}
	
	@Override
	public ArrayList<Position> getAttackableCard(int at, int de) {
		ArrayList<Position> pos = new ArrayList<Position>();
		
		if(Math.abs(at-de)%2==0) {
			int deColumn = column+(de-at)/2;
			
			if(deColumn >= 0 && deColumn < de) {
				pos.add(new Position(deColumn,0));
				pos.add(new Position(deColumn,1));
			}
		}
		else {
			int deRightColumn = (2*column-(at-de)+1)/2;
			
			if(deRightColumn  >= 0 && deRightColumn  < de) {
				pos.add(new Position(deRightColumn,0));
				pos.add(new Position(deRightColumn,1));
			}
			if(deRightColumn-1>= 0 && deRightColumn-1< de) {
				pos.add(new Position(deRightColumn-1,0));
				pos.add(new Position(deRightColumn-1,1));
			}
		}
		
		return pos;
	}

}
