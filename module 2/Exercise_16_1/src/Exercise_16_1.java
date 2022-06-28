import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.application.Application;
import javafx.scene.control.ToggleGroup;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Exercise_16_1 extends Application{
	public void start(Stage primaryStage){
		HBox hBox = new HBox();
		HBox hBox2 = new HBox();
		HBox hBox3 = new HBox();
		BorderPane pane = new BorderPane();
		Text text = new Text("Programming is fun");
		Scene scene = new Scene(pane, 500, 200);
		primaryStage.setTitle("Color Change");
		primaryStage.setScene(scene);
		primaryStage.show();
		Button btL = new Button("<-");
		Button btR = new Button("->");
		RadioButton rbRed = new RadioButton("Red ");
		RadioButton rbYellow = new RadioButton("Yellow ");
		RadioButton rbBlack = new RadioButton("Black ");
		RadioButton rbOrange = new RadioButton("Orange ");
		RadioButton rbGreen = new RadioButton("Green");
		ToggleGroup group = new ToggleGroup();
		rbRed.setToggleGroup(group);
		rbYellow.setToggleGroup(group);
		rbBlack.setToggleGroup(group);
		rbOrange.setToggleGroup(group);
		rbGreen.setToggleGroup(group);
		hBox.getChildren().addAll(btL, btR);
		pane.setBottom(hBox);
		hBox.setAlignment(Pos.BOTTOM_CENTER);
		hBox2.getChildren().addAll(rbRed, rbYellow, rbBlack, rbOrange, rbGreen);
		pane.setTop(hBox2);
		hBox2.setAlignment(Pos.TOP_CENTER);
		hBox3.getChildren().add(text);
		pane.setCenter(hBox3);
		hBox3.setAlignment(Pos.CENTER);
		rbRed.setOnAction(e -> {
			if (rbRed.isSelected()) {
				text.setFill(Color.RED);
			}
		});
		rbYellow.setOnAction(e -> {
			if (rbYellow.isSelected()) {
				text.setFill(Color.YELLOW);
			}
		});
		rbBlack.setOnAction(e -> {
			if (rbBlack.isSelected()) {
				text.setFill(Color.BLACK);
			}
		});
		rbOrange.setOnAction(e -> {
			if (rbOrange.isSelected()) {
				text.setFill(Color.ORANGE);
			}
		});
		rbGreen.setOnAction(e -> {
			if (rbGreen.isSelected()) {
				text.setFill(Color.GREEN);
			}
		});
		
		btL.setOnMouseClicked(e -> {
			text.setTranslateX(text.getTranslateX() - 10);
			if (text.getTranslateX() < -200) {
				System.out.println("Out of Bounds");
				text.setTranslateX(text.getTranslateX() + 10);
			}
		});
		btR.setOnMouseClicked(e -> {
			text.setTranslateX(text.getTranslateX() + 10);
			if (text.getTranslateX() > 200) {
				System.out.println("Out of Bounds");
				text.setTranslateX(text.getTranslateX() - 10);
			}
		});
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
