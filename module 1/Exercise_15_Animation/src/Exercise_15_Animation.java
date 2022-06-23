import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.animation.PathTransition;
import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Exercise_15_Animation extends Application{
	//getButton(): MouseButton = L/R clicks
	//Timeline.INDEFINTE = endless loop
	//PathTransition
	//FadeTransition
	
	
	public void start(Stage primaryStage) {
		Pane pane = new Pane();
		Rectangle rec = new Rectangle(25, 10, 60, 30);
		rec.setStroke(Color.BLACK);
		rec.setFill(Color.BLACK);
		Polygon poly = new Polygon();
		ObservableList<Double> list = poly.getPoints();
		poly.setStroke(Color.BLACK);
		poly.setFill(Color.WHITE);
		final double w = 200, h = 200;
		double centerX = w / 2, centerY = h / 2;
		double radius = Math.min(w, h) * 0.4;
		for (int i = 0; i < 5; i++) {
			list.add(centerX + radius * Math.cos(2 * i * Math.PI / 5)); 
			list.add(centerY - radius * Math.sin(2 * i * Math.PI / 5));
			 }
		pane.getChildren().add(poly);
		pane.getChildren().add(rec);
		//rec pathTransition
		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.millis(4000));
		pt.setPath(poly);
		pt.setNode(rec);
		pt.setOrientation(
		PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		pt.setCycleCount(Timeline.INDEFINITE);
		pt.setAutoReverse(true);
		FadeTransition ft = 
		new FadeTransition(Duration.millis(4000), rec);
		ft.setFromValue(1.0);
		ft.setToValue(0.1);
		ft.setCycleCount(Timeline.INDEFINITE);
		ft.setAutoReverse(true);
		ft.play(); // Start animation
		pt.play(); // Start animation 
		
		poly.setOnMousePressed(e -> pt.pause());
		poly.setOnMouseReleased(e -> pt.play());
		//poly.setOnMousePressed(e -> ft.pause());
		//poly.setOnMouseReleased(e -> ft.play());
		Scene scene = new Scene(pane, 250, 250);
		primaryStage.setTitle("Rec and Poly");
		primaryStage.setScene(scene); 
		primaryStage.show(); 
	}
	public static void main(String[] args) {
		launch(args);
	}
}
