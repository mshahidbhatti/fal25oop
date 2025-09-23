public class Game{

	Player players[];
	Deck deck;

	Game(int numberOfPlayer){
		deck=new Deck();
		deck.shuffle();

		players=new Player[numberOfPlayer];
		players[0]=new Player(52/numberOfPlayer);

	}


	

}