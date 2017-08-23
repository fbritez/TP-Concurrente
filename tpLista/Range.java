package tpLista;

public class Range {
	
	int initRange;
	int endRange;

	public Range(int i, int e) {
		this.initRange = i;
		this.endRange = e;
	}

	public boolean isInvalid() {
		return (this.initRange < 0 || this.endRange < 0 || this.endRange <= this.initRange) ;
	}

	public boolean isEmpty() {
		return (this.initRange > this.endRange );
	}

	public int size() {
		return (this.endRange - this.initRange);
	}
	
	public int start(){
		return this.initRange;
	}
	
	public int end(){
		return this.endRange;
	}

	public boolean notIsEmpty() {
		return (!this.isEmpty());
	}

	public String print() {
		return ("("+initRange+ "," + endRange + ")");
	}

}
