import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.animation.KeyFrame;
import javafx.scene.control.Label;
import javafx.scene.text.FontPosture;
import javafx.scene.text.*;
import javafx.scene.control.TextField; 
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.animation.Timeline;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Exercise_16_21 extends Application{
		BorderPane pane = new BorderPane();
		HBox hBox = new HBox();
		Text text = new Text("");
		String s = "";
		int t = 0;
		int c = 0;
		boolean d = true;
		boolean n = false;
		TextField tf = new TextField();
		Media media = new Media("https://liveexample.pearsoncmg.com/common/audio/anthem/anthem0.mp3");
		MediaPlayer mediaPlayer = new MediaPlayer(media);
	public void start(Stage primaryStage) {
		EventHandler<ActionEvent> eventHandler = e ->{
			   if(t > 0) {
				t = t - 1;
				s = t + "";
				tf.setText(t + "");
				text.setText(s);
				text.setFont(Font.font("Times New Roman", 50));
				text.setTranslateX(70);
				text.setTranslateY(- 30);
			   }
			   else {
				   mediaPlayer.play();
			   }
		};
		tf.setAlignment(Pos.BOTTOM_RIGHT);
	    pane.setTop(tf);
	    tf.setOnKeyPressed(e -> {
	    	if (e.getCode() == KeyCode.ENTER) {
	    		if(!tf.getText().matches("[\\d]{0,}")) {
	    			tf.setText("Numbers only!");
	    		}else {
		    		
	    			System.out.println("K");
		    		tf.setEditable(false);
		    		int timer = Integer.parseInt(tf.getText());
		    		t = timer;
		    		
		    		Timeline time = new Timeline(	
		    		new KeyFrame(Duration.seconds(1), eventHandler));
		    		time.setCycleCount(Timeline.INDEFINITE); 
		    		time.play(); // Start animation
		    		
		    		
		    		
		    		}
	    	}
	    }
	    );
		hBox.getChildren().add(text);
		//pane.setAlignment(hBox,Pos.BOTTOM_CENTER);
		
		pane.setBottom(hBox);
		
		
		Scene scene = new Scene(pane, 170, 120);
		primaryStage.setTitle("Timer");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
