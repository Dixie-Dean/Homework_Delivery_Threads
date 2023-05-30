import java.util.Random;

public class Route extends Thread {
    private int rightTurns;

    @Override
    public synchronized void run() {
        String route = generateRoute();
        System.out.println("Right turns: " + countRightTurn(route));
    }

    private int countRightTurn(String route) {
        rightTurns = 0;
        for (int i = 0; i < route.length(); i++) {
            if (route.charAt(i) == 'R') {
                rightTurns++;
            }
        }
        return rightTurns;
    }

    private String generateRoute() {
        Random random = new Random();
        StringBuilder route = new StringBuilder();
        int length = 100;
        for (int i = 0; i < length; i++) {
            route.append("RLRFR".charAt(random.nextInt("RLRFR".length())));
        }
        return route.toString();
    }

    public boolean isEmpty() {
        return rightTurns == 0;
    }

    public int key() {
        return this.rightTurns;
    }
}
