package exercise;

import java.util.logging.Logger;

// BEGIN
public class ListThread extends Thread {
    private SafetyList safetyList;

    public ListThread(SafetyList safetyList) {
        this.safetyList = safetyList;
    }

    @Override
    public void run() {
        int i = 0;
        while (i < 1000) {
            try{
                Thread.sleep(1L);
            } catch (InterruptedException e) {
                Logger.getLogger("Error: " + e + safetyList.get(i));
            }
            safetyList.add(i);
            i++;
        }
    }
}
// END
