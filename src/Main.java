import java.util.HashMap;
import java.util.Map;

public class Main {

    public static final Map<Integer, Integer> sizeToFreq = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        Route route;

        for (int i = 0; i < 5; i++) {
            route = new Route();
            route.start();

            addToMap(route);
        }

        sizeToFreq.forEach((key, value) -> System.out.println(key + " : " + value + " times"));
    }

    public static synchronized void addToMap(Route route) {
        if (sizeToFreq.containsKey(route.key())) {
            int newValue = sizeToFreq.get(route.key());
            newValue++;
            sizeToFreq.replace(route.key(), newValue);
        } else {
            sizeToFreq.put(route.key(), 1);
        }
    }
}