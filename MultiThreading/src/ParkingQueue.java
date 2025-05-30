import java.util.LinkedList;
import java.util.Queue;

public class ParkingQueue {
    private final Queue<RegistarParking> queue = new LinkedList<>();

    public synchronized void addParkingRequest(RegistarParking request) {
        queue.offer(request);
        notifyAll();
    }

    public synchronized RegistarParking getParkingRequest() {
        while (queue.isEmpty()) {
            try {
                wait(); // Wait if no request
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return null;
            }
        }
        return queue.poll();
    }
}
