public class Card{

	private final Suit suit;	
	private final Rank rank;

	Card(Suit suit, Rank rank){
		this.suit=suit;
		this.rank=rank;
	}

	public String toString(){

		return String.format("%s of %s",rank,suit);
	}

	public Rank getRank(){
		return rank;

	}


}