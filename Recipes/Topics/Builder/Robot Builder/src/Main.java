import java.util.Scanner;

class Robot {

    private String CPU;
    private int legs;
    private int hands;
    private int eyes;

    Robot(String CPU, int legs, int hands, int eyes) {
        this.CPU = CPU;
        this.legs = legs;
        this.hands = hands;
        this.eyes = eyes;
    }

    public static class RobotBuilder {

        /* write your code here (fields) */
        private String CPU;
        private int legs;
        private int hands;
        private int eyes;

        public RobotBuilder() {
        }

        public void setCPU(String CPU) {
            this.CPU = CPU;
        }

        public void setLegs(int legs) {
            this.legs = legs;
        }

        public void setHands(int hands) {
            this.hands = hands;
        }

        public void setEyes(int eyes) {
            this.eyes = eyes;
        }

        Robot build() {
          return new Robot(CPU,legs,hands,eyes);
        }
    }

    @Override
    public String toString() {
        return "CPU : " + CPU + "\n" +
                "Legs : " + legs + "\n" +
                "Hands : " + hands + "\n" +
                "Eyes : " + eyes + "\n";
    }
}

class TestDrive {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final Robot.RobotBuilder robotBuilder = new Robot.RobotBuilder();
        /* Set CPU */
        robotBuilder.setCPU("Intel Core i5");
        /* Would like to set legs? */
        int legs = scanner.nextInt();
        robotBuilder.setLegs(legs);
        int hands = scanner.nextInt();
        /* Would like to set eyes? */
        robotBuilder.setHands(hands);
        int eyes = scanner.nextInt();
        robotBuilder.setEyes(eyes);

        
        Robot robot = robotBuilder.build();

        System.out.println(robot);
        scanner.close();
    }
}
