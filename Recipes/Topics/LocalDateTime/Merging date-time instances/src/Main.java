import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ss = sc.nextLine().trim().sp;
        System.out.println(ss);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < ss.length(); i++) {
            list.add(String.valueOf(ss.charAt(i)));
        }

        String s = sc.next();

        System.out.println(Collections.frequency(list,s));

    }
}