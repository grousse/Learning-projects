import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        int myNumber = sc.nextInt();
        ArrayList<Integer> ints = new ArrayList<>();
        for (String s : arr) {
            ints.add(Integer.valueOf(s));
        }
        Collections.sort(ints);

        ArrayList<Integer> res = new ArrayList<>();

        boolean isFoundClosest = false;
        for (int i = 0; !isFoundClosest; i++) {
            for (int x : ints) {
                if (x == myNumber + i || x == myNumber - i) {
                    res.add(x);
                    isFoundClosest = true;
                }
            }
        }
        Collections.sort(res);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
