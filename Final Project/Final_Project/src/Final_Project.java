import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.animation.*;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.*;
import javafx.collections.ObservableList;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.util.*;

public class Final_Project extends Application{
	@Override
	public void start(Stage primaryStage) {
		int r1 = 0;
		int r2 = 0;
		int r3 = 0;
		int r4 = 0;
		int r5 = 0;
		int r6 = 0;
		int enemies = 0;
		int score = 0;
		int lives = 2;
		boolean hit = false;
		Label points = new Label("Score: " + score);
		Label life = new Label("Lives: " + lives);
		 Polygon player = new Polygon();
			ObservableList<Double> listP = player.getPoints();
			player.setFill(Color.RED);
			player.setStroke(Color.BLACK);
			final double pW = 50, pH = 50;
			double centerpX = pW / 2, centerpY = pH / 2;
			double radiusP = Math.min(pW, pH) * 0.4;
			for (int i = 0; i < 3; i++) {
				listP.add(centerpX + radiusP * Math.cos(2 * i * Math.PI / 3)); 
				listP.add(centerpY - radiusP * Math.sin(2 * i * Math.PI / 3));
				 }
		player.setRotate(30);
		
		
		Pane pane = new Pane();
		pane.getChildren().addAll(points,life);
		points.setTranslateX(5);
		points.setTranslateY(-360);
		life.setTranslateX(250);
		life.setTranslateY(-360);
		pane.getChildren().add(player);
		player.setTranslateX(120);
		pane.setTranslateY(360);
		Line shot = new Line(player.getTranslateX() + 26,player.getTranslateY(),player.getTranslateX() + 26,player.getTranslateY() - 400);
		Rectangle lHB = new Rectangle(3,400);
		lHB.setX(shot.getEndX()- 2);
		lHB.setY(shot.getEndY());
		lHB.setFill(Color.RED);
		pane.getChildren().addAll(shot,lHB);
		shot.setStroke(Color.GREEN);
		player.setOnKeyPressed(e -> {
			switch (e.getCode()) {
			case LEFT: if(player.getTranslateX() > 0) {
				player.setTranslateX(player.getTranslateX() - 10); 
				shot.setStartX(player.getTranslateX() + 26);
				shot.setStartY(player.getTranslateY());
				shot.setEndX(player.getTranslateX() + 26);
				shot.setEndY(player.getTranslateY()- 400);;
				lHB.setX(shot.getEndX()- 2);
				lHB.setY(shot.getEndY());
				
				break;
			}
			else {
				break;
			}
			case RIGHT: if(player.getTranslateX() < 250) {
				player.setTranslateX(player.getTranslateX() + 10);
				shot.setStartX(player.getTranslateX() + 26);
				shot.setStartY(player.getTranslateY());
				shot.setEndX(player.getTranslateX() + 26);
				shot.setEndY(player.getTranslateY() - 400);;
				lHB.setX(shot.getEndX()- 2);
				lHB.setY(shot.getEndY());
				break;
			}
			else {
				break;
			}
			case SPACE: FadeTransition ft = new FadeTransition(Duration.millis(500),shot);
			//hit = true;
			shot.setStroke(Color.RED);
			ft.setFromValue(1.0);
			//hit = false;
			ft.setToValue(0.0);
			ft.setCycleCount(1);
			ft.setAutoReverse(false);
			ft.play();
			
			}
		});
		
		Circle enC = new Circle();
		Circle enC1 = circleGen(enC);
		Circle enC2 = circleGen(enC);
		Circle enC3 = circleGen(enC);
		Circle enC4 = circleGen(enC);
		Circle enC5 = circleGen(enC);
		Circle enC6 = circleGen(enC);
		Rectangle enR = new Rectangle();
		Rectangle enR1 = recGen(enR);
		Rectangle enR2 = recGen(enR);
		Rectangle enR3 = recGen(enR);
		Rectangle enR4 = recGen(enR);
		Rectangle enR5 = recGen(enR);
		Rectangle enR6 = recGen(enR);
		Polygon enP = new Polygon();
		Polygon enP1 = polyGen(enP);
		Polygon enP2 = polyGen(enP);
		Polygon enP3 = polyGen(enP);
		Polygon enP4 = polyGen(enP);
		Polygon enP5 = polyGen(enP);
		Polygon enP6 = polyGen(enP);
		Rectangle hB = new Rectangle();
		Rectangle hB1 = hitBox(hB);
		Rectangle hB2 = hitBox(hB);
		Rectangle hB3 = hitBox(hB);
		Rectangle hB4 = hitBox(hB);
		Rectangle hB5 = hitBox(hB);
		Rectangle hB6 = hitBox(hB);
		Rectangle[] hBoxs = new Rectangle[6];
		hBoxs[0] = hB1;
		hBoxs[1] = hB2;
		hBoxs[2] = hB3;
		hBoxs[3] = hB4;
		hBoxs[4] = hB5;
		hBoxs[5] = hB6;
		
		
		
		
		
		
		
		
		
		
		
		
		
			if(enemies == 0) {
			r1 = (int)(Math.random() * 3 + 1);
			if(r1 == 1) {
				pane.getChildren().addAll(enC1,hB1);
				enC1.setCenterX(150);
				enC1.setCenterY(-150);
				hB1.setY(-167);
				hB1.setX(133);
				enemies++;
			}
			else if(r1 == 2) {
				pane.getChildren().addAll(enR1,hB1);
				enR1.setY(-167);
				enR1.setX(133);
				hB1.setY(-167);
				hB1.setX(133);
				enemies++;
			}
			else if(r1 == 3) {
				pane.getChildren().addAll(enP1,hB1);
				enP1.setTranslateX(125);
				enP1.setTranslateY(-175);
				hB1.setY(-167);
				hB1.setX(133);
				enemies++;
			}
			//-------
			r2 = (int)(Math.random() * 3 + 1);
			if(r2 == 1) {
				pane.getChildren().addAll(enC2,hB2);
				hB1.setY(-275);
				hB1.setX(50);
				enC2.setCenterX(67);
				enC2.setCenterY(-257);
				enemies++;
			}
			else if(r2 == 2) {
				pane.getChildren().addAll(enR2,hB2);
				hB2.setY(-275);
				hB2.setX(50);
				enR2.setY(-275);
				enR2.setX(50);
				enemies++;
			}
			else if(r2 == 3) {
				pane.getChildren().addAll(enP2,hB2);
				hB2.setY(-275);
				hB2.setX(50);
				enP2.setTranslateX(43);
				enP2.setTranslateY(-283);
				enemies++;
			}
			//-------
			r3 = (int)(Math.random() * 3 + 1);
			if(r3 == 1) {
				pane.getChildren().addAll(enC3,hB3);
				hB3.setY(-275);
				hB3.setX(200);
				enC3.setCenterX(218);
				enC3.setCenterY(-257);
				enemies++;
			}
			else if(r3 == 2) {
				pane.getChildren().addAll(enR3,hB3);
				hB3.setY(-275);
				hB3.setX(200);
				enR3.setY(-275);
				enR3.setX(200);
				enemies++;
			}
			else if(r3 == 3) {
				pane.getChildren().addAll(enP3,hB3);
				hB3.setY(-275);
				hB3.setX(200);
				enP3.setTranslateX(192);
				enP3.setTranslateY(-283);
				enemies++;
			}
			//-------
			r4 = (int)(Math.random() * 3 + 1);
			if(r4 == 1) {
				pane.getChildren().addAll(enC4,hB4);
				hB4.setY(-340);
				hB4.setX(10);
				enC4.setCenterX(35);
				enC4.setCenterY(-321);
				enemies++;
			}
			else if(r4 == 2) {
				pane.getChildren().addAll(enR4,hB4);
				hB4.setY(-340);
				hB4.setX(18);
				enR4.setY(-340);
				enR4.setX(18);
				enemies++;
			}
			else if(r4 == 3) {
				pane.getChildren().addAll(enP4,hB4);
				hB4.setY(-340);
				hB4.setX(10);
				enP4.setTranslateX(10);
				enP4.setTranslateY(-345);
				enemies++;
			}
			//-------
			r5 = (int)(Math.random() * 3 + 1);
			if(r5 == 1) {
				pane.getChildren().addAll(enC5,hB5);
				hB5.setY(-340);
				hB5.setX(133);
				enC5.setCenterX(150);
				enC5.setCenterY(-321);
				enemies++;
			}
			else if(r5 == 2) {
				pane.getChildren().addAll(enR5,hB5);
				hB5.setY(-340);
				hB5.setX(133);
				enR5.setY(-340);
				enR5.setX(133);
				enemies++;
			}
			else if(r5 == 3) {
				pane.getChildren().addAll(enP5,hB5);
				hB5.setY(-340);
				hB5.setX(133);
				enP5.setTranslateX(125);
				enP5.setTranslateY(-345);
				enemies++;
			}
			//-------
			r6 = (int)(Math.random() * 3 + 1);
			if(r6 == 1) {
				pane.getChildren().addAll(enC6,hB6);
				hB6.setY(-340);
				hB6.setX(250);
				enC6.setCenterX(267);
				enC6.setCenterY(-321);
				enemies++;
			}
			else if(r6 == 2) {
				pane.getChildren().addAll(enR6,hB6);
				hB6.setY(-340);
				hB6.setX(250);
				enR6.setY(-340);
				enR6.setX(250);
				enemies++;
			}
			else if(r6 == 3) {
				pane.getChildren().addAll(enP6,hB6);
				hB6.setY(-340);
				hB6.setX(250);
				enP6.setTranslateX(240);
				enP6.setTranslateY(-345);
				enemies++;
			}
			}
		
		
		
		// Create a scene and place it in the stage
	    Scene scene = new Scene(pane, 300, 400);
	    primaryStage.setTitle("Final Project"); // Set the stage title
	    primaryStage.setScene(scene); // Place the scene in the stage
	    primaryStage.show(); // Display the stage
	    
	    player.requestFocus();
	}
	
