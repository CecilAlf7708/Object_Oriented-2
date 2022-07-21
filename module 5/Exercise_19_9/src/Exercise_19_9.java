import java.util.ArrayList;

public class Exercise_19_9 {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(14);
    list.add(24);
    list.add(4);
    list.add(42);
    list.add(5);
    Exercise_19_9.<Integer>sort(list);
    
    System.out.print(list);
  }
  public static <E extends Comparable<E>> void sort(ArrayList<E> list) { 
	  int p = 0;
	  E currentMin;
	  for(int y = 0;y < list.size() - 1;y++) {
		  currentMin = list.get(y);
		  p = y;
		  for(int x = y + 1;x < list.size();x++) {
			  if(currentMin.compareTo(list.get(x)) > 0) {
				  currentMin = list.get(x);
				  p = x;
			  }  
		  }
		  if(p != y) {
			  list.set(p,list.get(y));
			  list.set(y, currentMin);
		  }
		  
	  }
  }
}
