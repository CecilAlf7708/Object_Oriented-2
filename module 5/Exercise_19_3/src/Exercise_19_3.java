import java.util.ArrayList;

public class Exercise_19_3 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
	    list.add(14);
	    list.add(24);
	    list.add(14);
	    list.add(42);
	    list.add(25);
	    
	    ArrayList<Integer> newList = removeDuplicates(list);
	    
	    System.out.print(newList);
	    
	}
	
	public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list){
		boolean t = true;
		ArrayList<E> r = new ArrayList<E>();
		for(E e: list) {
			if(!r.contains(e)) {
				r.add(e);
			}
		}
		return r;
	}
}
