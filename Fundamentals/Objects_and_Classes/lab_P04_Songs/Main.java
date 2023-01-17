package lab_P04_Songs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfSongs = Integer.parseInt(scanner.nextLine());
        List<Song> songList = new ArrayList<>();

        for (int i = 1; i <= numberOfSongs; i++) {
            String[] data = scanner.nextLine().split("_");

            String type = data[0];
            String name = data[1];
            String time = data[2];

            Song currentSong = new Song(type, name, time);
            songList.add(currentSong);
        }
        String typeInput = scanner.nextLine();

        if (typeInput.equals("all")) {
            for (Song song : songList) {
                System.out.println(song.getName());
            }
        } else {
            for (Song song : songList) {
                if (song.getTypeList().equals(typeInput)) {
                    System.out.println(song.getName());
                }
            }

        }
    }
}
