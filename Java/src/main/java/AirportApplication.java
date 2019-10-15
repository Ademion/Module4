import models.PlaneList;

public class AirportApplication {

    public static void main(String[] args) {
        Airport airport = new Airport(PlaneList.planes);
        Airport militaryAirport = new Airport(airport.getMilitaryPlanes());
        Airport passengerAirport = new Airport(airport.getPassengerPlanes());
        System.out.println("Military airport sorted by max distance: " + militaryAirport
                .sortByMaxDistance()
                .toString());
        System.out.println("Passenger airport sorted by max speed: " + passengerAirport
                .sortByMaxSpeed()
                .toString());

        System.out.println("Passenger plane with max passenger capacity: " + passengerAirport.getPassengerPlaneWithMaxPassengersCapacity());
    }
}
