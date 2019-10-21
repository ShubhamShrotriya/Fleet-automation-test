package FleetTests.FeCheckout;

import FleetTests.AssetTrack.VehicleRegNumber;
import org.testng.annotations.Test;

public class EndRideRequest {


//    @BeforeTest
//    public void Hello(){
//        System.out.println("Hello Before Tests");
//    }

    @Test(priority = 1)
    public void getunderbookingvehicle() throws Exception {
        VehicleRegNumber.getUnderBookingVehicleQR();
        return;
    }

}
