import java.util.*;
import java.io.*;
import javafx.scene.media.*;
public class mediaTest
{private void playMedia(Media m){
    if (m != null){
        MediaPlayer mp = new MediaPlayer(m);
        mp.play();
    }
}

public void playSomeSound(){
    try{
        Media someSound = new Media(getClass().getResource("neki.m4a").toString());
        playMedia(someSound);
    }catch(Exception ex){
        //GeeLogger.error(getClass(), ex.getLocalizedMessage(), ex);
    }

}
}
