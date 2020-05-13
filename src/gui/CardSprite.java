package gui;


import card.base.Card;
import card.base.MonsterCard;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

public class CardSprite extends Pane{
	private Card card;
	private Label atkLabel;
	private Label hpLabel;
	public CardSprite(Card card, int type) {
		this.card = card;
		if(card == null) {
			this.resize(200, 300);
			return;
		}
		ImageView cardImage;
		try {
			cardImage = new ImageView(new Image(card.getName() + ".jpg"));
		}
		catch(IllegalArgumentException e){
			System.out.println("at " + this.card.getName());
			cardImage = new ImageView(new Image("fail.png"));
		}
		cardImage.setFitHeight(type == 0? 90: 300);
		cardImage.setFitWidth(type == 0? 60 :200);
		this.getChildren().add(cardImage);
		if(card.getCardType() == "Monster") {
			int atk = ((MonsterCard)card).getAttackPoint();
			int hp  = ((MonsterCard)card).getLifePoint();
			String atk_str = "" + atk;
			String hp_str = "" + hp;
			atkLabel = new Label(atk_str);
			hpLabel = new Label(hp_str);
			atkLabel.setFont(new Font(type == 0 ? 12 : 24));
			hpLabel.setFont(new Font(type == 0 ? 12 : 24));
			atkLabel.relocate(0, 0);
			hpLabel.relocate(0, 0);
			this.getChildren().addAll(atkLabel, hpLabel);
		}
		
	}
	public void updateLabel() {
		if(card.getCardType() == "Monster") {
			int atk = ((MonsterCard)card).getAttackPoint();
			int hp = ((MonsterCard)card).getLifePoint();
			atkLabel.setText("" + atk);
			hpLabel.setText("" + hp);
		}
		return;
	}
	public Card getCard() {
		return this.card;
	}
	

}
