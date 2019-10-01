package FleetTests.AssetTrack;

import Utilities.Constants;

public class getvehiclebasedonstatus {

    public static String GetVehiclesBasedOnStatus() throws Exception {
        String vehicleStatus = data.getvehiclestatus();
        String vehicle_reg_number = null;
        if (vehicleStatus.equals(Constants.AVAILABLE_FOR_BOOKING)) {

            vehicle_reg_number= VehicleRegNumber.GetInventoryAtStation();

            System.out.println(vehicle_reg_number);



        }
        return (vehicle_reg_number);
    }
}
