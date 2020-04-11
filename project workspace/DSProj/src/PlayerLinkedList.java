
public class PlayerLinkedList {
	
	private Node head;
	private Node tail;
	
	public PlayerLinkedList(){
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
	
	 public void add(Player data){  
	        //Create new node  
	        Node tempPlayer = new Node(data, null);  
	        //Checks if the list is empty.  
	        if(head == null) {  
	             //If list is empty, both head and tail would point to new node.  
	            head = tempPlayer;  
	            tail = tempPlayer;  
	            tempPlayer.next = head;  
	        }  
	        else {  
	            //tail will point to new node.  
	            tail.next = tempPlayer;  
	            //New node will become new tail.  
	            tail = tempPlayer;  
	            //Since, it is circular linked list tail will point to head.  
	            tail.next = head;  
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

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public Node getTail() {
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}
	
	

}
