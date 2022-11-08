public class Flight {
    private int passengers;
    private int seats = 150;
    private static int allPassengers, maxPassengersPerFlight;
    private int flightNumber;
    private char flightClass;
    private boolean[] isSeatAvailable = new boolean[seats];

    static {
        AdminService admin = new AdminService()
        admin.connect();
        maxPassengersPerFlight = admin.isRestricted() ?
                admin.getMaxFlightPassengers() : Integer.MAX_VALUE;
        admin.close();
    }

    {
       for(int i = 0; i < seats; i++)
           isSeatAvailable[i] = true;
    }

    public Flight(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Flight(int flightClass) {
        this.flightClass = flightClass;
    }

    public Flight() {}

    public int getSeats(){
        return seats;
    }

    public void setSeats(int seats){
        this.seats = seats;
    }

    public static int getAllPassengers() {
        return allPassengers;
    }

    public static void resetAllPassengers() {
        allPassengers = 0;
    }

    public boolean hasRoom(Flight f2) {
        int total = this.passengers + f2.passengers;
        return total <= seats;
    }

    public void add1Passenger() {
        if(passengers < seats) {
            passengers += 1;
            allPassengers += 1;
        } else
            handleTooMany();
    }

    private void handleTooMany() {
        System.out.println("Too many");
    }
}


/*
Flight flight1 = new Flight();
Flight flight2 = new Flight();
flight2.add1Passenger();
*/