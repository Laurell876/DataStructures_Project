import java.util.Scanner;

public class Driver {
	public static Card[] cards = {
			new Card(CardType.Bankruptcy),
			new Card(2500),
			new Card(CardType.LoseATurn),
			new Card(600),
			new Card(700),
			new Card(600),
			new Card(650),
			new Card(500),
			new Card(700),
			new Card(CardType.Bankruptcy),
			new Card(600),
			new Card(650),
			new Card(500),
			new Card(600),
			new Card(CardType.Bankruptcy),
			new Card(650),
			new Card(850), //freeplay
			new Card(700),
			new Card(CardType.LoseATurn),
			new Card(800),
			new Card(500),
			new Card(650),
			new Card(500),
			new Card(900),
	};
	public static PlayerLinkedList PlayerList;
	public static Scanner in;
	public static WheelOfCards cardWheel;
	public static RoundLinkedList roundList;
	public static LetterQueue letters;
	public static Player currentPlayer;
	public static Round currentRound;
	public static Card cardOnWheel = new Card();
	public static String puzzleProgress;
	public static String currentPuzzle;
	//public static LetterQueue letterueue = new LetterQueue();
	public static boolean bankrupt;
	public static boolean loseTurn;
	public static boolean puzzleCompleted;
	
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		PlayerList = new PlayerLinkedList();
		addPlayers();
		
		cardWheel = new WheelOfCards();
		addCards();
		
		roundList = new RoundLinkedList();
		addRounds();
		
		letters = new LetterQueue();
		
		start();
		
