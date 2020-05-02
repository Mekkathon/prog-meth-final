package board;

import card.base.*;

public class CardColumn {
	MonsterCard firstRowCard, secondRowCard;
	
	public CardColumn(MonsterCard card) {
		firstRowCard = card;
		secondRowCard = null;
		firstRowCard.setRow(0);
	}
	
	public MonsterCard getFirstRowCard() {
		return firstRowCard;
	}

	public void setFirstRowCard(MonsterCard firstRowCard) {
		this.firstRowCard = firstRowCard;
	}

	public MonsterCard getSecondRowCard() {
		return secondRowCard;
	}

	public void setSecondRowCard(MonsterCard secondRowCard) {
		this.secondRowCard = secondRowCard;
	}

	public void addSecondColumn(MonsterCard card) {
		secondRowCard = card;
		firstRowCard.setRow(1);
	}
	
	public void addColumn(int value) {
		int column = firstRowCard.getColumn();
		column += value;
		firstRowCard.setColumn(column);
		secondRowCard.setColumn(column);
	}
	
	public void swapRow() {
		MonsterCard temp = firstRowCard;
		firstRowCard = secondRowCard;
		secondRowCard = temp;
	}
	
}
