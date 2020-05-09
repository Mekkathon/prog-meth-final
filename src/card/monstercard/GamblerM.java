package card.monstercard;

import card.base.MonsterCard;
import java.util.Random;

public class GamblerM extends MonsterCard {

	public GamblerM() {
		super("Gambler","This is description.",4,1,6,1);
	}
	
	@Override
	public int getAttackPoint() {
		Random rand = new Random();
		int n = rand.nextInt(6);
		if(n==5) n=6;
		if(n==4) n=2;
		if(n==3) n=1;
		return n;
	}

}
