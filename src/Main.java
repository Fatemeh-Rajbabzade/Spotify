package MusicPlayer;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            // ساخت یک کاربر عادی
            User user1 = new User("user1", "password123");
            User user2 = new User("user2", "password456");

            // ساخت چند موزیک
            Music music1 = new Music("Song 1", user1);
            Music music2 = new Music("Song 2", user1);
            Music music3 = new Music("Song 3", user2);

            // ساخت پلی‌لیست برای user1
            Playlist playlist1 = new Playlist("My Playlist", user1);

            // اضافه کردن موزیک‌ها به پلی‌لیست
            playlist1.addMusic(music1, "password123");
            playlist1.addMusic(music2, "password123");

            // اضافه کردن موزیک تکراری
            try {
                playlist1.addMusic(music1, "password123");
            } catch (InvalidOperationException e) {
                System.out.println(e.getMessage());
            }

            //  اضافه کردن موزیک با پسورد اشتباه
            try {
                playlist1.addMusic(music3, "wrongpassword"); // اشتباه: پسورد اشتباه
            } catch (InvalidOperationException e) {
                System.out.println(e.getMessage());
            }

            // پخش پلی‌لیست
            System.out.println("Playing Playlist:");
            playlist1.playPlaylist();

            // ویرایش عنوان موزیک
            playlist1.editMusic(music2, "Song 2 Edited", "password123");

            // جستجو در پلی‌لیست
            ArrayList<Music> searchResult = playlist1.searchInPlaylist("Song 2 Edited");
            System.out.println("Search result:");
            for (Music m : searchResult) {
                System.out.println("Found: " + m.getTitle());
            }

            // حذف موزیک از پلی‌لیست
            playlist1.removeMusic(music1, "password123");

            // سعی در حذف موزیک از پلی‌لیست با پسورد اشتباه
            try {
                playlist1.removeMusic(music1, "wrongpassword"); // اشتباه: پسورد اشتباه
            } catch (InvalidOperationException e) {
                System.out.println(e.getMessage());
            }

            // نمایش پلی‌لیست پس از حذف
            System.out.println("After removing a song:");
            playlist1.playPlaylist();

            // تست shuffle
            System.out.println("Shuffling Playlist:");
            playlist1.shuffle();

        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }
    }
}