	public static Circle circleGen(Circle c){
		
		
			c = new Circle();
			c.setRadius(20);
		c.setFill(Color.YELLOW);
		c.setStroke(Color.BLACK);
        return c;
        
	}
	
	public static Rectangle recGen(Rectangle rec) {
		 rec = new Rectangle();
		 rec.setHeight(35);
		 rec.setWidth(35);
			rec.setFill(Color.BLUE);
			rec.setStroke(Color.BLACK);
			return rec;
	}
	
	public static Polygon polyGen(Polygon poly) {
			poly = new Polygon();
		ObservableList<Double> list = poly.getPoints();
		poly.setFill(Color.GREEN);
		poly.setStroke(Color.BLACK);
		final double w = 50, h = 50;
		double centerX = w / 2, centerY = h / 2;
		double radius = Math.min(w, h) * 0.4;
		for (int i = 0; i < 6; i++) {
			list.add(centerX + radius * Math.cos(2 * i * Math.PI / 6)); 
			list.add(centerY - radius * Math.sin(2 * i * Math.PI / 6));
			 }
		return poly;
	}
	public static Rectangle hitBox(Rectangle hB) {
		hB = new Rectangle();
		 hB.setHeight(35);
		 hB.setWidth(35);
			hB.setFill(Color.BLACK);
			//hB.setOpacity(0);
			return hB;
	}
	public int checkCollision(Rectangle[] hBoxs ,Rectangle lHB, Line shot, int score) {
			int hits = 0;
			for (int i = 0;i <= 6;i++) {
			Object currentCheck = hBoxs[i];
			Node currentCheck1 = (Node) currentCheck;
			if(lHB.getBoundsInParent().intersects(currentCheck1.getBoundsInParent())) {
				FadeTransition ft = new FadeTransition();
				ft.setNode(currentCheck1);
				ft.setDuration(Duration.millis(500));
				ft.setFromValue(1.0);
				ft.setToValue(0.0);
				ft.play();
				hits++;
				System.out.print("hit ");
			} 
			}
			
			
			
			
			return score;
		}
	public static void main(String[] args) {
		launch(args);
	}
}
