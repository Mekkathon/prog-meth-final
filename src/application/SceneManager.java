package application;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.function.Function;

import card.base.Card;
import card.monstercard.ArcherMonsterCard;
import card.monstercard.BeastTamerMonsterCard;
import card.monstercard.BloodLusterMonsterCard;
import card.monstercard.BomberMonsterCard;
import card.monstercard.DarkMageMonsterCard;
import card.monstercard.FireMageMonsterCard;
import card.monstercard.GamblerMonsterCard;
import card.monstercard.MageMonsterCard;
import card.monstercard.PriestMonsterCard;
import card.monstercard.QueenMonsterCard;
import card.monstercard.RoyalKnightMonsterCard;
import card.monstercard.RoyalPriestMonsterCard;
import card.monstercard.UndeadMonsterCard;
import card.monstercard.WerewolfMonsterCard;
import gui.CardDeckCount;
import gui.CardSprite;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import player.Player;

public class SceneManager {
	public static Scene currentScene;
	private Scene[] scene = new Scene[3];
	
	//Use in scene[1] (deck arrangement) 
	private Label description = new Label();
	private ArrayList<Card> newDeck = new ArrayList<Card>();
	ObservableList<CardSprite> monsterCard = FXCollections.observableArrayList();
	ObservableList<CardDeckCount> eachMonsterCardCount = FXCollections.observableArrayList();
	ObservableList<CardSprite> spellCard = FXCollections.observableArrayList();
	ObservableList<CardDeckCount> eachSpellCardCount = FXCollections.observableArrayList();
	FlowPane deckDraftList = new FlowPane();
	VBox leftSide = new VBox();
	private int totalCard = 0;
	public SceneManager() {
		buildScene0();
		buildScene1();
		buildScene2();
		currentScene = scene[0];
	}
	private void buildScene2() {
		// TODO Auto-generated method stub
	}
	
