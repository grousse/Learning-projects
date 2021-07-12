import java.util.Scanner;

class NumbersFilter extends Thread {

    /* use it to read numbers from the standard input */
    private final Scanner scanner = new Scanner(System.in);

    Thread w1 = new Thread(new NumbersFilter(), "w1");


    @Override
    public void run() {
        while (true) {
            int num = scanner.nextInt();
            if(num % 2 == 0) {
                System.out.println(w1.getName());
            } if (num == 0) {
                break;
            }
        }
    }
}