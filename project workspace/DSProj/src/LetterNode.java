
public class LetterNode {
	private char data;
	private LetterNode next;
	
	
	public LetterNode() {

		this.data = 'a';
		this.next = null;
	}
	
	public LetterNode(char data, LetterNode next) {
		super();
		this.data = data;
		this.next = next;
	}
	
	public LetterNode(LetterNode lN) {
		this.data = lN.data;
		this.next = lN.next;
	}


	public char getData() {
		return data;
	}
	public void setData(char data) {
		this.data = data;
	}
	public LetterNode getNext() {
		return next;
	}
	public void setNext(LetterNode next) {
		this.next = next;
	}
	@Override
	public String toString() {
		return "LetterNode [data=" + data + ", next=" + next + "]";
	}
	
	
}
