import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Exercise_15_Listeners extends Application{
	@Override
	public void start(Stage primaryStage) {
		double cX = 175, cY = 175;
		double r = 50;
		int t = 0;
		boolean up = false;
		Circle circle = new Circle(cX, cY, r);
		HBox hBox = new HBox();
		circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
		
		
		BorderPane pane = new BorderPane();
		Pane pane2 = new Pane();
		pane2.getChildren().add(circle);
		pane.setCenter(pane2);
		Scene scene = new Scene(pane, 350, 350);
		primaryStage.setTitle("Circle");
		primaryStage.setScene(scene);
		primaryStage.show();
		Button btUp = new Button("UP");
		Button btDown = new Button("DOWN"); 
		Button btLeft = new Button("LEFT"); 
		Button btRight = new Button("RIGHT");
		hBox.getChildren().addAll(btLeft,btUp,btDown,btRight);
		pane.setBottom(hBox);
		hBox.setAlignment(Pos.BOTTOM_CENTER);
		//
		//circle.getCenterY();
		//while(t < 1) {
			btUp.setOnMouseClicked(e -> {
				circle.setCenterY(circle.getCenterY() - 5);
				if(circle.getCenterY() < 50) {
					System.out.println("Out of bounds");
					circle.setCenterY(circle.getCenterY() + 5);
				}
			});
			btDown.setOnMouseClicked(e -> {
				circle.setCenterY(circle.getCenterY() + 5);
				if(circle.getCenterY() > 300) {
					System.out.println("Out of bounds");
					circle.setCenterY(circle.getCenterY() - 5);
				}
			});
			btLeft.setOnMouseClicked(e -> {
				circle.setCenterX(circle.getCenterX() - 5);
				if(circle.getCenterX() < 50) {
					System.out.println("Out of bounds");
					circle.setCenterX(circle.getCenterX() + 5);
				}
				
			});
			btRight.setOnMouseClicked(e -> {
				circle.setCenterX(circle.getCenterX() + 5);
				if(circle.getCenterX() > 300) {
					System.out.println("Out of bounds");
					circle.setCenterX(circle.getCenterX() - 5);
				}
		});
			
		//}
		System.out.println(circle.getCenterX());
		System.out.println(circle.getCenterY());
	}
	public static void main(String[] args) {
		  launch(args);
	  }
	
}
