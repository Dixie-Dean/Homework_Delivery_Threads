import java.util.HashMap;
import java.util.Map;

public class CommonResource {
    public static final Map<Integer, Integer> sizeToFreq = new HashMap<>();

    public static void addToMap(Route route) throws InterruptedException {
        synchronized (CommonResource.class) {
            if (sizeToFreq.containsKey(route.getTurns())) {
                int newValue = sizeToFreq.get(route.getTurns());
                newValue++;
                sizeToFreq.replace(route.getTurns(), newValue);
            } else {
                sizeToFreq.put(route.getTurns(), 1);
            }
            CommonResource.class.notify();
        }
    }

    public static void submitResults() throws InterruptedException {
        synchronized (CommonResource.class) {
            CommonResource.class.wait();
            int maxValue = 0;
            int maxKey = 0;
            for (Map.Entry<Integer, Integer> entry : sizeToFreq.entrySet()) {
                if (entry.getValue() > maxValue) {
                    maxValue = entry.getValue();
                    maxKey = entry.getKey();
                }
            }
            System.out.println("The most common value for now: " + maxKey + " | encountered: " + maxValue + " times");
        }
    }

    public static void submitResultsFinal() {
        int maxValue = 0;
        int maxKey = 0;
        for (Map.Entry<Integer, Integer> entry : sizeToFreq.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        System.out.println("\nThe most common value: " + maxKey + " | encountered: " + maxValue + " times");
        sizeToFreq.forEach((key, value) -> System.out.println("Value: " + key + " | encountered: " + value + " times"));
    }
}
