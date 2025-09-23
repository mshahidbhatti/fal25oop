//♠ ♥ ♦ ♣
public enum Suit{
	SPADES("Spades","♠"),HEARTS("Hearts","♥"), CLUBS("Clubs","♣"), DIAMONDS("Diamonds","♦");


	private final String name;
	private final String symbol;


	Suit(String name, String symbol){
		this.name=name;
		this.symbol=symbol;
	}
}