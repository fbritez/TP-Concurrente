package tpLista;

public class Main {

	
	public static void main(String[] args) {
		ConcurrentList cl = new ConcurrentList();
		int counter = 1000;
	
		while (counter >= 0){
			cl.add(counter);
			counter --;
		}
		
		cl.quickSort(10);
		
		cl.printMe();
	}

}
