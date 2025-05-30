public class RegistarParking {
    private static int count = 1;
    private final int carId;

    public RegistarParking() {
        this.carId = count++;
    }

    public int getCarId() {
        return carId;
    }

    public void process() {
        System.out.println(" Car " + carId + " is being parked...");
        try {
            Thread.sleep(1000); // Simulate parking time
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(" Car " + carId + " has been parked.\n");
    }
}
