import java.util.Scanner;

class MessageNotifier extends Thread {

    // write fields to store variables here
    String msg;
    int repeats;

    public MessageNotifier(String msg, int repeats) {
        this.msg = msg;
        this.repeats = repeats;
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        String msg = sc.nextLine();
        int repeats = sc.nextInt();

        MessageNotifier t = new MessageNotifier(msg,repeats);

        for(int i = 0 ; i < repeats; i++) {
            System.out.println(msg);
        }

    }
}