
public class WheelOfCards {
	private CardNode head = null;
	private CardNode tail = null;
	private int count=0;
	private int limit=25;
	
	
	
	public WheelOfCards() {
		head=null;
		tail=null;
		count=0;
		limit=25;
	}
	
	public WheelOfCards(CardNode head, CardNode tail, int count, int limit) {
		super();
		this.head = head;
		this.tail = tail;
		this.count = count;
		this.limit = limit;
	}
	public CardNode getHead() {
		return head;
	}
	public void setHead(CardNode head) {
		this.head = head;
	}
	public CardNode getTail() {
		return tail;
	}
	public void setTail(CardNode tail) {
		this.tail = tail;
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

	@Override
	public String toString() {
		return "WheelOfCards [head=" + head + ", tail=" + tail + ", count=" + count + ", limit=" + limit + "]";
	}
	
	public boolean isFull() {
		if(count>=limit) {
			System.out.println("List is full");
			return true;
		}
		return false;
	}
	
	public boolean isEmpty() {
		if(head==null) {
			return true;
		}
		return false;
	}
	
	
	   /* Function to insert element at the begining */
    public void insertAtFront(Card c)
    {
        CardNode temp = new CardNode();
        temp.setData(c);
        temp.setNext(head);
        if(isEmpty())
        {            
            head = temp;
            temp.setNext(head);
            tail = head;            
        }
        else
        {
        	temp.setNext(head);
        	head = temp; 
            tail.setNext(head);
                   
        }
        count=count+1;
    }
    /* Function to insert element at end */
    public void insertAtEnd(Card c)
    {
        CardNode temp = new CardNode();   
        temp.setData(c);
        temp.setNext(head);
        if(isEmpty())
        {            
            head = temp;
            temp.setNext(head);
            tail = head;            
        }
        else
        {
            tail.setNext(temp);
            tail = temp;            
        }
        count = count+1;
    }
    
    public CardNode search(Card c) {
    	if(isEmpty()) {
    		System.out.println("List is empty");
    		
    	}
    	else {
        	CardNode current = head;
        	while(current!=null) {
        		if(current.getData() == c) {
        			//System.out.println("Card found");
        			System.out.println(current.getData().toString());
        			return current;
        		}
        		current = current.getNext();
        	}
    	}
    	System.out.println("Card not found");
    	return null;
    	
    }
    
    public CardNode deleteFromFront() {
    	if(isEmpty()) {
    		System.out.println("List is empty");
    	}
    	else {
    		count = count -1;
    		//if head is the only node in the list
    		if(tail == head) {
    			CardNode storage = head;
    			head=null;
    			tail=null;
    			return storage;
    		}
    		else {
    			CardNode storage = head;
    			head = head.getNext();
    			return storage;
    		}
    	}
    	
    	return null;
    }
    
    public CardNode deleteFromBack() {
    	if(isEmpty()) {
    		System.out.println("List is empty");
    	}
    	else {
    		count = count -1;
    		//if head is the only node in the list
    		if(tail == head) {
    			CardNode storage = head;
    			head=null;
    			tail=null;
    			return storage;
    		}
    		else {
    			CardNode temp = head;
    			for(int i = 0;i<count;i++) {
    				temp = temp.getNext();
    			}
    			CardNode storage = temp.getNext();
    			tail=temp;
    			temp.setNext(null);
    			System.out.println("tail: "+tail.getData().toString());
    			return storage;
    		}
    	}
    	
    	return null;
    }
    
    public void display() {
    	if(isEmpty()) {
    		System.out.println("List is empty");
    		return;
    	}
    	else {
    		CardNode cN = head;
    		for (int i=0;i<count;i++) {
    			System.out.println(cN.getData().toString());
    			cN=cN.getNext();
    		}
    		//System.out.println(tail.getData().toString());
    	}
    }
    
    //this function takes in the current position then returns the position the wheel is at after being spun
    public int SpinWheel(int currentPosition)
    {
    	int newPosition=0;
    	int randomValue =(int) (Math.random() * ((100 - 50) + 1)) + 50;
    	//System.out.println("Random value added: "+ randomValue);
    	int addedValue = currentPosition + randomValue;
    	if(addedValue>25) {
    		 newPosition = addedValue % 25;
    	}
    	//System.out.println("New Postion: " + newPosition);
    	return newPosition;
    }
	
	
	
	
	
	
}
