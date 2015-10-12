import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

/**
 * A class to hold details of audio tracks.
@@ -15,7 +17,8 @@ public class MusicOrganizer
    private MusicPlayer player;
    // A reader that can read music files and load them as tracks.
    private TrackReader reader;

    // A random number generator
    private Random rand;
    /**
     * Create a MusicOrganizer
     */
@@ -24,6 +27,7 @@ public class MusicOrganizer
        tracks = new ArrayList<Track>();
        player = new MusicPlayer();
        reader = new TrackReader();
        rand = new Random();
        readLibrary("audio");
        System.out.println("Music library loaded. " + getNumberOfTracks() + " tracks.");
        System.out.println();
@@ -170,4 +174,27 @@ public class MusicOrganizer
            addTrack(track);
        }
    }
    
    public void playRandom()
    {
        this.playTrack(rand.nextInt(tracks.size()));
    }
    
    public void playRandomList()
    {
        ArrayList<Track>scrambledList = new ArrayList<Track>();
        for(int i=0; i < tracks.size(); i++){
            scrambledList.add(tracks.get(i));
        }//end for loop
        Collections.shuffle(scrambledList);
        for (int i = 0; i < scrambledList.size(); i++){
            if(indexValid(i)) {
            Track track = scrambledList.get(i);
            player.startPlaying(track.getFilename());
            System.out.println("Now playing: " + track.getArtist() + " - " + track.getTitle());
        }
        }//end for
    }//end method
               
    
}
