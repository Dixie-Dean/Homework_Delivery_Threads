public class Main {

    public static void main(String[] args) throws InterruptedException {
        CommonResource commonResource = new CommonResource();
        Route route = new Route(commonResource);

        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(route);
            thread.setName("Thread: " + i);
            thread.start();
        }

        Thread.sleep(10);

        commonResource.submitResults();
    }
}