package MusicPlayer;

import java.util.ArrayList;
import java.util.Collections;

public class Playlist {
    private String title;
    // اهنگ های موجود در پلی لیست
    private ArrayList<Music> playlist = new ArrayList<>();
    // صاحب پلی لیست
    private User Owner;

    public Playlist(String title, User Owner){
        this.title = title;
        this.Owner = Owner;
    }

    //methods

    public void addMusic (Music music, String password) throws InvalidOperationException {
        if (!Owner.getPassword().equals(password)) {
            throw new InvalidOperationException("Incorrect password!");
        }
        if (playlist.contains(music)) {
            throw new InvalidOperationException("You have this music! so can not add it.");
        }
        playlist.add(music);
    }

    public void removeMusic (Music music, String password) throws InvalidOperationException{
        if (!Owner.getPassword().equals(password)) {
            throw new InvalidOperationException("Incorrect password!");
        }
        if (! playlist.contains(music)){
            throw new InvalidOperationException(music +" music not found");
        }
        playlist.remove(music);
    }

    public void editMusic ( Music music, String newTitle, String password) throws InvalidOperationException{
        if (!Owner.getPassword().equals(password)) {
            throw new InvalidOperationException("Incorrect password!");
        }
        if (! playlist.contains(music)){
            throw new InvalidOperationException(music +" Music not found in the playlist!");
        }
        music.setTitle(newTitle);
    }

    // Method to search music in the playlist by title
    public ArrayList<Music> searchInPlaylist(String title){
        ArrayList<Music> searchResult = new ArrayList<>();
        for (Music music : playlist){
            if (music.getTitle().equals(title))
                searchResult.add(music);
        }
        return searchResult;
    }

    // Method to play all the music in the playlist
    public void playPlaylist() {
        for (Music music : playlist) {
            music.play();
        }
    }

    public void shuffle(){
        //رندوم جا به جا کردن شون
        Collections.shuffle(playlist);
        //پخش
        playPlaylist();

    }

    //getter & setter
    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public ArrayList<Music> getPlaylist(){
        return playlist;
    }

    public void setPlaylist(ArrayList<Music> playlist){
        this.playlist = playlist;
    }
    public User getOwner(){
        return Owner;
    }

    public void setOwner(User Owner){
        this.Owner =Owner;
    }

}
