import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        time = LocalTime.of(0, 0, 2).plusSeconds(6078).getSecond();
        System.out.println(time);

    }
}