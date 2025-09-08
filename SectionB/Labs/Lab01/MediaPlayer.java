public class MediaPlayer{

	int volumeLevel=10;

	void volumeUp(){
		volumeLevel+=2;
	}

	void setVolume(int newVolume){
		if(newVolume>0)
		volumeLevel=newVolume;

	}


}