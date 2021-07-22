import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String seconds = sc.nextLine();

        LocalTime lc = LocalTime.parse(seconds);
            lc = LocalTime.of(lc.getHour(),lc.getMinute());
        System.out.println(lc);
    }
}