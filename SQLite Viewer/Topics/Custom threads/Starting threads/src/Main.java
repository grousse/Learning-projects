public class Main {

    public static void main(String[] args) {
        Thread w1 = new Thread(new RunnableWorker(), "worker-1");
        Thread w2 = new Thread(new RunnableWorker(), "worker-2");
        Thread w3 = new Thread(new RunnableWorker(), "worker-3");

        w1.start();
        w2.start();
        w3.start();

    }
}

// Don't change the code below       
class RunnableWorker implements Runnable {


    @Override
    public void run() {
        final String name = Thread.currentThread().getName();

        if (name.startsWith("worker-")) {
            System.out.println("too hard calculations...");
        } else {
            return;
        }
    }
}