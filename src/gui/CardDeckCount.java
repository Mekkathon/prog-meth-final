package gui;

import application.Main;
import card.base.Card;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class CardDeckCount extends HBox{
	private Label countLabel;
	private int cardCount;
	private int maxCard;
	private ImageView plusle, minun;
	private CardSprite tieTo;
	public CardDeckCount(int cardCount, int maxCard, boolean isDeck, CardSprite currentCard) {
		this.setSpacing(3);
		this.setAlignment(Pos.CENTER);
		this.cardCount = cardCount;
		this.maxCard = maxCard;
		countLabel = new Label("" + cardCount);
		plusle = new ImageView(new Image("plusle.png"));
		minun = new ImageView(new Image("minun.png"));
		plusle.setFitHeight(10);
		plusle.setFitWidth(10);
		minun.setFitHeight(10);
		minun.setFitWidth(10);
		this.tieTo = currentCard;
		//
		this.setPrefHeight(10);
		if(isDeck) {
			plusle.setVisible(false);
			minun.setVisible(false);
		}
		this.getChildren().addAll(minun, countLabel, plusle);
	}
	public ImageView getPlusle() {
		return this.plusle;
	}
	
	public ImageView getMinun() { return this.minun;}
	public int getCardCount() { return this.cardCount;}
	public void setCardCount(int cardCount) {
		this.cardCount = cardCount;
		this.countLabel.setText(""+cardCount);
	}
	public int getMaxCard() {return this.maxCard;}
	public CardSprite getTieTo() {return this.tieTo;}
}
