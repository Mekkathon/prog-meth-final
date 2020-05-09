package card.spellcard;

import java.util.Random;

import board.Position;
import card.base.MonsterCard;
import card.base.SpellCard;
import player.Player;

public class HeavenChangeS extends SpellCard {

	public HeavenChangeS() {
		super("Heaven Interchange", "This is description", 3, 1);
	}

	@Override
	public void equip(Player attacker, Player defender) {
		Random rand = new Random();
		int a = rand.nextInt(attacker.getBoard().getBoardSize());
		int b = rand.nextInt(attacker.getBoard().getBoardSize()-1);
		if(b>=a) b++;
		MonsterCard temp = attacker.getMonsterCard(new Position(a,0));
		MonsterCard temp2 = attacker.getMonsterCard(new Position(b,0));
		
		temp.setAttackPoint(temp.getAttackPoint()+1);
		temp.changeLifePoint(-1);
		temp2.setAttackPoint(temp2.getAttackPoint()+1);
		temp.changeLifePoint(-1);
		
		attacker.setMonsterCard(temp, new Position(b,0));
		attacker.setMonsterCard(temp2, new Position(a,0));
	}

}
