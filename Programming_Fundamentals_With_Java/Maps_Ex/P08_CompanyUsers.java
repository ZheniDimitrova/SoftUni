package fundamentalsSeptember2022_07AssociativeArraysLambdaStreamAPI_Exercises;

import java.util.*;

public class P08_CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<String>> companiesMap = new LinkedHashMap<>();

        while (!input.equals("End")) {
            String[] dataArr = input.split(" -> ");
            String companyName = dataArr[0];
            String id = dataArr[1];

            if (!companiesMap.containsKey(companyName)) {
                companiesMap.put(companyName, new ArrayList<>());
                companiesMap.get(companyName).add(id);

            } else {
                if (!companiesMap.get(companyName).contains(id)) {
                    companiesMap.get(companyName).add(id);
                }
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, List<String>> entry : companiesMap.entrySet()) {
            String company = entry.getKey();
            List<String> idsList = entry.getValue();

            System.out.printf("%s%n", company);

            for (String id : idsList) {
                System.out.printf("-- %s%n", id);
            }
        }
    }
}
