import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> stringSet = new HashSet<>();
        int numOfElements = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < numOfElements; i++) {
            stringSet.add(sc.nextLine().toLowerCase());
        }
        Set<String> wantedWords = new HashSet<>();

        int numOfWantedWordsLines = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < numOfWantedWordsLines; i++) {
           wantedWords.addAll(Arrays.asList(sc.nextLine().toLowerCase().split("\\s+")));
        }
        wantedWords.removeAll(stringSet);
        wantedWords.forEach(System.out::println);
    }
}