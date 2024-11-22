public class VehicleFactory {
//    public static Vehicle createVehicle(VehicleType type) throws UndefinedVehicleException {
//        switch (type) {
//            case VehicleType.CAR:
//                return new Car();
//            case VehicleType.BUS:
//                return new Bus();
//            case VehicleType.MOTORBIKE:
//                return new Motorbike();
//            default:
//                throw new UndefinedVehicleException("Undefined vehicle type: " + type);
//        }
//    }

    public static Vehicle createVehicle(String type) throws UndefinedVehicleException {
        switch (type) {
            case "Car":
                return new Car();
            case "Bus":
                return new Bus();
            case "Motorbike":
                return new Motorbike();
            default:
                throw new UndefinedVehicleException("Undefined vehicle type: " + type);
        }
    }

}
