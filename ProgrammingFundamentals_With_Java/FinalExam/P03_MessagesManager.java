package fundamentalsSeptember2022_FinalExam_Dec04;

import java.util.*;

public class P03_MessagesManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int capacity = Integer.parseInt(scanner.nextLine());

        Map<String, List<Integer>> messagesMap = new LinkedHashMap<>();

        String lineInput = scanner.nextLine();

        while (!lineInput.equals("Statistics")) {
            String[] commandsArr = lineInput.split("=");
            String command = commandsArr[0];

            switch (command) {
                case "Add":
                    String username = commandsArr[1];
                    int sent = Integer.parseInt(commandsArr[2]);
                    int received = Integer.parseInt(commandsArr[3]);

                    if (!messagesMap.containsKey(username)){
                        messagesMap.put(username, new ArrayList<>());
                        messagesMap.get(username).add(sent);
                        messagesMap.get(username).add(received);
                    }
                    break;

                case "Message":
                    String sender = commandsArr[1];
                    String receiver = commandsArr[2];

                    if (messagesMap.containsKey(sender) && messagesMap.containsKey(receiver)){
                        messagesMap.get(sender).set(0, messagesMap.get(sender).get(0) +1);
                        messagesMap.get(receiver).set(1, messagesMap.get(receiver).get(1) +1);
                    } else if (!messagesMap.containsKey(sender) || !messagesMap.containsKey(receiver)){
                        break;
                    }

                    if (messagesMap.get(sender).get(0) + messagesMap.get(sender).get(1) >= capacity){
                        messagesMap.remove(sender);
                        System.out.printf("%s reached the capacity!%n", sender);
                    }
                    if (messagesMap.get(receiver).get(0) + messagesMap.get(receiver).get(1) >= capacity){
                        messagesMap.remove(receiver);
                        System.out.printf("%s reached the capacity!%n", receiver);
                    }

                    break;

                case "Empty":
                    String usernameOrAll = commandsArr[1];

                    if (usernameOrAll.equals("All")){

                        messagesMap.clear();

                    } else {
                       messagesMap.remove(usernameOrAll);
                    }
                    break;
            }


            lineInput = scanner.nextLine();
        }
        int usersCount = messagesMap.size();

        System.out.printf("Users count: %d%n", usersCount);
        for (Map.Entry<String, List<Integer>> entry : messagesMap.entrySet()) {
            String user = entry.getKey();
            int allMessages = entry.getValue().get(0) + entry.getValue().get(1);

            System.out.printf("%s - %d%n", user, allMessages);

        }

    }
}
