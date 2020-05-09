package card.spellcard;

import board.Position;
import card.base.SpellCard;
import player.Player;

public class FirestormS extends SpellCard {

	public FirestormS() {
		super("Firestorm", "This is description.", 5, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void equip(Player attacker, Player defender) {
		for(int i=0;i<attacker.getBoard().getBoardSize();i++) {
			attacker.getMonsterCard(new Position(i,0)).changeLifePoint(2);
			if(attacker.getMonsterCard(new Position(i,1))!=null) {
				attacker.getMonsterCard(new Position(i,1)).changeLifePoint(2);
			}
		}
		
		for(int i=0;i<defender.getBoard().getBoardSize();i++) {
			defender.getMonsterCard(new Position(i,0)).changeLifePoint(2);
			if(defender.getMonsterCard(new Position(i,1))!=null) {
				defender.getMonsterCard(new Position(i,1)).changeLifePoint(2);
			}
		}
		
		attacker.getBoard().updateBoard(attacker);
		defender.getBoard().updateBoard(defender);

	}

}
