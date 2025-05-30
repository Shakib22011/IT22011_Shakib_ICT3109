public class ParkingAgent extends Thread {
    private final ParkingQueue pool;
    private final String agentName;

    public ParkingAgent(String agentName, ParkingQueue pool) {
        this.agentName = agentName;
        this.pool = pool;
    }

    @Override
    public void run() {
        while (true) {
            RegistarParking request = pool.getParkingRequest();
            if (request != null) {
                System.out.println(agentName + " is processing Car " + request.getCarId());
                request.process();
            }
        }
    }
}
