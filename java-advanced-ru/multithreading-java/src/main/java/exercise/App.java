package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] nums) {
        Map<String, Integer> result = new HashMap<>();
        MaxThread maxThread = new MaxThread(nums);
        MinThread minThread = new MinThread(nums);
        maxThread.start();
        LOGGER.log(Level.INFO, "Thread " + maxThread.getName() + " started");
        minThread.start();
        LOGGER.log(Level.INFO, "Thread " + minThread.getName() + " started");
        try {
            maxThread.join();
            LOGGER.log(Level.INFO, "Thread " + maxThread.getName() + " stopped");
            minThread.join();
            LOGGER.log(Level.INFO, "Thread " + minThread.getName() + " stopped");
        } catch (InterruptedException e) {
            System.out.println("Thread is stopped");
        }
        result.put("max", maxThread.getMaxNumber());
        result.put("min", minThread.getMinNumber());
        return result;
    }
    // END
}
