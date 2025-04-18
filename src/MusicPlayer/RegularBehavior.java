package MusicPlayer;

public class RegularBehavior implements UserBehavior{
    //تعداد پلی های باقی مانده
    private int playingLimit = 5;

    //methods
    @Override
    public void createPlaylist (String Title, User Owner) throws InvalidOperationException{
        throw new InvalidOperationException("Sorry , only Premium user can create playlist!");
    }

    @Override
    public void playMusic (Music music) throws InvalidOperationException{
        if (playingLimit <= 0)
            throw new InvalidOperationException("You can only play 5 music not more.");
        music.play();
        playingLimit --;
    }

    @Override
    public void buyPremium (User owner, int month){

    }
    


}
