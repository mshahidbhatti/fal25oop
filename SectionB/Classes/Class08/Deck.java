public class Deck{
	Card cards[];
	Deck(){
		cards=new Card[52];
		Suit suits[]=Suit.values();
		Rank ranks[]=Rank.values();
		int counter=0;
		for(int i=0;i<suits.length;i++)
			for(int j=0;j<ranks.length;j++)
				cards[counter++]=new Card(suits[i],ranks[j]);

	}

	public void display(){
		for(int i=0;i<52;i++)
			System.out.println(cards[i]);

	}

}