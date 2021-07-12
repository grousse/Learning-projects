package search;

import search.services.FileReader;
import search.services.Menu;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File file = new File("names.txt");
        FileReader.fileRead(file);
        Menu.startMenu();
    }

}