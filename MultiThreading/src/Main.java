import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ParkingQueue pool = new ParkingQueue();

        // Start 3 parking agents
        new ParkingAgent("Agent-1", pool).start();
        new ParkingAgent("Agent-2", pool).start();
        new ParkingAgent("Agent-3", pool).start();

        Scanner scanner = new Scanner(System.in);
        int requestCount = 0;

        while (requestCount < 10) {
            System.out.println("\nPress Enter to simulate car arrival (type -1 to exit):");
            String input = scanner.nextLine();
            if (input.equals("-1")) {
                System.out.println("Exiting...");
                break;
            }

            RegistarParking parkingRequest = new RegistarParking();
            pool.addParkingRequest(parkingRequest);
            System.out.println(" Car " + parkingRequest.getCarId() + " has arrived for parking.\n");
            requestCount++;
        }

        scanner.close();
    }
}
