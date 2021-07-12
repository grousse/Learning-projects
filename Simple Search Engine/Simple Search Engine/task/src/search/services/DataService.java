package search.services;

import search.services.FileReader;
import search.StrategyContext;

import java.util.*;

public class DataService extends StrategyContext {
    private static String wantedWord;


    @Override
    public void searchAll() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter a name or email to search all suitable people.");

        wantedWord = sc.nextLine().toLowerCase();
        String[] wantedWords = wantedWord.split(" ");

        Set<String> nameSet = new HashSet<>();

        for (int i = 0; i < FileReader.getData().size(); i++) {
            String[] words = FileReader.getData().get(i).split("\\s+");
            for (String word : words) {
                for (String s : wantedWords) {
                    if (s.equalsIgnoreCase(word)) {
                        nameSet.add(FileReader.getData().get(i));
                    }
                }
            }
        }
        System.out.println(nameSet.size() + " persons found:");
        nameSet.forEach(System.out::println);
    }

    @Override
    public void searchAny() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter a name or email to search all suitable people.");

        wantedWord = sc.nextLine().toLowerCase();
        String[] wantedWords = wantedWord.split(" ");

        Set<String> nameSet = new HashSet<>();

        for (int i = 0; i < FileReader.getData().size(); i++) {
            String[] words = FileReader.getData().get(i).split("\\s+");
            for (String word : words) {
                for (String s : wantedWords) {
                    if (s.equalsIgnoreCase(word)) {
                        nameSet.add(FileReader.getData().get(i));
                    }
                }
            }
        }
        System.out.println(nameSet.size() + " persons found:");
        nameSet.forEach(System.out::println);
    }

    @Override
    public void searchNone() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter a name or email to search all suitable people.");

        wantedWord = sc.nextLine().toLowerCase();
        String[] wantedWords = wantedWord.toLowerCase().split(" ");

        Set<String> nameSet = new HashSet<>();

        for (String s : FileReader.getData()) {
            if (s.toLowerCase().contains(wantedWords[0]) || s.toLowerCase().contains(wantedWords[1])) {

            } else {
                nameSet.add(s);

            }
        }

        System.out.println(nameSet.size() + " persons found:");
        nameSet.forEach(System.out::println);
    }

    public static String getWantedWord() {
        return wantedWord;
    }
}

