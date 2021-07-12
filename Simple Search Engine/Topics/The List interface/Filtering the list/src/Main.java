import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> integers = new ArrayList<>();
        String[] arr = sc.nextLine().split(" ");
        for (int i = 0; i < arr.length; i++) {
            int j = Integer.parseInt(arr[i]);
            if (i % 2 != 0) {
                integers.add(j);
            }
        }

        Collections.reverse(integers);
        integers.forEach(integer -> System.out.print(integer + " "));
    }
}