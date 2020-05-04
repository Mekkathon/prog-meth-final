package application;

import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import player.Player;

public class Main extends Application{
	public static Stage stage;
	public static Player player;
	public static Player opponent;
	public static int calc(int a,int b,int c) {
		return a-(b-c)/2;
	}
	public static void main(String[] args) {
		new SceneManager();
		launch(args);
    }
	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		primaryStage.setScene(SceneManager.currentScene);
		primaryStage.setWidth(800);
		primaryStage.setHeight(600);
		primaryStage.setTitle("Isekai Chess!");
		primaryStage.getIcons().add(new Image("chess.png"));
		primaryStage.setResizable(false);
		primaryStage.show();
	}
}
