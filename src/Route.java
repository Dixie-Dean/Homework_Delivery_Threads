import java.util.Random;

public class Route implements Runnable {
    private int turns;
    CommonResource resource;

    public Route(CommonResource resource) {
        this.resource = resource;
    }

    @Override
    public synchronized void run() {
        String route = generateRoute();
        countRightTurn(route);

        try {
            resource.addToMap(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void countRightTurn(String route) {
        turns = 0;
        for (int i = 0; i < route.length(); i++) {
            if (route.charAt(i) == 'R') {
                turns++;
            }
        }
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
        return turns == 0;
    }

    public Integer getTurns() {
        return this.turns;
    }
}
