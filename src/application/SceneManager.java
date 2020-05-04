package application;


import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import player.Player;

public class SceneManager {
	public static Scene currentScene;
	private Scene[] scene = new Scene[3];
	public SceneManager() {
		buildScene0();
		buildScene1();
		buildScene2();
		currentScene = scene[0];
	}
	private void buildScene2() {
		// TODO Auto-generated method stub
	}
	private void buildScene1() {
		// TODO Auto-generated method stub
		HBox root = new HBox();
		VBox leftSide = new VBox();
		/////////////////////Big Card///////////////////
		ImageView bigCard = new ImageView();
		
		///////////////////////////////////////////////
		//--------------------------------------------//
		/////////////Description Label/////////////////
		Label description = new Label();
		
		//////////////////////////////////////////////
		leftSide.getChildren().addAll(bigCard, description);
		VBox.setMargin(bigCard, new Insets(5));
		VBox rightSide = new VBox();
		Button test = new Button();
		test.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				rightSide.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
			}
		});
		rightSide.getChildren().add(test);
		root.getChildren().addAll(leftSide, rightSide);
		scene[1] = new Scene(root);
	}
	
	//Scene 0 -> Start Game
	
	private void buildScene0() {
		VBox root = new VBox();
		root.setAlignment(Pos.CENTER);
		root.setPadding(new Insets(15));
		
		ImageView logo = new ImageView();
		logo.setFitHeight(300);
		logo.setFitWidth(400);
		HBox userName = new HBox();
		userName.setAlignment(Pos.CENTER);
		Label Name = new Label("Name: ");
		Name.setFont(new Font(20));
		TextField nameInput = new TextField();
		//nameInput.setPromptText("input name");
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