		System.out.println("\t\tGame Over");
	}
	
	
	public static void start() {
		boolean incorrectguess = false;
		currentRound = roundList.getHead().getData();
		
		int wheelPosition = 0;
		
		
		System.out.println("\n\t\tGameplay Started");
		for(int i=0;i<3;i++) { //loop for rounds
			//currentPlayer = PlayerList.getHead().getData();
			 letters.destroy();
			
			puzzleCompleted = false;
			currentPuzzle = currentRound.getPuzzle();
			puzzleProgress = ""; //resets puzzle progress for each round;
			generateDashes();
			
			
			for (int j = 0; j<3 ; j++) { //loop for each player in each round
				changePlayer(j);
				bankrupt = false;
				loseTurn = false;

				if(puzzleCompleted == false) {
					System.out.println("Round: " + (i+1));
					System.out.println("Category: " + currentRound.getCategoryType());
					System.out.println("Player Number: " + currentPlayer.getPlayerNo() + " Player Name: " + currentPlayer.getName());		
					int spin = 1;
					while(spin==1) {
						incorrectguess =false;
						wheelPosition = SpinWheel(wheelPosition);
						
						if(bankrupt==true || loseTurn == true) {
							System.out.println("You have lost your turn");
							incorrectguess = true;
							spin = 4;
							//break;
						} else {
							System.out.println("Puzzle: "+ puzzleProgress);
							
							System.out.println("Please guess a letter");
							String guess = in.next();
							boolean letterGuessed = guessLetter(guess,false);

							//this goes to the next round if the player guessed all the letters
							if(!puzzleProgress.contains("_")) {
								System.out.println("Puzzle completed");
								currentRound.setRoundTotal(currentRound.getRoundTotal() + currentPlayer.getGrandTotal());
								System.out.println("Round total: " + currentRound.getRoundTotal());
								puzzleCompleted= true;
								//break;
								//continue;
								spin = 4;
							} else {
								if(letterGuessed) {
									currentPlayer.setGrandTotal(currentPlayer.getGrandTotal() + cardOnWheel.getValue());
									System.out.println("\nPlease Choose an Option: \n1. Spin Again \n2. Buy a Vowel \n3. Solve Puzzle");
									spin = in.nextInt();
								}
								else {
									puzzleCompleted= false;
									System.out.println("You have not solved the puzzle");
									currentPlayer.setGrandTotal(0);
									System.out.println("New total: " + currentPlayer.getGrandTotal());
									//break;
									spin = 4;
									incorrectguess = true;
								}
							}
							
							
						}
						
						
					}
					if(incorrectguess) {
						continue;
					}
					
					if(spin == 2) {
						System.out.println("buy vowel");	
						buyVowel();
						
						//this resets the player total if he didnt solve the puzzle
						if(puzzleProgress.contains("_")) {
							puzzleCompleted= false;
							System.out.println("You have not solved the puzzle");
							currentPlayer.setGrandTotal(0);
							System.out.println("New total: " + currentPlayer.getGrandTotal());
						}
						else {
							currentRound.setRoundTotal(currentRound.getRoundTotal() + currentPlayer.getGrandTotal());
							System.out.println("Round total: " + currentRound.getRoundTotal());

						}
						
					}
					else if (spin == 3) {
						System.out.println("Solve puzzle");
						puzzleCompleted = solvePuzzle();
						if(puzzleCompleted) {
							currentRound.setRoundTotal(currentRound.getRoundTotal() + currentPlayer.getGrandTotal());
							System.out.println("Round total: " + currentRound.getRoundTotal());
							break;
						} else {
							System.out.println("You have not solved the puzzle");
							currentPlayer.setGrandTotal(0);
							System.out.println("New total: " + currentPlayer.getGrandTotal());
						}
					}
					
					changePlayer(j+1);
					System.out.println("\n");
				}

				
			}
			changeRound(i+1);
		}
	}
	
	public static boolean solvePuzzle() {
		
		System.out.println("Please guess the puzzle: ");
		String puzzleGuess = in.next();
		
		if(puzzleGuess.equals(currentPuzzle)) {
			currentPlayer.setGrandTotal(currentPlayer.getGrandTotal() - cardOnWheel.getValue());
			System.out.println("Correct!!\n");
			System.out.println("Player total: " + currentPlayer.getGrandTotal());
			return true;
		}
		else {
			System.out.println("Incorrect!");
		}


		return false;
	}
	
	public static void buyVowel() {
		if(currentPlayer.getGrandTotal() >= 200) { //each vowel costs 200 to buy
			if(currentPuzzle.contains("a") || currentPuzzle.contains("e") || currentPuzzle.contains("i") || currentPuzzle.contains("o") || currentPuzzle.contains("u") ) {
				System.out.println("Please enter a vowel: ");
				String vowelBought = in.next();
				guessLetter(vowelBought, true);
				System.out.println("Progress: "+puzzleProgress);
				System.out.println("Player total: " + currentPlayer.getGrandTotal());
			}
			else {
				System.out.println("This puzzle has no vowels");
			}
		}
		else {
			System.out.println("You do not have enough money to buy a vowel");
		}
	}
	
	
	public static boolean guessLetter(String guess, boolean vowelPurchase) {
		if(letters.search(guess.toCharArray()[0]) == null) {
			if (currentPuzzle.contains(guess)) {
				System.out.println("Correct!");
				letters.insertAtBack(guess.toCharArray()[0]);
				revealLetters(guess.toCharArray()[0], vowelPurchase);
				return true;
			}
			else {
				System.out.println("Incorrect!");
			}
		}
		else {
			System.out.println("This letter has already been guessed");
		}
		
		return false;
	}
	

	public static void revealLetters(char guess, boolean vowelPurchase) {
		char[] newProgress;
		int letterOccurrence = 0;
		
		for(int y = 0; y<currentPuzzle.length();y++) {
			if(currentPuzzle.toCharArray()[y]==guess) {
				letterOccurrence = letterOccurrence + 1;
				if(vowelPurchase==false) {
					addMoney(letterOccurrence);
				}
				newProgress = puzzleProgress.toCharArray();
				newProgress[y]=guess;
				puzzleProgress = String.valueOf(newProgress);
				//System.out.println("Puzzle Progress: " + puzzleProgress);
			}
		}
		if(vowelPurchase == true) {
			currentPlayer.setGrandTotal(currentPlayer.getGrandTotal() - (letterOccurrence*200));
		}
	}
	
	public static void addMoney(int occurrences) {
		currentPlayer.setGrandTotal(currentPlayer.getGrandTotal() + (occurrences * cardOnWheel.getValue()));
		System.out.println("Player total: " + currentPlayer.getGrandTotal());
	}
	
	
	public static void generateDashes() {
		for(int i=0;i<currentPuzzle.length();i++) {
			puzzleProgress = puzzleProgress + "_";
		}
	}
	
	public static int SpinWheel(int startingPosition) {
		
		//gets the position the wheel should move to
    	int cardPosition =  cardWheel.SpinWheel(startingPosition);
    	
    	Card cardAtPosition = null;
    	
    	//gets the card at that position
    	if(cardPosition!=0) {
    		cardAtPosition = cards[cardPosition-1];
    	}
    	else {
    		cardAtPosition = cards[cardPosition];
    	}
    	
    	
    	//gets card on wheel selected
    	cardOnWheel = cardWheel.search(cardAtPosition).getData();
    	if(cardOnWheel.getType() == CardType.Bankruptcy) {
    		currentPlayer.setGrandTotal(0);
    		bankrupt = true;
    	}
    	else if(cardOnWheel.getType() == CardType.LoseATurn) {
    		loseTurn = true;
    	}
    	return cardPosition;
	}
	
	
	//changes players
	public static void changePlayer(int player) {
		Node temp = PlayerList.getHead();
		
		for(int x = 0;x<player;x++) {
			temp = temp.getNext();
		}
		currentPlayer = temp.getData();
		currentPlayer.setGrandTotal(0);

	}
	
	//changes round
	public static void changeRound(int round) {
		RoundNode temp = roundList.getHead();
		
		for(int x = 0;x<round;x++) {
			if(temp.getNext() !=null) {
				temp = temp.getNext();
			}
			
		}
		currentRound = temp.getData();
	}
	
	
	public static void addRounds() {
		Category Person = Category.Person;
		Category Thing = Category.Thing;
		Category Place = Category.Place;
		float roundTotal = 0; //all players in each round start with 0 points

		Round[] rounds = {
				//case matters for search so leave in lower case
				new Round(Person, roundTotal, "tomcruise"),
				new Round(Place, roundTotal, "jamaica"),
				new Round(Thing, roundTotal, "movie")
		};
		
		for(int i=0;i<3;i++) {
			roundList.InsertAtFront(rounds[i]);
		}
	}
	
	public static void addCards() {
		for(int i=0;i<23;i++) {
			cardWheel.insertAtEnd(cards[i]);
		}
		
		
	}
	public static void addPlayers() {
		String playerName;
		System.out.println("\t\tPLAYER REGISTRATION");
		for(int x = 0;x<3;x++) {
			System.out.println("Please enter the name of Player " + (x+1));
			playerName = in.next();
			Player newPlayer = new Player(x+1, playerName, 0);
			PlayerList.add(newPlayer);
			
		}
	}
}
