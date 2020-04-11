
public class Player {
	int playerNo;
	String Name;
	float grandTotal = 0.0f;
	
	public Player() {
		this.playerNo = 0;
		this.Name = "";
		this.grandTotal = 0.0f;
	}
	
	public Player(int playerNo, String Name, float grandTotal) {
		this.playerNo = playerNo;
		this.Name = Name;
		this.grandTotal = grandTotal;
	}
	
	public Player(Player p) {
		this.playerNo = p.playerNo;
		this.Name = p.Name;
		this.grandTotal = p.grandTotal;
	}

	public int getPlayerNo() {
		return playerNo;
	}

	public void setPlayerNo(int playerNo) {
		this.playerNo = playerNo;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public float getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(float grandTotal) {
		this.grandTotal = grandTotal;
	}
	
	public void display() {
		System.out.println("Your number is: " +getPlayerNo());
		System.out.println("Your name is: " +getName());
		System.out.println("Your grand total is: " +getGrandTotal());
	}

}
