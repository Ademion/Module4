import models.TestPlanes;
import planes.ExperimentalPlane;
import types.ClassificationTypes;
import types.MilitaryTypes;
import org.testng.Assert;
import org.testng.annotations.Test;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;

import java.util.List;

public class AirportTest {
    private static PassengerPlane planeWithMaxPassengerCapacity = new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);

    @Test
    public void testGetTransportMilitaryPlanes() {
        System.out.println("TEST testGetTransportMilitaryPlanes started!");
        Airport airport = new Airport(TestPlanes.planes);
        List<MilitaryPlane> transportMilitaryPlanes = airport.getTransportMilitaryPlanes();
        boolean TransportMilitaryPlanes = false;
        for (MilitaryPlane militaryPlane : transportMilitaryPlanes) {
            if ((militaryPlane.getType() == MilitaryTypes.TRANSPORT)) {
                TransportMilitaryPlanes = true;
                break;
            }
        }
        Assert.assertEquals(TransportMilitaryPlanes, true);
    }

    @Test
    public void testGetPassengerPlaneWithMaxCapacity() {
        System.out.println("TEST testGetPassengerPlaneWithMaxCapacity started!");
        Airport airport = new Airport(TestPlanes.planes);
        PassengerPlane expectedPlaneWithMaxPassengersCapacity = airport.getPassengerPlaneWithMaxPassengersCapacity();
        Assert.assertTrue(expectedPlaneWithMaxPassengersCapacity.equals(planeWithMaxPassengerCapacity));
    }

    @Test
    public void testPlaneMaxLoadCapacityIsHigherThanCurrent() {
        System.out.println("TEST testPlaneMaxLoadCapacityIsHigherThanCurrent started!");
        Airport airport = new Airport(TestPlanes.planes);
        airport.sortByMaxLoadCapacity();
        List<? extends Plane> planesSortedByMaxLoadCapacity = airport.getPlanes();

        boolean nextPlaneMaxLoadCapacityIsHigherThanCurrent = true;
        for (int i = 0; i < planesSortedByMaxLoadCapacity.size() - 1; i++) {
            Plane currentPlane = planesSortedByMaxLoadCapacity.get(i);
            Plane nextPlane = planesSortedByMaxLoadCapacity.get(i + 1);
            if (currentPlane.getMinLoadCapacity() > nextPlane.getMinLoadCapacity()) {
                nextPlaneMaxLoadCapacityIsHigherThanCurrent = false;
                break;
            }
        }
        Assert.assertTrue(nextPlaneMaxLoadCapacityIsHigherThanCurrent);
    }

    @Test
    public void testHasAtLeastOneBomberInMilitaryPlanes() {
        System.out.println("TEST testPlaneMaxLoadCapacityIsHigherThanCurrent started!");
        Airport airport = new Airport(TestPlanes.planes);
        List<MilitaryPlane> bomberMilitaryPlanes = airport.getBomberMilitaryPlanes();
        boolean hasBomberMilitaryPlanes = false;
        for (MilitaryPlane militaryPlane : bomberMilitaryPlanes) {
            if ((militaryPlane.getType() == MilitaryTypes.BOMBER)) {
                hasBomberMilitaryPlanes = true;
            }
        }
        Assert.assertTrue(hasBomberMilitaryPlanes);
    }

    @Test
    public void testExperimentalPlanesHasClassificationLevelHigherThanUnclassified(){
        System.out.println("TEST testExperimentalPlanesHasClassificationLevelHigherThanUnclassified started!");
        Airport airport = new Airport(TestPlanes.planes);
        List<ExperimentalPlane> ExperimentalPlanes = airport.getExperimentalPlanes();
        boolean hasUnclassifiedPlanes = false;
        for(ExperimentalPlane experimentalPlane : ExperimentalPlanes){
            if(experimentalPlane.getClassificationTypes() == ClassificationTypes.UNCLASSIFIED){
                hasUnclassifiedPlanes = true;
                break;
            }
        }
        Assert.assertFalse(hasUnclassifiedPlanes);
    }
}
