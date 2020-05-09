package card.spellcard;

import java.util.Random;

import board.Position;
import card.base.MonsterCard;
import card.base.SpellCard;
import card.monstercard.KnightM;
import player.Player;

public class DemoteS extends SpellCard {

	public DemoteS() {
		super("Demote", "This is description.", 3, 1);
	}

	@Override
	public void equip(Player attacker, Player defender) {
		Random rand = new Random();
		int a = rand.nextInt(defender.getBoard().getBoardSize());
		MonsterCard temp = new KnightM();
		temp.setColumn(a);
		temp.setRow(0);
		temp.setTurn(1);
		defender.setMonsterCard(temp, new Position(a,0));
	}

}
