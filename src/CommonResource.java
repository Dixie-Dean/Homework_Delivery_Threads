import java.util.HashMap;
import java.util.Map;

public class CommonResource {
    public static final Map<Integer, Integer> sizeToFreq = new HashMap<>();

    public static synchronized void addToMap(Route route) throws InterruptedException {
        if (sizeToFreq.containsKey(route.getTurns())) {
            int newValue = sizeToFreq.get(route.getTurns());
            newValue++;
            sizeToFreq.replace(route.getTurns(), newValue);
        } else {
            sizeToFreq.put(route.getTurns(), 1);
        }
    }

    public static void submitResults() {
        int maxValue = 0;
        int maxKey = 0;
        for (Map.Entry<Integer, Integer> entry : sizeToFreq.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        System.out.println("\nThe value " + maxKey + " was the most common : " + maxValue + " times");
        sizeToFreq.forEach((key, value) -> System.out.println(key + " : " + value + " times"));
    }
}
