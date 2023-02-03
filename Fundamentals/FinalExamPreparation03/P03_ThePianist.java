package fundamentalsSeptember2022_FinalExam_Preparation;

import java.util.*;

public class P03_ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> piecesMap = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String[] pieceInfo = scanner.nextLine().split("\\|");

            String piece = pieceInfo[0];
            String composer = pieceInfo[1];
            String musicKey = pieceInfo[2];

            piecesMap.put(piece, new ArrayList<>());
            piecesMap.get(piece).add(composer);
            piecesMap.get(piece).add(musicKey);

        }
        String input = scanner.nextLine();

        while (!input.equals("Stop")) {
            String[] commandsArr = input.split("\\|");
            String command = commandsArr[0];
            String currentPiece = commandsArr[1];

            switch (command) {
                case "Add":
                    String currentComposer = commandsArr[2];
                    String currentKey = commandsArr[3];

                    if (!piecesMap.containsKey(currentPiece)){
                        piecesMap.put(currentPiece, new ArrayList<>());
                        piecesMap.get(currentPiece).add(currentComposer);
                        piecesMap.get(currentPiece).add(currentKey);
                        System.out.printf("%s by %s in %s added to the collection!%n", currentPiece, currentComposer,currentKey );

                    } else {
                        System.out.printf("%s is already in the collection!%n", currentPiece);

                    }
                    break;

                case "Remove":
                    if (piecesMap.containsKey(currentPiece)){
                        piecesMap.remove(currentPiece);
                        System.out.printf("Successfully removed %s!%n", currentPiece);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", currentPiece);
                    }
                    break;

                case "ChangeKey":
                    String newKey = commandsArr[2];

                    if (piecesMap.containsKey(currentPiece)){
                        piecesMap.get(currentPiece).set(1, newKey);
                        System.out.printf("Changed the key of %s to %s!%n",currentPiece, newKey );

                    } else{
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", currentPiece);
                    }

                    break;
            }

            input = scanner.nextLine();
        }
        for (Map.Entry<String, List<String>> entry : piecesMap.entrySet()) {
            String piece = entry.getKey();
            String composer = entry.getValue().get(0);
            String key = entry.getValue().get(1);

            System.out.printf("%s -> Composer: %s, Key: %s%n", piece, composer, key);
        }

    }
}
