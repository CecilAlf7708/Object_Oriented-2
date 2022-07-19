
public class Exercise_19_5 {
	  public static void main(String[] args) {
		    Integer[] numbers = {1, 2, 3};
		    System.out.println(max(numbers));
		    
		    String[] words = {"red", "green", "blue"};
		    System.out.println(max(words));
		    
		    Circle[] circles = {new Circle(3), new Circle(2.9), new Circle(5.9)};
		    System.out.println(max(circles));
	  }
		  
	  static class Circle implements Comparable<Circle> {
		    double radius;
		    
		    public Circle(double radius) {
		      this.radius = radius;
		    }
		    
		    @Override
		    public int compareTo(Circle c) {
		      if (radius < c.radius) 
		        return -1;
		      else if (radius == c.radius)
		        return 0;
		      else
		        return 1;
		    }
		    
		    @Override
		    public String toString() {
		      return "Circle radius: " + radius;
		    }
	  }
	  public static <E extends Comparable<E>> E max(E[] list) {
		  E currentMax = list[0];
		  int currentMaxIndex;
		  for(int x = 1;x < list.length;x++) {
			  if(currentMax.compareTo(list[x]) < 0) {
			  currentMax = list[x];
			  currentMaxIndex = x;
			  }
		  }
		  return currentMax;
	  }
}
