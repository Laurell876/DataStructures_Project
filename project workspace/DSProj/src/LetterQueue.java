
public class LetterQueue {
	private LetterNode head;
	private int count = 0;
	private int limit = 100;
	
	public LetterQueue() {
		this.head = null;
		this.count=0;
		this.limit=100;
	}
	
	public LetterQueue(LetterNode head, int count, int limit) {
		super();
		this.head = head;
		this.count = count;
		this.limit = limit;
	}
	
	public LetterQueue(LetterQueue lq) {
		this.head = lq.getHead();
		this.count = lq.getCount();
		this.limit = lq.getLimit();
	}
	
	public LetterNode getHead() {
		return head;
	}
	public void setHead(LetterNode head) {
		this.head = head;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	public boolean isFull() {
		if(count>=limit) {
			return true;
		}
		return false;
	}
	
	public boolean isEmpty() {
		if(head == null) {
			return true;
		}
		return false;
	}
	
	public void insertAtBack(char c) {
		if(isFull()) {
			System.out.println("Queue is full");
			return;
		}
		else {
			if(isEmpty()) {
				LetterNode temp = new LetterNode();
				temp.setData(c);
				temp.setNext(null);
				head=temp;
			}
			else {
				count++;
				LetterNode temp2 = new LetterNode();
				temp2 = head;
				while(temp2.getNext()!=null) {
					temp2 = temp2.getNext();
				}
				LetterNode last = new LetterNode();
				last.setData(c);
				last.setNext(null);
				temp2.setNext(last);
			}
		}
	}
	
	public LetterNode deleteFromFront() {
		if(isEmpty()) {
			System.out.println("List is empty");
		}
		else {
			count--;
			LetterNode storage = head;
			head = head.getNext();
			return storage;
		}
		return null;
	}
	
	public LetterNode search(char c) {
		if(isEmpty()) {
			//System.out.println("Queue Empty"); commented out because it interferes with gameplay
		}
		else {
			LetterNode current = head;
			while(current!=null) {
				if(current.getData() == c) {
					return current;
				}
				current = current.getNext();
			}
			
			//System.out.println("Character not found");
		}
		return null;
	}
	
	//destroys all elements in the queue
	public void destroy() {
		
		while(!isEmpty()) deleteFromFront();
		
	}
	
	public void displayAll() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return;
		}
		else {
			LetterNode current = new LetterNode();
			current = head;
			while(current!=null) {
				
				//changed from .toString() to .getData()
				System.out.println(current.getData());
				current = current.getNext();
			}
		}
	}
	
	
}
