import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[]arr = new int[sc.nextInt()];
        int i = 0;
        int result = 0;
        while (sc.hasNext()) {
            arr[i] = sc.nextInt();
            i++;
        }

        for (int i1 : arr) {
            if (i1 % 4 == 0 && i1 > result) {
                result = i1;
            }
        }
        System.out.println(result);
    }
}
