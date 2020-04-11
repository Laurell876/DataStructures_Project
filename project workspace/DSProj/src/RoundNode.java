
public class RoundNode {

	Round data;
	RoundNode next;
	
	
	public RoundNode(){
		this.data = null;
		this.next = null;
	}
	
	public RoundNode(Round data, RoundNode next){
		this.data = data;
		this.next = next;
	}
	
	public RoundNode(RoundNode N){
		this.data = N.data;
		this.next = N.next;
	}

	public Round getData() {
		return data;
	}

	public void setData(Round data) {
		this.data = data;
	}

	public RoundNode getNext() {
		return next;
	}

	public void setNext(RoundNode next) {
		this.next = next;
	}
	
	public void display() {
		System.out.println("Player data is: " +getData());
		System.out.println("Your next node is: " +getNext());
	}
}
