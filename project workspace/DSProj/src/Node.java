
public class Node {

	Player data;
	Node next;
	
	
	public Node(){
		this.data = null;
		this.next = null;
	}
	
	public Node(Player data, Node next){
		this.data = data;
		this.next = next;
	}
	
	public Node(Node N){
		this.data = N.data;
		this.next = N.next;
	}

	public Player getData() {
		return data;
	}

	public void setData(Player data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	public void display() {
		System.out.println("Player data is: " +getData());
		System.out.println("Your next node is: " +getNext());
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}
	
}
