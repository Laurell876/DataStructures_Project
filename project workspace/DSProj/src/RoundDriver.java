
public class RoundDriver {
	public static void main(String[] args) {
		
		//default constructor test
		Round test = new Round();
		test.display();
		
		
		//primary constructor test
		Category cat = Category.Thing;
		float rT = 10;
		Round primaryTest = new Round(cat, rT, "Donald Trump");
		primaryTest.display();
	}
}
