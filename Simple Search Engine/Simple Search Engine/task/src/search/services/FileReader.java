package search.services;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileReader {
    private static List<String> data = new ArrayList<>();

    public static void fileRead(File file) {
        Scanner sc = null;
        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                data.add(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        sc.close();
    }



    public static void printAllData() {
        data.forEach(System.out::println);
    }

    public static List<String> getData() {
        return data;
    }
}