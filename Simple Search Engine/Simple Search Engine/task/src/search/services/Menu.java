package search.services;

import java.util.Scanner;

public class Menu {
    public static void startMenu(){
        DataService dataService = new DataService();
        Scanner sc = new Scanner(System.in);
        boolean exit = true;
        while (exit) {
            System.out.println("=== Menu ===\n" +
                    "1. Search information.\n" +
                    "2. Print all data.\n" +
                    "0. Exit.");


            String option = sc.nextLine();

            switch (option) {
                case "1":
                    System.out.println("Select a matching strategy: ALL, ANY, NONE");
                    String strategyOption = sc.nextLine().toLowerCase();
                    switch (strategyOption) {
                        case "all":
                            dataService.searchAll();
                            break;
                        case "any": dataService.searchAny();;
                            break;
                        case "none": dataService.searchNone();
                            break;
                        default:
                            System.out.println("Incorrect option! Try again.");
                    }
                    break;
                case "2":
                    FileReader.printAllData();
                    break;
                case "0":
                    System.out.println("Bye!");
                    exit = false;
                    break;
                default: System.out.println("Incorrect option! Try again.");
            }
        }
    }
}
