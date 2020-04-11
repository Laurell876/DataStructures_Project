
public class Card {
	private CardType type = CardType.Money;
	private int value=0;
	
	public Card() {

		type = CardType.Money;
		value = 500;
	}
	
	//this constructor is to be used when creating lose a turn and bankruptcy cards
	public Card(CardType type) {
		this.type = type;
	}
	
	public Card(CardType type, int value) {
		super();
		this.type = type;
		this.value = value;
	}
	
	//this is to be used when creating a money card
	public Card(int value) {
		this.value = value;
	}
	
	public Card (Card c) {
		this.type = c.type;
		this.value = c.value;
	}
	
	public CardType getType() {
		return type;
	}
	public void setType(CardType type) {
		this.type = type;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Card [type=" + type + ", value=" + value + "]";
	}
	
	
	
	
}
