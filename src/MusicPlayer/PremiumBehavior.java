package MusicPlayer;

public class PremiumBehavior implements UserBehavior{
    private int month;

    public PremiumBehavior (int month){

        this.month =month;
    }

    //methods
    @Override
    public void createPlaylist (String Title, User Owner){
        Playlist newplaylist = new Playlist(Title, Owner);
        Owner.getPlaylists().add(newplaylist);

    }

    @Override
    public void playMusic (Music music){
        music.play();
    }

    @Override
    public void buyPremium (User owner, int month){

        this.month += month;
    }

}
