package card.monstercard;

import java.util.ArrayList;

import board.Position;
import card.base.Initialize;
import card.base.MonsterCard;
import player.Player;

public class FenrirM extends MonsterCard implements Initialize{

	public FenrirM() {
		super("Fenrir", "This is description.", 4, 1, 3, 4);
		setTurn(1);
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
	
	public void InitialAction(Player attacker, Player defender) {
		for(int i=0;i<attacker.getBoard().getBoardSize();i++) {
			attacker.getMonsterCard(new Position(i,0)).changeLifePoint(1);
			if(attacker.getMonsterCard(new Position(i,1))!=null) {
				attacker.getMonsterCard(new Position(i,1)).changeLifePoint(1);
			}
		}
		
		for(int i=0;i<defender.getBoard().getBoardSize();i++) {
			defender.getMonsterCard(new Position(i,0)).changeLifePoint(1);
			if(defender.getMonsterCard(new Position(i,1))!=null) {
				defender.getMonsterCard(new Position(i,1)).changeLifePoint(1);
			}
		}
		
		attacker.getBoard().updateBoard(attacker);
		defender.getBoard().updateBoard(defender);
	}

}
