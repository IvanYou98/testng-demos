import org.testng.annotations.Test;

public class TestDependencies {
    @Test(priority = 1, groups = "priority")
    public void testCreateShipment() {
        int a = 1 / 0;
        System.out.println("Shipment is created!");
    }

    @Test(priority = 2, groups = "priority")
    public void testTrackShipment() {
        System.out.println("Tracking shipment!");
    }

    @Test(priority = 3, groups = "priority")
    public void testCancelShipment() {
        System.out.println("Cancel Shipment!");
    }

    @Test(groups = "depends")
    public void testCreateShipment1() {
        int a = 1 / 0;
        System.out.println("Shipment is created!");
    }

    @Test(dependsOnMethods = "testCreateShipment1", groups = "depends")
    public void testTrackShipment1() {
        System.out.println("Tracking shipment!");
    }


    @Test(dependsOnMethods = "testTrackShipment1", groups = "depends")
    public void testCancelShipment1() {
        System.out.println("Cancel shipment");
    }


    // group dependencies
    @Test(groups = "smoke")
    public void smoke1() {
        int a = 1 / 0;
        System.out.println("smoke1");
    }


    @Test(groups = "regression")
    public void regression1() {
        System.out.println("regression1");
    }

    @Test(groups = "regression")
    public void regression2() {
        System.out.println("regression2");
    }

    @Test(groups = "report", alwaysRun = true)
    public void report() {
        System.out.println("report");
    }
}
