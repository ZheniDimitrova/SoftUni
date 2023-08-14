package programmingBasicsExams;

import java.util.Scanner;

public class SeriesCalculator01_June2019 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String serialName = scanner.nextLine();
        int seasons = Integer.parseInt(scanner.nextLine());
        int episodes = Integer.parseInt(scanner.nextLine());
        double timeOneEpisodeWithoutAdd = Double.parseDouble(scanner.nextLine());
        double episodeWithAdds = timeOneEpisodeWithoutAdd + timeOneEpisodeWithoutAdd * 0.2;
        double specialEpisodesTime = seasons *10;

        double totalTime = seasons * episodes * episodeWithAdds + specialEpisodesTime;

        System.out.printf("Total time needed to watch the %s series is %.0f minutes.", serialName, totalTime );
    }
}
