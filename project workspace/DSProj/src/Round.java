
import java.util.Arrays;
import java.io.FileWriter;
import java.io.IOException;

public class Round {
	 //enum is a type not a datatype so it has to be declared like a class
	 private Category categoryType;
	 
	 //has to be declared outside of constructor
	 private float roundTotal = 0;
	 private String puzzle;
	 
	 
	 public Round() {
		 categoryType = Category.Person;
		 //roundtotal cannot be intialized in the constructor as it uses constant values
		 puzzle="Barack Obama";

		 
		 try {
			 FileWriter filewriter = new FileWriter("Round.txt", true); //true makes it continuously add to the file
			 filewriter.write(categoryType.toString() + " ");
			 filewriter.write(puzzle + "\n");
			 filewriter.close();
		 }
		 catch(IOException e) {
			 System.out.println("An error occurred");
			 e.printStackTrace();
		 }
	 }
	 
	 
	public Round(Category cT, float roundTotal, String puzzle) {

		this.categoryType = cT;
		this.roundTotal = roundTotal;
		this.puzzle = puzzle;
		
		 try {
			 FileWriter filewriter = new FileWriter("Round.txt", true); //true makes it continuously add to the file
			 filewriter.write(cT.toString() + " ");
			 filewriter.write(puzzle  + "\n");
			 filewriter.close();
		 }
		 catch(IOException e) {
			 System.out.println("An error occurred");
			 e.printStackTrace();
		 }
	}
	
	public Round(Round r) {
		categoryType = r.categoryType;
		roundTotal = r.roundTotal;
		puzzle = r.puzzle;
	}
	
	public Category getCategoryType() {
		return categoryType;
	}
	
	public void setCategoryType(Category categoryType) {
		this.categoryType = categoryType;
	}
	
	public float getRoundTotal() {
		return roundTotal;
	}
	
	public void setRoundTotal(float roundTotal) {
		this.roundTotal = roundTotal;
	}
	
	public String getPuzzle() {
		return puzzle;
	}
	
	public void setPuzzle(String puzzle) {
		this.puzzle = puzzle;
	}

	@Override
	public String toString() {
		return "Round [categoryType=" + categoryType + ", roundTotal=" + roundTotal + ", puzzle="
				+ puzzle + "]"; 
	}
	
	
	public void display() {
		System.out.println("Category Type: " + categoryType + ", Round Total" + roundTotal + ", Puzzle: " + puzzle);
	}


	public static void main(String[] args) {
		
	}
	
	 
	 
	
	
	 

	 
	 
}