	private CardSprite bigCard = new CardSprite(null , 1);
	
	
	private void buildScene1() {
		// TODO Auto-generated method stub
		HBox root = new HBox();
		root.setAlignment(Pos.TOP_LEFT);
		leftSide.setPrefSize(250, 600);
		leftSide.setAlignment(Pos.TOP_CENTER);
		leftSide.setSpacing(15);
		leftSide.setPadding(new Insets(20, 20, 20, 20));
		//--------------------------------------------//
		
		/////////////Description Label/////////////////
		
		description.setPrefSize(200, 200);
		//////////////////////////////////////////////
		leftSide.getChildren().addAll(bigCard, description);
		leftSide.setBackground(new Background(new BackgroundFill(Color.SANDYBROWN, CornerRadii.EMPTY, Insets.EMPTY )));
		
		///Begin with Right side///
		//Monster//
		pushAllMonsterCard(monsterCard);
		GridPane monsterGrid = new GridPane();
		monsterGrid.setAlignment(Pos.CENTER);
		monsterGrid.setPadding(new Insets(5));
		int del = 0, ad = 0;
		for(int i = 0; i < monsterCard.size(); i++) {
			monsterGrid.add(monsterCard.get(i), i - del, 0 + ad);
			CardSprite currentCard;
			currentCard = monsterCard.get(i);
			monsterCard.get(i).addEventHandler(MouseEvent.MOUSE_MOVED, (MouseEvent e) ->{
				if(bigCard.getCard() == null || bigCard.getCard().getName() != currentCard.getCard().getName()) {
					bigCard = new CardSprite(currentCard.getCard(), 1);
					leftSide.getChildren().set(0, bigCard);
					description.setText(bigCard.getCard().getDescription());
				}
			});
			int cardLim = currentCard.getCard().getCardLimit();		
			CardDeckCount thisCard;
			thisCard = new CardDeckCount(0, cardLim, false, currentCard);
			eachMonsterCardCount.add(thisCard);
			thisCard.getPlusle().addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent arg0) 
				{
					plusMiHandler(thisCard, 1);
				}
			});	
			thisCard.getMinun().addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent arg0) {
					plusMiHandler(thisCard, -1);
						
				}

			});
			monsterGrid.add(thisCard, i - del, 1 + ad);
			if(i == 8) {del = 9;ad = 2;}
		}
		//End Monster Begin Spell//
		del = 0; ad = 0;
		GridPane spellGrid = new GridPane();
		spellGrid.setAlignment(Pos.TOP_LEFT);
		spellGrid.setPadding(new Insets(5));
		pushAllMagicCard(spellCard);
		deckDraftList.setPrefWidth(150);
		for(int i = 0; i < spellCard.size(); i++) {
			spellGrid.add(spellCard.get(i), 0, 0 );
			CardSprite currentCard;
			currentCard = spellCard.get(i);
			spellCard.get(i).addEventHandler(MouseEvent.MOUSE_MOVED, (MouseEvent e) ->{
				if(bigCard.getCard() == null || bigCard.getCard().getName() != currentCard.getCard().getName()) {
					bigCard = new CardSprite(currentCard.getCard(), 1);
					leftSide.getChildren().set(0, bigCard);
				}
			});
			
			int cardLim = currentCard.getCard().getCardLimit();
			CardDeckCount thisCard;
			thisCard = new CardDeckCount(0, cardLim, false, currentCard);
			eachSpellCardCount.add(thisCard);
			
			thisCard.getPlusle().addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent arg0) {
					plusMiHandler(thisCard, 1);	
				}
			});	
			thisCard.getMinun().addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent arg0) {
					plusMiHandler(thisCard, -1);	
				}
			});
			spellGrid.add(thisCard, i - del, 1 + ad);

			if(i == 8) {del = 8; ad = 2;}
		}
		VBox rightSide = new VBox();
		rightSide.setAlignment(Pos.TOP_RIGHT);
		rightSide.getChildren().addAll(monsterGrid, new Button(), spellGrid, deckDraftList);
		root.getChildren().addAll(leftSide, rightSide);
		scene[1] = new Scene(root);
	
	}
	private void plusMiHandler(CardDeckCount thisCard, int add) {
		// TODO Auto-generated method stub
		int cardCount = thisCard.getCardCount();
		cardCount += add;
		if(cardCount < 0 || cardCount > thisCard.getMaxCard()) return;
		thisCard.setCardCount(cardCount);
		CardSprite toDeck = new CardSprite(thisCard.getTieTo().getCard(), 0);
		toDeck.addEventHandler(MouseEvent.MOUSE_MOVED, arg1 ->{
			if(bigCard.getCard() == null || bigCard.getCard().getName() != toDeck.getCard().getName()) {
				bigCard = new CardSprite(toDeck.getCard(), 1);
				leftSide.getChildren().set(0, bigCard);
			}
		});
		boolean isInDeck = false;
		int toDel = -1;
		//System.out.println(deckDraftList.getChildren());
		for(int i  = 0 ; i < deckDraftList.getChildren().size(); i++) {			
			System.out.println(toDeck);
			VBox vbox = (VBox) deckDraftList.getChildren().get(i);
			CardSprite currentCard = (CardSprite) vbox.getChildren().get(0);
			CardDeckCount currentCount = (CardDeckCount) vbox.getChildren().get(1);
			if(currentCard.getCard().getName() == toDeck.getCard().getName()) {
				if(cardCount == 0) toDel = i;
				else {
					currentCount.setCardCount(cardCount);
				}
				isInDeck = true;
				break;
			}
		}				
		System.out.println(toDel);
		if(toDel != -1) {
			deckDraftList.getChildren().remove(toDel);
			return;
		}
		if(!isInDeck) {
			VBox vbox = new VBox();
			vbox.getChildren().addAll(toDeck, new CardDeckCount(cardCount, thisCard.getMaxCard(), true, toDeck));
			deckDraftList.getChildren().add(vbox);
		}

			
	}
	private void pushAllMagicCard(ObservableList<CardSprite> magicCard) {
		magicCard.add(new CardSprite(new ArcherMonsterCard(), 0 ));
		return;
	}
	private void pushAllMonsterCard(ObservableList<CardSprite> monsterCard) {
		monsterCard.add(new CardSprite(new ArcherMonsterCard(), 0));
		monsterCard.add(new CardSprite(new BeastTamerMonsterCard(), 0));
		monsterCard.add(new CardSprite(new BloodLusterMonsterCard(), 0));
		monsterCard.add(new CardSprite(new BomberMonsterCard(), 0));
		monsterCard.add(new CardSprite(new DarkMageMonsterCard(), 0));
		monsterCard.add(new CardSprite(new FireMageMonsterCard(), 0));
		monsterCard.add(new CardSprite(new GamblerMonsterCard(), 0));
		monsterCard.add(new CardSprite(new MageMonsterCard(), 0));
		monsterCard.add(new CardSprite(new PriestMonsterCard(), 0));
		monsterCard.add(new CardSprite(new QueenMonsterCard(), 0));
		monsterCard.add(new CardSprite(new RoyalKnightMonsterCard(), 0));
		monsterCard.add(new CardSprite(new RoyalPriestMonsterCard(), 0));
		monsterCard.add(new CardSprite(new UndeadMonsterCard(), 0));
		monsterCard.add(new CardSprite(new WerewolfMonsterCard(), 0));
		/*
		monsterCard.add(new CardSprite(new ArcherMonsterCard(), 0));
		monsterCard.add(new CardSprite(new ArcherMonsterCard(), 0));
		monsterCard.add(new CardSprite(new ArcherMonsterCard(), 0));*/
		
	}
	//Scene 0 -> Start Game
	
	private void buildScene0() {
		VBox root = new VBox();
		root.setAlignment(Pos.TOP_CENTER);
		root.setPadding(new Insets(15));
		ImageView logo = new ImageView();
		logo.setImage(new Image("logo.png"));
		logo.setFitHeight(300);
		logo.setFitWidth(400);
		HBox userName = new HBox();
		userName.setAlignment(Pos.CENTER);
		Label Name = new Label("Name: ");
		Name.setFont(new Font(20));
		TextField nameInput = new TextField();
		nameInput.setPromptText("input name");
		nameInput.setFocusTraversable(false);
		userName.getChildren().addAll(Name, nameInput);
		VBox.setMargin(userName, new Insets(15));
		Button newGame = new Button("New Game");
		newGame.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				//System.out.print("OK");
				Main.stage.setScene(scene[1]);
				Main.stage.show();
				String name = nameInput.getText();
				if(name == null) {
					name = "Anonymous";
				}
				Main.player = new Player(name, 0, 0, null);
			}
			
		});

		root.getChildren().addAll(logo, userName, newGame);
		scene[0] = new Scene(root);		
		
	}
	
}
