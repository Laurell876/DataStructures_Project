
public class RoundLinkedList {
	
	
	private RoundNode head;

	
	public RoundLinkedList(){
		head = null;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public boolean isFull() {
		RoundNode temp = new RoundNode();
		if(temp == null) {
			return true;
		}else {
			temp = null;
			return false;
		}
	}
	
	
	public void InsertAtFront(Round r) {
		RoundNode temp = new RoundNode();
		if(temp != null) {
			temp.setData(r);
			temp.setNext(null);
			if(head == null) {
				head = temp;
			}
			else {
				temp.setNext(head);
				head = temp;
			}
		}
		else {
			System.out.println("Memory is full");
		}
	}
	
	public Round retrive(String p) {
		Round tempRound = null;
		if(isEmpty()) {
			RoundNode temp  = head;
			while(temp != null) {
				if(temp.getData().getPuzzle() == p) {
					System.out.println("Found");
					tempRound = new Round(temp.getData());
				}
				temp = temp.getNext();
			}
			
		}
		return tempRound;
	}
	
	public Round remove() {
		Round tempRound = null;
		if(isEmpty()) {
			tempRound = new Round(head.getData());
			RoundNode temp = head;
			head = head.getNext();
		}
		return tempRound;
	}
	
	public void show() {
		if(isEmpty()) {
			RoundNode temp = head;
			while(temp != null) {
				temp.display();
				temp = temp.getNext();
			}
			}else {
				System.out.println("Empty");
			}
		}
	
	public void destroy() {
		if(isEmpty()) {
			RoundNode temp = head;
			RoundNode prev = head;
			while(temp != null) {
				prev = temp;
				temp = temp.getNext();
			}
			head = null;
		}else {
			System.out.println("Nothing");
		}
	}

	public RoundNode getHead() {
		return head;
	}

	public void setHead(RoundNode head) {
		this.head = head;
	}
	
	
	

}

	
