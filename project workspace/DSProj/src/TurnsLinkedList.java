
public class TurnsLinkedList {
	
	
	private Node head;
	
	public TurnsLinkedList(){
		head = null;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public boolean isFull() {
		Node temp = new Node();
		if(temp == null) {
			return true;
		}else {
			temp = null;
			return false;
		}
	}
	
	
	public void InsertAtFront(Player d) {
		Node temp = new Node();
		if(temp != null) {
			temp.setData(d);
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
	
	public Player retrive(int playerNo) {
		Player tempPlayer = null;
		if(isEmpty()) {
			Node temp  = head;
			while(temp != null) {
				if(temp.getData().getPlayerNo() == playerNo) {
					System.out.println("Found");
					tempPlayer = new Player(temp.getData());
				}
				temp = temp.getNext();
			}
			
		}
		return tempPlayer;
	}
	
	public Player remove() {
		Player tempPlayer = null;
		if(isEmpty()) {
			tempPlayer = new Player(head.getData());
			Node temp = head;
			head = head.getNext();
		}
		return tempPlayer;
	}
	
	public void show() {
		if(isEmpty()) {
			Node temp = head;
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
			Node temp = head;
			Node prev = head;
			while(temp != null) {
				prev = temp;
				temp = temp.getNext();
			}
			head = null;
		}else {
			System.out.println("Nothing");
		}
	}

}

	
