
public class CardNode {
	private Card data;
	private CardNode next;
	
	public CardNode() {
		data = new Card();
		next = null;
	}
	
	public CardNode(Card data, CardNode next) {
		super();
		this.data = data;
		this.next = next;
	}
	
	public CardNode(CardNode cN) {
		data = cN.getData();
		next = cN.getNext();
	}
	
	public Card getData() {
		return data;
	}
	
	public void setData(Card data) {
		this.data = data;
	}
	
	public CardNode getNext() {
		return next;
	}
	
	public void setNext(CardNode next) {
		this.next = next;
	}
	

	
	
}
