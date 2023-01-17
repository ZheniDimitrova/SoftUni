package p02_articles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String articleInput = scanner.nextLine();

        String title = articleInput.split(", ")[0];
        String content = articleInput.split(", ")[1];
        String author = articleInput.split(", ")[2];

        Article article = new Article(title, content, author);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String command = scanner.nextLine();

            if (command.contains("Edit")) {
                String newContent = command.split(": ")[1];
                article.edit(newContent);
            } else if (command.contains("ChangeAuthor")) {
                String newAuthor = command.split(": ")[1];
                article.author(newAuthor);
            } else if (command.contains("Rename")) {
                String newAuthor = command.split(": ")[1];
                article.rename(newAuthor);
            }

        }
        System.out.println(article);

    }
}

