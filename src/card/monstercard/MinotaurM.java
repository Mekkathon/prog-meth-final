package card.monstercard;

import card.base.MonsterCard;

public class MinotaurM extends MonsterCard {

	public MinotaurM() {
		super("Minotaur", "This is description.", 3, 2, 6, 1);
	}
	
	@Override
	public void attack(MonsterCard mCard, int dmg)  {
		if(mCard.getLifePoint()<=2) mCard.setLifePoint(0);
		else mCard.changeLifePoint(dmg);
	}
}
