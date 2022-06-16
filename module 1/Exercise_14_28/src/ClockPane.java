     import java.util.Calendar;
    import java.util.GregorianCalendar;
    import javafx.scene.layout.Pane;
    import javafx.scene.paint.Color;
    import javafx.scene.shape.Circle;
    import javafx.scene.shape.Line;
    import javafx.scene.text.Text;
    
    public class ClockPane extends Pane {
     private int hour; 
     private int minute;
     private int second;
     boolean hVisible = true;
     boolean mVisible = true;
     boolean sVisible = false;
   
     // Clock pane's width and height
     private double w = 250, h = 250;
     
     /** Construct a default clock with the current time*/
     public ClockPane() {
       setCurrentTime();
     }
   
     /** Construct a clock with specified hour, minute, and second */
     public ClockPane(int hour, int minute, int second) {
       this.hour = hour;
        this.minute = minute;
       this.second = second;
       paintClock();
     }
   
     /** Return hour */
     public int getHour() {
       return hour;
     }
   
     /** Set a new hour */
     public void setHour(int hour) {
       this.hour = hour;
       paintClock();
     }
   
     /** Return minute */
     public int getMinute() {
       return minute;
     }
   
     /** Set a new minute */
     public void setMinute(int minute) {
       this.minute = minute;
       paintClock();
     }
 
     /** Return second */
     public int getSecond() {
       return second;
     }
   
     /** Set a new second */
     public void setSecond(int second) {
       this.second = second;
       paintClock();
    }
   
     /** Return clock pane's width */ 
     public double getW() {
       return w;
     }
     
     /** Set clock pane's width */ 
     public void setW(double w) {
       this.w = w;
       paintClock();
    }
     
     /** Return clock pane's height */ 
     public double getH() {
      return h;
     }
     
   /** Set clock pane's height */ 
     public void setH(double h) {
       this.h = h;
       paintClock();
     }
      
      public boolean isHVisible() {
              return hVisible;
            }
      public void setHVisible(Boolean hVisible){
        this.hVisible = hVisible;
      }
            
      public boolean isMVisible() {
              return mVisible;
            }
      public void setMVisible(Boolean mVisible){
        this.mVisible = mVisible;
      }
      
      public boolean isSVisible() {
              return sVisible;
            }
      public void setSVisible(Boolean sVisible){
        this.sVisible = sVisible;
      }
     
     /* Set the current time for the clock */
    public void setCurrentTime() {
       // Construct a calendar for the current date and time
    Calendar calendar = new GregorianCalendar();
   
       // Set current hour, minute and second
       this.hour = (int)(Math.random() * 12);
       this.minute = (int)(Math.random() * 31);
       this.second = calendar.get(Calendar.SECOND);
       
       paintClock(); // Repaint the clock
     }
     
    /** Paint the clock */
      protected void paintClock() {
            // Initialize clock parameters
        
            double clockRadius = Math.min(w, h) * 0.8 * 0.5;
            double centerX = w / 2;
            double centerY = h / 2;
        
            // Draw circle
            Circle circle = new Circle(centerX, centerY, clockRadius);
            circle.setFill(Color.WHITE);
            circle.setStroke(Color.BLACK);
            Text t1 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
            Text t2 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
            Text t3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
            Text t4 = new Text(centerX - 3, centerY + clockRadius - 3, "6");
        
            // Draw second hand
            //if (sVisible == true){
            double sLength = clockRadius * 0.8;
            double secondX = centerX + sLength * 
              Math.sin(second * (2 * Math.PI / 60));
            double secondY = centerY - sLength * 
              Math.cos(second * (2 * Math.PI / 60));
            Line sLine = new Line(centerX, centerY, secondX, secondY); 
            sLine.setStroke(Color.RED);
            //}
            // Draw minute hand
          //if (mVisible == true) {
            double mLength = clockRadius * 0.65;
            double xMinute = centerX + mLength * 
              Math.sin(minute * (2 * Math.PI / 60));
            double minuteY = centerY - mLength * 
              Math.cos(minute * (2 * Math.PI / 60));
            Line mLine = new Line(centerX, centerY, xMinute, minuteY); 
            mLine.setStroke(Color.BLUE);
          //}
            // Draw hour hand
          // if (hVisible == true) {
            double hLength = clockRadius * 0.5;
            double hourX = centerX + hLength * 
              Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
            double hourY = centerY - hLength *
              Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
            Line hLine = new Line(centerX, centerY, hourX, hourY); 
            hLine.setStroke(Color.GREEN);
          // }
        
            getChildren().clear();  
            getChildren().addAll(circle, t1, t2, t3, t4);
            if(isHVisible()) {
            getChildren().add(hLine);
            }
            if(isMVisible()) {
              getChildren().add(mLine);
            }
            if(isSVisible()) {
              getChildren().add(sLine);
            }
          }
        }