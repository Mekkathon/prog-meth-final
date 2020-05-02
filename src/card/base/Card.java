package card.base;

public class Card {
	protected String name;
	protected String description;
	protected int manaCost;
	protected int cardLimit;
	public Card(String name, String description, int manaCost, int cardLimit) {
		this.name = name;
		this.description = description;
		this.manaCost = manaCost;
		this.cardLimit = cardLimit;
	}

	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public int getManaCost() {
		return this.manaCost;
	}
	
	public int getCardLimit() {
		return this.cardLimit;
	}
	
	public void setManaCost(int manaCost) {
		this.manaCost = manaCost;
	}
	
	public void reduceManaCost(int value) {
		this.manaCost -= value;
		if(this.manaCost < 1) {
			this.manaCost = 1;
		}
	}
}
