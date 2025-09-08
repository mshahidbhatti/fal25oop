public class MediaPlayerTest{


   public static void main(String[] args){

		MediaPlayer mp1=new MediaPlayer();
		MediaPlayer mp2=new MediaPlayer();

		mp2.volumeLevel=-20;
		mp1.volumeUp();
		mp1.setVolume(-100);

		System.out.println(mp1.volumeLevel);


  }
}