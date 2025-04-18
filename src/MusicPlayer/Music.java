package MusicPlayer;

import java.util.ArrayList;

public class Music {
    private String title;
    private User singer;
    private int numberOfStream ;
    public static ArrayList<Music> allMusics = new ArrayList<>();

    public Music (String title, User singer){
        this.title = title;
        this.singer = singer;
        this.numberOfStream = 0;
        allMusics.add(this);
    }

    //methods
    public void play(){
        System.out.println("Play music : " + this.title + " Singer : " + this.singer.getUsername());
        numberOfStream ++;
    }

    public static ArrayList<Music> search(String title){
        ArrayList<Music> searchResult = new ArrayList<>();
        for (Music music :allMusics) {
            if (music.title.equals(title))
                searchResult.add(music);
        }
            return searchResult;
        }

        public static Music search(String title, String singerName){
        for (Music music : allMusics) {
            if (music.title.equals(title) && music.singer.getUsername().equals(singerName))
                return music;
        }
        return null;
        }


    // getter & setter
    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public User getSinger() {
        return singer;
    }

    public void setSinger(User singer){
        this.singer = singer;
    }

    public int getNumberOfStream(){
        return numberOfStream;
    }

    public void setNumberOfStream(int numberOfStream){
        this.numberOfStream = numberOfStream;
    }

    public static ArrayList<Music> getAllMusics(){
        return allMusics;
    }
}
